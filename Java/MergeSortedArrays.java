package Algo.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = { 1, 11, 5, 25, 95, 35, 111 };
		int[] arr2 = { 2, 4, 84, 8, 94, 37, 15 };
		int[] arr3 = { 1, 90, 10, 3, 91, 34, 110 };
 
		int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println("By mergeKSortedArray() with Comparable<ArrayContainer> : " + Arrays.toString(result));
		
		result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println("By mergeKSortedArrayAddDirectlyToQueue() : " + Arrays.toString(result));		
	
		result = findTopNumbersUsingPriorityQueue(new int[][] { arr1, arr2, arr3 });		

		System.out.println("By findTopNumbersUsingPriorityQueue() : " + Arrays.toString(result));	
	}
	
	//This problem solved by using a heap. The time complexity is O(nlog(n)).
	//It takes O(log(m)) to insert an element to the heap and 
	//it takes O(1) to delete the minimum element.
	public static int[] mergeKSortedArray(int[][] arr) {
		//PriorityQueue is heap in Java 
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int total=0;
 
		//add arrays to heap
		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayContainer(arr[i], 0));
			total = total + arr[i].length;
		}
 
		int m=0;
		int result[] = new int[total];
 
		//while heap is not empty
		while(!queue.isEmpty()){
			ArrayContainer ac = queue.poll();
			result[m++]=ac.arr[ac.index];
 
			if(ac.index < ac.arr.length-1){
				queue.add(new ArrayContainer(ac.arr, ac.index+1));
			}
		}
 
		return result;
	}
	
	public static int[] mergeKSortedArrayAddDirectlyToQueue(int[][] arr) {
		//PriorityQueue is heap in Java 
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int total=0;
 
		//add arrays to heap
		for (int[] arrInner :  arr) {
			for(int n: arrInner)
				queue.add(n);
			
			total = total + arrInner.length;
		}
 
		int m=0;
		int result[] = new int[total];
 
		//while heap is not empty
		while(!queue.isEmpty())
			result[m++]=queue.poll();		
 
		return result;
	}	
	
	private static int[] findTopNumbersUsingPriorityQueue(int[][] arr) {
		//PriorityQueue is heap in Java 
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
 
		//add arrays to heap
		for (int[] arrInner :  arr) {
			for(int n: arrInner){
				if( queue.size() < 5) 
					queue.add(n);
				else if(queue.peek() < n ){
					queue.add(n);
					queue.poll();
				}
			}			
		}
 
		int m=0;
		int result[] = new int[queue.size()];
 
		while(!queue.isEmpty())
			result[m++]=queue.poll();		
 
		return result;
	}
}
