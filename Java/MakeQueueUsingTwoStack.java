package Algo.Test;

import java.util.*;

public class MakeQueueUsingTwoStack<E> {

	Object lock = new Object();
    private final Stack<E> tempStack = new Stack<>();
    private final Stack<E> mainStack = new Stack<>();
    
	public static void main(String[] args) {

		MakeQueueUsingTwoStack<Integer> myQueue = new MakeQueueUsingTwoStack<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		
		System.out.println("Dequeue : " + myQueue.dequeue());
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		System.out.println("Peek : " + myQueue.peek());
		System.out.println("Dequeue : " + myQueue.dequeue());		
		System.out.println("Dequeue : " + myQueue.dequeue());
		System.out.println("Dequeue : " + myQueue.dequeue());
		System.out.println("Dequeue : " + myQueue.dequeue());
		System.out.println("Dequeue : " + myQueue.empty());
	}

    public boolean empty() {
        return (tempStack != null && mainStack != null && tempStack.isEmpty() && mainStack.isEmpty());
    }
    
    private void enqueue(E e) {
        
    	synchronized(lock){           
            mainStack.push(e);
        }
    } 
    
    private E dequeue(){
    	
	    synchronized(lock){ 
	    	if(!tempStack.isEmpty())
	    		return tempStack.pop();
	    	else{
	    		while(!mainStack.isEmpty()){
	    			tempStack.push(mainStack.pop());
	    		}
	    		
		    	if(!tempStack.isEmpty())
		    		return tempStack.pop();
	    	}	
	    	return null;
	    }    	
    }
    
    private E peek(){
	    synchronized(lock){ 
	    	if(!tempStack.isEmpty())
	    		return tempStack.peek();
	    	else{
	    		while(!mainStack.isEmpty()){
	    			tempStack.push(mainStack.pop());
	    		}
	    		
		    	if(!tempStack.isEmpty())
		    		return tempStack.peek();
	    	}	
	    	return null;
	    } 
    }
}
