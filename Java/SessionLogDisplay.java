package Algo.Test;

import java.util.*;

/*Website logs for a single user and a single day
Entry:
Unique Id, start time, end time
1, 1100, 1200
2, 1030, 1130
3, 1400, 1500
4, 1520, 1700

group these entries into sessions based on the following criteria:

1. If entries intervals overlap, then they belong to the same session
2. If two entries do not overlap, but gaps between < 30, then they belong to the same session

sample output:
Session #1: 1, 2
Session #2: 3, 4*/

public class SessionLogDisplay {

	class TupleLogs{
	    int id;
	    int startTime;
	    int endTime;
	}
	
	public static void main(String[] args) {
		
		SessionLogDisplay obj = new SessionLogDisplay();
		List<TupleLogs> logEntries = new ArrayList<TupleLogs>();
		
		TupleLogs log1 = obj.new TupleLogs();
		log1.id=1;
		log1.startTime = 1100;
		log1.endTime = 1200;
		logEntries.add(log1);
		
		TupleLogs log2 = obj.new TupleLogs();
		log2.id=2;
		log2.startTime = 1030;
		log2.endTime = 1130;
		logEntries.add(log2);
		
		TupleLogs log3 = obj.new TupleLogs();
		log3.id=3;
		log3.startTime = 1400;
		log3.endTime = 1500;
		logEntries.add(log3);
		
		TupleLogs log4 = obj.new TupleLogs();
		log4.id=4;
		log4.startTime = 1520;
		log4.endTime = 1700;
		logEntries.add(log4);	
		
		TupleLogs log5 = obj.new TupleLogs();
		log5.id=5;
		log5.startTime = 1720;
		log5.endTime = 1800;
		logEntries.add(log5);		
		
		displaySessionLogs(logEntries);
		
		//Collections.sort(logEntries);
		//Collections.sort(logEntries, new Comparator<TupleLogs>());		
	}

	public static void displaySessionLogs(List<TupleLogs> logEntries){
		  
		if(logEntries.size() == 0)
			return;
		
		  int index = 0;
		  int sessionId = 1;
		  boolean isNew;
		  
		  System.out.print("Session #" + sessionId + ": " + (logEntries.get(index).id));
		  
		  while(index < (logEntries.size()-1)){
			  
			 int currentEndTime = logEntries.get(index).endTime;
			 int nextStartTime = logEntries.get(++index).startTime;
			 
			 if ((currentEndTime >= nextStartTime) || (Math.abs(nextStartTime - currentEndTime) < 30)) {
			    isNew = false;		        
			 }
			 else{
			   isNew = true;
			   sessionId++;
			 }
			 
			if(isNew){ 
				System.out.println("");
			    System.out.print("Session #" + sessionId + ": " + (logEntries.get(index).id));
			}
			else
				System.out.print(", " + logEntries.get(index).id);
				     		       
		 }  
	}
}
