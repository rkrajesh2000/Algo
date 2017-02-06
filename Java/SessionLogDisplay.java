package Algo.Test;

import java.util.*;

//web site log entries for a single user in a single day
//entry:
//unqiue Id, start time, end time
//1, 1100, 1200
//2, 1030, 1130
//3, 1400, 1500
//4, 1520, 1700

//Group entries into Sessions based on the following criteria
//1. If two entries overlap, then they belong to the same session
//2. If not overlapping, but gap between is <30, then they belong to the same session

//Sample output
//Session #1: 1, 2
//Session #2: 3, 4

//jzhang@ten-x.com


public class SessionLogDisplay{

	  class TuppleLogs{
	      int id;
	      int startTime;
	      int endTime;
	  }
	  
	  public static void displaySessionLogs(List<TuppleLogs> logEntries) {
	      
	      if(logEntries.size() == 0)
	          return;
	      
	      int index = 0;
	      int sessionId = 1;
	      boolean isNew;
	      
	      System.out.print("Session #" + sessionId + " : " + (logEntries.get(index).id));
	      
	      while(index < (logEntries.size() - 1))        {
	          int currentEndTime = logEntries.get(index).endTime;
	          int nextEndTime = logEntries.get(++index).startTime;
	          
	          if( (currentEndTime >= nextEndTime) || (Math.abs(nextEndTime -  currentEndTime) < 30)) {
	              isNew = false;
	          }  
	          else {
	              isNew = true;
	              sessionId++;
	          }
	          
	          if(isNew){
	              System.out.println("");
	              System.out.print("Session #" + sessionId + " : " + (logEntries.get(index).id));
	          }
	          else
	              System.out.print(", " + (logEntries.get(index).id));
	      }
	  }
  
	  public static void main(String[] arg) {
	  
		  SessionLogDisplay obj = new SessionLogDisplay();
	      List<TuppleLogs> logEntries = new ArrayList<TuppleLogs>();
	      
	      TuppleLogs log1 = obj.new TuppleLogs();
	      log1.id = 1;
	      log1.startTime = 1100;
	      log1.endTime = 1200;
	      logEntries.add(log1);        
	      
	      TuppleLogs log2 = obj.new TuppleLogs();
	      log2.id = 2;
	      log2.startTime = 1030;
	      log2.endTime = 1130;
	      logEntries.add(log2);  
	      
	              
	      TuppleLogs log3 = obj.new TuppleLogs();
	      log3.id = 3;
	      log3.startTime = 1400;
	      log3.endTime = 1500;
	      logEntries.add(log3);                   
	              
	      TuppleLogs log4 = obj.new TuppleLogs();
	      log4.id = 4;
	      log4.startTime = 1520;
	      log4.endTime = 1700;
	      logEntries.add(log4);            
	      
	      displaySessionLogs(logEntries);
	  }
}
