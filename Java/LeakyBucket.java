package Algo.Test;

import java.util.*;

public class LeakyBucket extends Thread {

	public static void main(String[] args) throws Exception {
		try{			
		
			LeakyQueue q = new LeakyQueue(5);
			Scanner src = new Scanner(System.in);
			System.out.println("\nEnter the packets to be sent:");
			int size = src.nextInt();
			q.insert(size);
			q.delete();
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
