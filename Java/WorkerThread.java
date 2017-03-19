package Algo.Test;

class WorkerThread extends Thread {
	
	private String mCommand;	
	
	public WorkerThread(String command){
		mCommand = command;
		
	}
	
	@Override
	public void start(){

		new RunnableTask(mCommand).run();
	}
}
