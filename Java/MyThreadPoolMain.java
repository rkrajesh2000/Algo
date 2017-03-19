package Algo.Test;

public class MyThreadPoolMain {

	public static void main(String[] args) {
		
        MyThreadPool tp = new MyThreadPool(3);
        tp.execute( new WorkerThread("start") );
        tp.execute( new WorkerThread("initialize") );
        tp.execute( new WorkerThread("fetch") );
        tp.execute( new WorkerThread("run") );
        tp.execute( new WorkerThread("post-run") );
        tp.execute( new WorkerThread("finish") );
        tp.shutDown();

	}

}
