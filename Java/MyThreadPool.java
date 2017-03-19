package Algo.Test;
import java.util.*;
import java.util.concurrent.*;

class MyThreadPool {

	private final BlockingQueue<WorkerThread> workQueue ;
	int lenOfQueue = 0;
	
	public MyThreadPool(int len){
		lenOfQueue = len;
		workQueue = new ArrayBlockingQueue<>(len);
	}

	public void execute(WorkerThread t){
		
		if(workQueue.size() >= lenOfQueue){
			WorkerThread wt = workQueue.poll();
			wt.start();
			t.start();
			workQueue.add(t);
		}
		else
		{
			workQueue.add(t);		
		}
		
	}
	
	public void shutDown(){
		
		for(WorkerThread t : workQueue)	{			
			t.interrupt();
		}
	}
}
