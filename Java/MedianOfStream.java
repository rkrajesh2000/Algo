package Algo.Test;

import java.util.Collections;
import java.util.PriorityQueue;

// The best time complexity we can get for this problem is O(log(n)) of add() 
//and O(1) of getMedian(). This data structure seems highly likely to be a tree.
//We can use heap to solve this problem. In Java, the PriorityQueue class is 
//a priority heap. We can use two heaps to store the lower half and 
//the higher half of the data stream. The size of the two heaps differs at most 1.
public class MedianOfStream {
	    PriorityQueue<Integer> maxHeap;//lower half
	    PriorityQueue<Integer> minHeap;//higher half
	 
	    public MedianOfStream(){
	        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	        minHeap = new PriorityQueue<Integer>();
	    }
	 
	    public static void main(String[] args) {
	    	
	    	MedianOfStream median = new MedianOfStream();
	    	
	    	for(int i=1; i<10; i++){
	    		System.out.print(median.findMedian(i) + ",");
	    	}
	    }
	    
	    // Returns the median of current data stream
	    public double findMedian(int num) {

	        maxHeap.offer(num);
	        minHeap.offer(maxHeap.poll());
	 
	        if(maxHeap.size() < minHeap.size()){
	            maxHeap.offer(minHeap.poll());
	        }
	    	
	        if(maxHeap.size()==minHeap.size()){
	            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
	        }else{
	            return maxHeap.peek();
	        }
	    }	    
//	    // Adds a number into the data structure.
//	    public void addNumToHeap(int num) {
//	        maxHeap.offer(num);
//	        minHeap.offer(maxHeap.poll());
//	 
//	        if(maxHeap.size() < minHeap.size()){
//	            maxHeap.offer(minHeap.poll());
//	        }
//	    }
	}
