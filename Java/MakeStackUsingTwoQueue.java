package Algo.Test;

import java.util.*;

public class MakeStackUsingTwoQueue<E> {

		Object lock = new Object();
	    private Queue<E> s1 = new LinkedList<>();
	    private Queue<E> s2 = new LinkedList<>();
	    private static LinkedList<Integer> s3 = new LinkedList<Integer>();
	    
		public static void main(String[] args) {

			MakeStackUsingTwoQueue<Integer> myQueue = new MakeStackUsingTwoQueue<Integer>();
			myQueue.push(1);
			myQueue.push(2);
			myQueue.push(3);
			
			System.out.println(myQueue.pop());
			myQueue.push(4);
			myQueue.push(5);
			System.out.println(myQueue.pop());
			System.out.println(myQueue.pop());
			System.out.println(myQueue.pop());
			System.out.println(myQueue.pop());
		}

	    private void push(E e) {
	    	
	    	synchronized(lock){  
	    		
	    		if(s1.isEmpty() && s2.isEmpty())
	    			s2.add(e);
	    		else if(!s1.isEmpty())
	    			s1.add(e);
	    		else
	    			s2.add(e);
	        }
	    } 
	    
	    private E pop(){
	    	
		    synchronized(lock){ 
		    	E e = null;
		    	
		    	if(!s2.isEmpty()){
			    	while(!s2.isEmpty()){
			    		if(s2.size() == 1)
			    			e = s2.poll();
			    		else
			    			s1.add(s2.poll());
			    	}		    	
		    	}
		    	else {
			    	while(!s1.isEmpty()){
			    		if(s1.size() == 1)
			    			e = s1.poll();
			    		else
			    			s2.add(s1.poll());
			    	}	
		    	}
		    	return e;
		    }	    	
	    }

}
