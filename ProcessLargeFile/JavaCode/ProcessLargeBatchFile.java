package Algo.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Rajesh Kumar
 * This program assumes that provided file is a valid file with proper data. File contains following employee data.
 * First name, Last name, Gender, Salary with separated by character '|' as shown in this sample data.
 * Example of one line in file: John|Smith|M|200000
 * This process with read data from the file and store in the two different My SQL database Employee and Salary tables.
 * This takes less than 30 minutes to process a file, which contains 1 million records in file.
 * This program uses multi threading to process file and data.
 * This process will create small batch file from the large file and process the small batch file to add data in database.
 * Once all of the batch file processed then it will delete the small batch file from the disk.
 */
public class ProcessLargeBatchFile {

    private final static String NEW_LINE = System.getProperty("line.separator");
    private final static String LARGE_FILE_PATH = "D:/Temp/FileSplit/Big/ProcessData.txt";  //Large File path with 1 million records
    private final static int NUM_LINES_IN_SPLIT_SIZE = 100000; // Number of lines in file when this code splits large file to small file
    private final static int DATA_PROCESSING_BATCH_SIZE = 5000; //Batch size to add record in the database    
    
    /**
     * Main method to run this program
     * @param args
     */
    public static void main(String[] args) {
	 		
		 try {
			 
			 //To track the time print process start time
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println("Start Time : " + dateFormat.format(date)); //2016/11/16 12:08:43		
			 
			 File file = new File(LARGE_FILE_PATH);
			 
			 //Check if file exists before processing.
			 if(file.exists()){
				 readFileData(LARGE_FILE_PATH, NUM_LINES_IN_SPLIT_SIZE); //Start the process by calling readFileData method
				 System.out.println("Successfully data added to DB after reading the file : " + LARGE_FILE_PATH);
			 }
			 else
				 System.out.println("File doesnot exists: " + LARGE_FILE_PATH);
		     
		     //Print process start time
			 date = new Date();
			 System.out.println("End Time : " + dateFormat.format(date));
			 
		 } catch (IOException e) {
		     e.printStackTrace();
		 }
    }    
   
    
    /**
     * This method takes large file path and number of lines required in the each small 
     * split files and splits large file in small file.
     * @param filename
     * @param lines
     * @throws IOException
     */
    public static void readFileData(String filename, int lines) throws IOException {
    	
    	try {
    		// Initialize buffer reader with File reader object and other local member variables.
		     BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)); 
		     StringBuffer stringBuffer = new StringBuffer();	
		     List<String> fileList = new ArrayList<String>();
		     String line;
		     int batchSizeTrack = 0;
		     int counter = 1;
		     
		     //start read the large file until reach the endo file.
		     while ((line = bufferedReader.readLine()) != null) {
				  stringBuffer.append(line);	//append line to the local buffer.
				  stringBuffer.append(NEW_LINE);//append new line at the end of the each line.
				  batchSizeTrack++; 			// increment batch size tracker
				  
				  //batchSizeTrack is reached the number of expected line in the split file size then 
				  //enter the if loop and create the split file and reset, update the tracker and local variables.
				  if (batchSizeTrack >= lines) {
					  
					  String newFileNameWithPath = filename + counter;
					  createFile(stringBuffer, newFileNameWithPath);
					  fileList.add(newFileNameWithPath);	//Store all split batch file name with full path in a list.
				      stringBuffer = new StringBuffer();
				      batchSizeTrack = 0;
				      counter++;
				  }
		     }
		     
		     //This if loop require to create the last batch file, which might less lines as compare to defined line of split file size
		     if(batchSizeTrack > 0) {
		    	 String lastFileNameWithPath = filename + counter;
				  createFile(stringBuffer, lastFileNameWithPath);
				  fileList.add(lastFileNameWithPath);			      		     
		     }
		     
		     bufferedReader.close();	//Close and destroy the Buffer Reader object
		     
