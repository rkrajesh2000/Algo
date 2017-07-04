package Algo.Test;

import java.util.*;

public class FindInSortedAndUnsortedArray {
	public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
		//int arr[] = {5,7,7,8,8,10};
        // Element to be counted in arr[]
        int target =  3; 
        findRangeOfRepeatedNumber(arr, target);
        
        int[] numbers = new int[] { 5, 6, 7, 0, 1, 2, 3, 4 };
        findElementRecursiveRotatedSortedArray(numbers, target);
        int arr2[] = {1, 2, 3, 4, 5, 6, 7, 7};
        System.out.println("Duplicate number in array is : " + findRepeatingNumber(arr2,0, arr2.length));   
        System.out.print("All Duplicate number in array is ");  
        findAllDuplicateNumberInUnsorted(new int[]{10,2,5,10,9,1,1,4,3,7});
        findAllDuplicateNumberInUnsortedOptimized(new int[]{10,2,5,10,9,1,1,4,3,7});
        System.out.println();
        System.out.print("bubbleSort() : ");
        displayList(bubbleSort(new int[] { 5, 6, 7, 0, 1, 2, 3, 4 }));
	}
	
	private static void displayList(int[] arr){
		System.out.print("[ ");
       	
        	int counter = 0;
        	for(int val : arr ){
        		System.out.print(val);
        		
        		++counter;
        		if(counter < arr.length)
        			System.out.print(",");
        	}
        	
        	System.out.print("], ");
	}		
	/*
	 * Count number of occurrences (or frequency) and stating and end index in a sorted array
	 * 
	 */
	private static void findRangeOfRepeatedNumber(int[] arr, int target){
		
		if(arr == null || arr.length == 0)
			return;
		
		int start = getStartIndex(arr, 0, arr.length -1, target);
		
		if(start == -1){
			System.out.println("Target value doesn't exists in arr : -1");
			return;
		}

		int end = getEndIndex(arr, start, arr.length - 1, target);
		
		System.out.println("Count is : " + (end - start + 1));
		System.out.println("Starting Index is : " + start);
		System.out.println("Endinging Index is : " + end);
	}
	
	private static int getStartIndex(int[] arr, int left, int right, int target){
		
		if(left > right)
			return -1;
		
		int mid = (left + right)/2;
		
		if((mid == 0 || target > arr[mid -1]) && target == arr[mid])
				return mid;
		else if ( target > arr[mid] )
			return getStartIndex(arr, mid+1, right, target);			
		else 
			return getStartIndex(arr, left, mid-1, target);
	}
	
	private static int getEndIndex(int[] arr, int left, int right, int target){
		
		if(left > right)
			return -1;
		
		int mid = (left + right)/2;
		
		if((mid == arr.length -1 || target < arr[mid+1]) && target == arr[mid])
			return mid;
		else if(target < arr[mid])
			return getEndIndex(arr, left, mid-1, target);
		else 
			return getEndIndex(arr, mid+1, right, target);
			
	}
	
    public static void findElementRecursiveRotatedSortedArray(int[] arr, int target)
    {
        int index = binarySearchRotatedSortedArray(arr, 0, arr.length - 1, target);
        System.out.println("Index  of target element in rotated is : " + index);
    }	
    
    public static int binarySearchRotatedSortedArray(int[] arr, int left, int right, int target)
    {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (target == arr[mid])
            return mid;

        if (target < arr[mid])
        {
            return binarySearchRotatedSortedArray(arr, left, mid - 1, target);
        }
        else
        {
            return binarySearchRotatedSortedArray(arr, mid + 1, right, target);
        } 
    }
    
	private static int findRepeatingNumber(int[] arr, int left, int right){
		
		if(left > right)
			return -1;
		
		int mid = (left + right)/2;
		
		if(mid < arr.length-1 && arr[mid] == arr[mid+1])
			return arr[mid];
		else if(mid > 0 && mid < arr.length-1 && arr[mid] == arr[mid-1])
			return arr[mid];
		
		int val = findRepeatingNumber(arr, left, mid-1);
		
		if(val != -1)
			return val;
		
		val = findRepeatingNumber(arr, mid+1, right);

		return val;		
	}
	
	/*
	 * Given an array of integers, (n = size of array), some elements appear twice and others appear once.
	 * Find all the elements that appear twice in this array.
	 * Solve it with O(n) runtime. This solution is using extra space but works well.
	 */	
	private static void findAllDuplicateNumberInUnsorted(int[] nums){
		
		List<Integer> list = new ArrayList<Integer>();
		if(nums == null || nums.length < 2)
			return;
		
		if(nums.length == 2 && nums[0] == nums[1]){
			list.add(nums[0]);
		}			
				
		int len = nums.length;
       
		HashSet<Integer> set = new HashSet<Integer>();

		for(int i=0; i < len; i++){
			while (nums[i] != i+1) {				
				if (nums[i] < 0 || nums[i] > len)
					break;
	 
				//handle duplicate elements
				if(nums[i]== nums[nums[i]-1]){
					if(!list.contains(nums[i]))
						list.add(nums[i]);					
					break;
				}
				
				// swap elements
				int temp = nums[i];
				nums[i] = nums[temp-1];
				nums[temp-1] = temp;
			}			
		}		

        System.out.print("findAllDuplicateNumberInUnsorted() : ");
        
		for(int n : list){
			System.out.print(n + ",");
		}
	}
	
	/*
	 * Given an array of integers, (n = size of array), some elements appear twice and others appear once.
	 * Find all the elements that appear twice in this array.
	 * Solve it without extra space and in O(n) runtime.
	 * This is more optimized as this not using any extra space.
	 */
	private static void findAllDuplicateNumberInUnsortedOptimized(int[] nums){
		
		List<Integer> list = new ArrayList<>();
		if(nums == null || nums.length == 0 || nums.length < 2)
			return;
		
		if(nums.length == 2 && nums[0] == nums[1]){
			list.add(nums[0]);
		}
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                list.add(index + 1);
            }
            
            nums[index] = -nums[index];
        }
        
        System.out.println();
        System.out.print("findAllDuplicateNumberInUnsortedOptimized() : ");
        
		for(int n : list){
			System.out.print(n + ",");
		}
	}
	
	static int[] bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp;  
         for(int i=0; i < n; i++){  
             for(int j=1; j < (n-i); j++){  
                  if(arr[j-1] > arr[j]){  
                         //swap elements  
                         temp = arr[j-1];  
                         arr[j-1] = arr[j];  
                         arr[j] = temp;  
                 }                        
              }  
         }
         
         return arr;
	}
}
