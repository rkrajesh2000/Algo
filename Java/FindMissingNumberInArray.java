package Algo.Test;

import java.util.*;

public class FindMissingNumberInArray {

	public static void main(String[] args) {
		// If Two missing number: https://www.careercup.com/question?id=18774665
		
		int arr[] = {1,2,4,5,6};
		System.out.println("Missing number in sorted array by BinarySearchRecurssive is : " + getMissingNumberByBinarySearchRecurssive(arr,0,5));
		System.out.println("Missing number in sorted array by Normal is : " + getMissingNumber(arr,5));
		System.out.println("Missing number in sorted array by XOR is : " + getMissingNumberXOR(arr,5));
		System.out.println("Missing number in unsorted array by bucket sort findMissingNumberInUnsorted(): " + findMissingNumberInUnsorted(new int[]{3,4,-1,1}));
		System.out.print("All missing number in unsorted array by bucket sort findAllMissingNumberInUnsorted(): " );
		findAllMissingNumberInUnsorted(new int[]{4,3,2,7,8,2,3,1});
	}

	private static int getMissingNumberByBinarySearchRecurssive(int[] arr, int left, int right) {

		if(left > right)
			return -1;
		
		int mid = (left + right)/2;
		
		if(mid < arr.length-1 && arr[mid]+1 != arr[mid+1])
			return arr[mid]+1;
		else if(mid > 0 && mid < arr.length-1 && arr[mid]-1 != arr[mid-1])
			return arr[mid]-1;
		
		int val = getMissingNumberByBinarySearchRecurssive(arr, left, mid-1);
		
		if(val != -1)
			return val;
		
		val = getMissingNumberByBinarySearchRecurssive(arr, mid+1, right);

		return val;	
	}
	
	private static int getMissingNumber(int arr[], int n)
	{
	    int total;
	    total  = (n+1)*(n+2)/2; 
	    
	    for ( int i = 0; i< n; i++)
	    	total -= arr[i];	    
	       
	    return total;
	}
	
	private static int getMissingNumberXOR(int arr[], int n)
	{
	    int i;
	    int x1 = arr[0]; /* For xor of all the elements in array */
	    int x2 = 1; /* For xor of all the elements from 1 to n+1 */
	    
	    for (i = 1; i< n; i++){
	        x1 = x1^arr[i];
	    }
	    
	    for ( i = 2; i <= n+1; i++){	
	        x2 = x2^i;  
	    }
	    
	    return (x1^x2);
	}	
	
	/*
	 *  41. First Missing Positive
	 *  Given an unsorted integer array, find the first missing positive integer.
	 *  For example,
	 *	Given [1,2,0] return 3,
	 *	and [3,4,-1,1] return 2.
	 *	Your algorithm should run in O(n) time and uses constant space.
	 */
	private static int findMissingNumberInUnsorted(int[] nums){

		int len = nums.length;
		
		for(int i=0; i<len; i++){		
			
			while(nums[i] != i+1){				
				
				if(nums[i] <= 0 || nums[i] >= len)
					break;
				
				if(nums[i] == nums[nums[i]-1])
					break;
				
				int temp = nums[i];
				nums[i] = nums[temp-1];
				nums[temp-1] = temp;
			}			
		}
		
		for(int i = 0; i < len; i++){
			if(nums[i] != i+1)
				return i+1;
		}
		
		return len + 1;
	}
	
	/*
	 * Find All Numbers Disappeared in an Array
	 */
	private static void findAllMissingNumberInUnsorted(int[] nums){
		
		int len = nums.length;
		
		for(int i=0; i < len; i++){
			while(nums[i] != i+1){
				
				if(i<=0 || i >= len)
					break;
				
				if(nums[i] == nums[nums[i]-1])
					break;
				
				int temp = nums[i];
				nums[i] = nums[temp-1];
				nums[temp-1] = temp;
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i < len; i++){
			
			if(nums[i] != i+1)
				list.add(i+1);
		}
		
		for(int n : list){
			System.out.print(n + ",");
		}		
	}
}
