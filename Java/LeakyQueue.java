package Algo.Test;

import java.util.*;

public class LeakyQueue {
	
	int q[],f=0,r=0,size;
	public LeakyQueue(int bucketCapacity){
		size = bucketCapacity;
	}
	void insert(int n) {
		 Scanner in = new Scanner(System.in);
		 q = new int[size]; 
		 for(int i=0;i<n;i++) {
			 
			  System.out.print("\nEnter " + i + " element: ");			  
			  int element=in.nextInt();
			  
			  if(r+1 > size){
				  System.out.println("\nQueue is full \nLost Packet: "+element);
				  break;
			  }
			  else {
				  r++;
				  q[i]= element;
			  }
		 }
	}

	void delete() {
		 Scanner in = new Scanner(System.in);
		 
		 if(r==0)
			 System.out.print("\nQueue empty ");		 
		 else {
			 	for(int i=f;i<r;i++)  {
			 		try {
			 			Thread.sleep(1000);
			 		}
			 		catch(Exception e){}
				 System.out.print("\nLeaked Packet: "+q[i]);
				 f++;
			 }
		 }

		 System.out.println();
	}

}