		     try {
		    	 //Send list of batch file names to sendFileListToAddData() method to process all of the batch.
		    	 //We are wrapping this in try catch block because sendFileListToAddData() method throws InterruptedException
		    	 ProcessLargeBatchFile splitFile = new ProcessLargeBatchFile();
		    	 splitFile.sendFileListToAddData(fileList);
			} catch (InterruptedException e) {
				e.printStackTrace();
				//TODO: take appropriate logging and error handling action here.
			}
		} 
    	catch (IOException e) {
    		//TODO: take appropriate logging and error handling action here.
		     throw new IOException("read file error " + filename);
    	}
    }
    
    /**
     * This method takes the small size buffer from the large file and create the small size batch file.
     * @param stringBuffer
     * @param filename
     */
    private static void createFile(StringBuffer stringBuffer, String filename) {
    	
    	 //Initialize the local variables for creating small batch file.
		 String path = (new File(filename)).getAbsolutePath(); //Get Absolute Path of large file
		 File file = new File(path);
		 FileWriter output = null;
		 
		 try {
			 //It is require to wrap in try. catch block because it throws IO Exception
			 //Initialize file writer to the buffer in the small batch file.
		     output = new FileWriter(file);
		     output.write(stringBuffer.toString());
		 } catch (IOException e) {
		     e.printStackTrace();
		   //TODO: take appropriate logging and error handling action here.
		 } finally {		
		     try {
		    	 output.close();
		     } catch (IOException e) {
		 		System.err.println("Error :" + e.getMessage());
		 		//TODO: take appropriate logging and error handling action here.
		     }
		 }
    }    
    
    /**
     * This method create a separated thread for each file to process data in parallel mode.
     * @param fileList
     * @throws IOException
     * @throws InterruptedException
     */
    private void sendFileListToAddData(List<String> fileList) throws IOException, InterruptedException{
    	
    	try{    		
    		
    		Thread[] threads = new Thread[fileList.size()]; //Create a array of thread equivalent size to the total number of split files.   		
    		int index = 0;	//Local variable to access Thread array via index.
    		
    		//For each split batch file create a runnable thread and start running in separate thread by calling sendFileToAddData() method,
    		//which will read each split batch file for further processing.
    		for(String fileNameWithPath : fileList){
    			threads[index] = new Thread(){  
        			public void run(){  
	        				try {
	        					ProcessLargeBatchFile splitFile = new ProcessLargeBatchFile();
								splitFile.sendFileToAddData(fileNameWithPath, DATA_PROCESSING_BATCH_SIZE);
							} catch (IOException e) {							
								e.printStackTrace();
								//TODO: take appropriate logging and error handling action here.
							}  
        				}  
        			}; 
        		
	    			threads[index].start();	// Start each runnable thread to process split batch file.
	    			index++;	//Increment the index variable to to move to the next thread to start.
    		}

    		//Call join method on each thread for batch processing, which allows one thread to wait 
    		//for the completion of another. If threads are Thread object whose thread is currently executing.    		
    		for (int i = 0 ; i < threads.length ; i++) {
    			try {    				
					threads[i].join();					
				} catch (InterruptedException e) {
					e.printStackTrace();
					//TODO: take appropriate logging and error handling action here.
				}
    		}    		
    	
	    	System.out.println("Successfully data added to DB after file split.");
	    	
	    	//Create runnable object for each batch file and call delete method on each file and delete from the disk.
    		Runnable runSecond = () -> {
    			
    	    	for(String fileNameWithPath : fileList){
    	    		File file = new File(fileNameWithPath);
					file.deleteOnExit();					
    	    	}
    		};
    		
    		//Create a array of thread equivalent array to the total number of split files. This is to delete file from disk.
    		Thread[] threadsRemoveFiles = new Thread[fileList.size()];
    		
    		//Start each thread to delete the file from disk.
    		for (int i = 0 ; i < threadsRemoveFiles.length ; i++) {
    			threadsRemoveFiles[i] = new Thread(runSecond);
    			threadsRemoveFiles[i].start();
    		}
    		
    		//Call join method on each thread for batch file deletion
    		for (int i = 0 ; i < threadsRemoveFiles.length ; i++) {
    			try {
    				threadsRemoveFiles[i].join();    				
				} catch (InterruptedException e) {
					e.printStackTrace();
					//TODO: take appropriate logging and error handling action here.
				}
    		}
    		
	    	System.out.println("Successfully deleted all split files.");
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		//TODO: take appropriate logging and error handling action here.
    	}    	
    }
    
    /**
     * This method will read each batch file's data and create Employee object batch list and it will send this object data 
     * processing layer to add data in batches in the database, by calling addEmployeeDetails() method from the data access layer.
     * @param filename
     * @param databaseBatchSize
     * @throws IOException
     */
    private  void sendFileToAddData(String filename,int databaseBatchSize) throws IOException{
    	
    	try
    	{
    		 //Initialize local variable for processing batch file.
		     BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));	// Create buffer reader for file reading.	     	
		     List<Employee> empList = new ArrayList<Employee>();	//Create Employee object for data transfer.
		     ProcessBatchAndAddInDatabase batchProcess = new ProcessBatchAndAddInDatabase(); // Create data access layer object
		     String line; // local variable to store the each line data from the batch file.

		     //Keep reading the file until it reaches the end of file.
		     while ( ((line = bufferedReader.readLine()) != null) && line.length() > 1) {
		    	 
		    	  //Create the Employee object after reading the data from file
		    	  String data[] = line.split("\\|");
		    	  Employee emp = new Employee(data[0], data[1],data[2], Double.parseDouble(data[3]));
		    	  empList.add(emp); //Add Employee object in Employee list
		    	  
		    	  //If Employee list reached the database batch limit size then send this list to database 
		    	  //by calling addEmployeeDetails() method from the data access layer to add in the database table.
				  if (empList.size() >= databaseBatchSize) {				  
					  batchProcess.addEmployeeDetails(empList);
					  empList = new ArrayList<Employee>();
				  }
		     }	
		     
		     //This if loop is require to last left over batch, which is less then the database batch limit size
		     if(!empList.isEmpty()) {
		    	 batchProcess.addEmployeeDetails(empList);			      		     
		     }
		     
		     bufferedReader.close(); //Close and destroy the buffer reader. 
    	}    	
    	catch (IOException e) {
		     throw new IOException("read file error " + filename);
		   //TODO: take appropriate logging and error handling action here.
    	}
    }
}
