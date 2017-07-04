package Algo.Test;

import java.util.*;

public class FindAllCombinationInArrayAddUpToNumber {

	public static void main(String[] args) {

		/*
        *int[] arrayForPairs = new int[] { 3, 5, 4, 2, 1, 7, 6, -1, 10, 9 };
		*int[] arrayForPairs = new int[] {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
    	*/
		
		int target = 8;
		int[] arrayForPairs = new int[] { 10, 1, 2, 7, 6, 1, 9, 5 };
        System.out.print("Input Array : [");
       	for(int val : arrayForPairs ){
    		System.out.print(val);
    		System.out.print(",");
    	}
       	
       	System.out.println("] and target number : " + target);
        System.out.print("uniqueCombinationAddUpToNumber(): ");
        displayList(uniqueCombinationAddUpToNumber(arrayForPairs, target));

        System.out.println();
        System.out.print("allPossibleCombinationAddUpToNumber(): ");
        displayList(allPossibleCombinationAddUpToNumber(arrayForPairs, target));
        
        System.out.println();
        System.out.print("allPossibleCombinationAddUpToNumberWithSameNumberRepeated(): ");
        displayList(allPossibleCombinationAddUpToNumberWithSameNumberRepeated(arrayForPairs, target));        
        

        System.out.println();
        System.out.print("allPossibleCombinationMultiplyUpToNumber() to make 60 : ");
        displayList(allPossibleCombinationMultiplyUpToNumber(new int[]{ 2, 10, 4, 9, 6, 8, 5, 3, 11, 12}, 60));

        System.out.println();
        System.out.print("findMaxSubArrayCombinationAddUpToNumber() total max sub array length is ");
        displayList(findMaxSubArrayCombinationAddUpToNumber(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println();
        System.out.print("findMaxLengthSubArrayCombinationAddUpToNumber() total max sub array length is : " + findMaxLengthSubArrayCombinationAddUpToNumber(new int[]{1, -1, 5, -2, 3}, 3));
           
        System.out.println();
        System.out.print("findMinSubArrayCombinationAddUpToNumber() total min sub array length is ");        
        displayList(findMinSubArrayCombinationAddUpToNumber(new int[]{12,28,83,4,25,26,25,2,25,25,25,12}, 213));        
        System.out.println();
        System.out.print("findMinLengthSubArrayCombinationAddUpToNumber() total min sub array length is : " + findMinLengthSubArrayCombinationAddUpToNumber(new int[]{12,28,83,4,25,26,25,2,25,25,25,12}, 213));
        
        
        System.out.println();
        System.out.print("allPossibleCombinationMultiplyIsLessThanNumber() less than 8 ");
        displayList(allPossibleCombinationMultiplyIsLessThanNumber(new int[]{ 2, 1, 4, 9, 6, 8, 5, 3, 7, 10}, 8));        
        System.out.println();
        
        System.out.println("countSubArrayContinuesSumToNumber() equal to 2 has total count of sub array : " + countSubArrayContinuesSumToNumber(new int[]{1,1,2,1,1,3,-1,-1,-2,10,-1,-1}, 2));
        System.out.print("allPossibleSubArrayWithContinuesSumToNumber() equal to 2 with total count ");
        displayList(allPossibleSubArrayWithContinuesSumToNumber(new int[]{23, 2, 6, 4, 7}, 6));
        
        System.out.println();
        System.out.println("maxSubArraySumValue() : " + maxSubArraySumValue(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("maxSubArrayMultiplyValue() : " + maxSubArrayMultiplyValue(new int[]{-2,-3,7})); //-2,3,-4
        System.out.println("findMaxSumValueKPairSubArray() : " + findMaxSumValueKPairSubArray(new int[]{7,2,5,10,8}, 2));
        //0,1,0,1,0
        System.out.println("findMaxLengthSubArrayContiguousBinaryArray() : " + findMaxLengthSubArrayContiguousBinaryArray(new int[]{1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0}));
        
        System.out.print("findSlidingWindowMaxValue() : ");
        displayList(findSlidingWindowMaxValue(new int[]{1,3,-1,-3,5,3,6,7}, 3));
 	}

	private static void displayList(List<List<Integer>> inputList){
        for (List<Integer> list : inputList) {
        	System.out.print("[");
        	
        	int counter = 0;
        	for(int val : list ){
        		System.out.print(val);
        		
        		++counter;
        		if(counter < list.size())
        			System.out.print(",");
        	}
        	
        	System.out.print("] | ");
        } 
	}

	private static void displayList(int[] list){
        	System.out.print("[");
        	
        	int counter = 0;
        	for(int val : list ){
        		System.out.print(val);
        		
        		++counter;
        		if(counter < list.length)
        			System.out.print(",");
        	}
        	
        	System.out.print("] ");
	}
/*	Given a collection of candidate numbers (C) and a target number (T), 
    find all unique combinations in C where the candidate numbers sums to T.
	Each number in C may only be used once in the combination.

	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
	Result:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	] 
	
	Test Case:
	[14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12]
	27	
	*/
	private static List<List<Integer>> uniqueCombinationAddUpToNumber(int[] array, int target){

	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> innerList = new ArrayList<Integer>();
	    Arrays.sort(array);
	    uniqueCombinationAdd(array, target, 0, list, innerList);
	    return list;	     
	}
	 
	 private static void uniqueCombinationAdd(int[] array, int target, int begin, List<List<Integer>> list, List<Integer> innerList) {
	 
	     if( target == 0){
	         list.add(new ArrayList<Integer>(innerList));
	         return;
	     }
	     
         int num = Integer.MIN_VALUE;

	     for(int i = begin; i < array.length; i++) {
             if(num != array[i]) {
    
            	 int nextTarget = target - array[i];
            	 
	             if(nextTarget < 0){
	               break;
	             }
	            
	             innerList.add(array[i]);
	             uniqueCombinationAdd(array, nextTarget , i + 1, list, innerList);
	             innerList.remove(innerList.size() - 1);
	             num = array[i];
             }
	     }     
	 }
	 
	 /*Find all possible combinations of k numbers that add up to a number n, 
	  * given that only numbers from 1 to 9 can be used and each combination 
	  * should be a unique set of numbers.*/	 
	 private static List<List<Integer>> allPossibleCombinationAddUpToNumber(int[] array, int target){
	
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> innerList = new ArrayList<Integer>();
	    allPossibleCombinationAdd(array, target, 0, list, innerList);
	    return list;	     
	 }	
	 
	 private static void allPossibleCombinationAdd(int[] array, int target, int begin, List<List<Integer>> list, List<Integer> innerList) {
		 
	     if( target == 0){
	         list.add(new ArrayList<Integer>(innerList));
	         return;
	     }
	     
	     for(int i = begin; i < array.length; i++) {
	    	 
	    	 int nextTarget = target - array[i];
	    	 
             if(nextTarget < 0){
                 continue;
               }	    	 
             
             innerList.add(array[i]);             
             allPossibleCombinationAdd(array, nextTarget , i + 1, list, innerList);
             innerList.remove(innerList.size() - 1);
	     }     
	 }

	 /*
	  * 39
	  * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
	  * find all unique combinations in C where the candidate numbers sums to T.
	  * The same repeated number may be chosen from C unlimited number of times.
	  * For example, given candidate set [2, 3, 6, 7] and target 7
	  * Output: [ [7], [2, 2, 3] ]
	  */
	 private static List<List<Integer>> allPossibleCombinationAddUpToNumberWithSameNumberRepeated (int[] array, int target){
			int[] count = new int[1];
		    List<List<Integer>> list = new ArrayList<List<Integer>>();
		    List<Integer> innerList = new ArrayList<Integer>();
		    allPossibleCombinationAddWithSameNumberRepeated(array, count, target, 0, list, innerList);
		    System.out.println(count[0]);
		    return list;	     
		 }	
		 
		 private static void allPossibleCombinationAddWithSameNumberRepeated(int[] array, int[] count, int target, int begin, List<List<Integer>> list, List<Integer> innerList) {
			 
		     if( target == 0){
		    	 ++count[0];
		         list.add(new ArrayList<Integer>(innerList));
		         return;
		     }
		     
		     for(int i = begin; i < array.length; i++) {
		    	 
		    	 int nextTarget = target - array[i];
		    	 
	             if(nextTarget < 0){
	                 continue;
	               }	    	 
	             
	             innerList.add(array[i]);             
	             allPossibleCombinationAddWithSameNumberRepeated(array, count, nextTarget , i, list, innerList);
	             innerList.remove(innerList.size() - 1);
		     }     
		 }	 
	 /*
	  * Maximum Size Subarray Sum Equals k 
	  */
	 static int maxLenSubArray = 0;
	 private static List<List<Integer>> findMaxSubArrayCombinationAddUpToNumber(int[] array, int target){
			
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> innerList = new ArrayList<Integer>();
	    findMaxSubbArrayCombinationAdd(array, target, 0, list, innerList);
	    System.out.print(maxLenSubArray + " and sub array is : ");
	    return list;	     
	 }	
	 
	 private static void findMaxSubbArrayCombinationAdd(int[] array, int target, int begin, List<List<Integer>> list, List<Integer> innerList) {
		 
	     if( target == 0 && innerList.size() > maxLenSubArray){
	    	 
	    	 maxLenSubArray = innerList.size();
	    	 if(!list.isEmpty())
	    		 list.remove(list.size() -1);
	    	 
	         list.add(new ArrayList<Integer>(innerList));
	         return;
	     }
	     
	     for(int i = begin; i < array.length; i++) {
	    	 int nextTarget = target - array[i];	    	 
             innerList.add(array[i]);             
             findMaxSubbArrayCombinationAdd(array, nextTarget , i + 1, list, innerList);
             innerList.remove(innerList.size() - 1);
	     }     
	 }	 

	 /*
	  * Maximum Size Sub array Sum Equals k 
	  */
	 private static int findMaxLengthSubArrayCombinationAddUpToNumber(int[] nums, int target){
		
		if(nums == null || nums.length == 0)
			return 0;
		
		int i=0; 
		int j=0; 
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		while(i < nums.length){
			sum += nums[i++];
			
			while(sum == target){				
				max = Math.max(max, i-j);
				sum -= nums[j++];
			}
		}
		
		return (max == Integer.MIN_VALUE ? 0 : max);
	 }
	 /*
	  * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous sub array of which the sum >= s. If there isn't one, return 0 instead.
		For example, given the array [2,3,1,2,4,3] and s = 7, the sub array [4,3] has the minimal length under the problem constraint.
	  */
	 private static List<List<Integer>> findMinSubArrayCombinationAddUpToNumber(int[] array, int target){
			
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> innerList = new ArrayList<Integer>();
	    int[] size = new int[]{Integer.MAX_VALUE};
	    findMinSubbArrayCombinationAdd(array, target, 0, size, list, innerList);
	    
	    if(size[0] == Integer.MAX_VALUE)
	    	size[0] = 0;
	    
	    System.out.print(size[0] + " and sub array is : ");
	    return list;	     
	}	
		 
	private static void findMinSubbArrayCombinationAdd(int[] array, int target, int begin, int[] size, List<List<Integer>> list, List<Integer> innerList) {
			 
	     if( target == 0 && innerList.size() < size[0]){
	    	 
	    	 size[0] = innerList.size();
	    	 if(!list.isEmpty())
	    		 list.remove(list.size() -1);
	    	 
	         list.add(new ArrayList<Integer>(innerList));
	         return;
	     }
	     
	     for(int i = begin; i < array.length; i++) {
	    	 int nextTarget = target - array[i];	 
	    	 
	    	 if(nextTarget < 0)
	    		 continue;
	    	 
             innerList.add(array[i]);             
             findMinSubbArrayCombinationAdd(array, nextTarget , i + 1, size, list, innerList);
             innerList.remove(innerList.size() - 1);
	     }     
	}
	
	 /*
	  * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous sub array of which the sum >= s. If there isn't one, return 0 instead.
		For example, given the array [2,3,1,2,4,3] and s = 7, the sub array [4,3] has the minimal length under the problem constraint.
	  */	
	private static int findMinLengthSubArrayCombinationAddUpToNumber(int[] nums, int target){
		
		if(nums == null || nums.length == 0)
			return 0;
		
		int i=0; 
		int j=0; 
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		while(i < nums.length){
			sum += nums[i++];
			
			while(sum >= target){				
				min = Math.min(min, i-j);
				sum -= nums[j++];
			}
		}
		
		return (min == Integer.MAX_VALUE ? 0 : min);
	}
	
	 private static List<List<Integer>> allPossibleCombinationMultiplyUpToNumber(int[] array, int target){
		 
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 List<Integer> innerList = new ArrayList<>();
		 allPossibleCombinationMultiply(array, target, 1, 0, list, innerList);
		 return list;		 
	 }
	 
	 private static void allPossibleCombinationMultiply(int[] array, int target, int product, int begin, List<List<Integer>> list, List<Integer> innerList) {
		 
		 if(product == target){
			 list.add(new ArrayList<Integer>(innerList));
		 }
		 

		 for(int i = begin; i < array.length; i++){
			 
			 if(array[i] > target)
				 continue;
			 
			 int nextProduct = product * array[i];			 
			 innerList.add(array[i]);			 
			 allPossibleCombinationMultiply(array, target, nextProduct, i+1, list, innerList);
			 innerList.remove(innerList.size()-1);				 
		 }
	 }
	 
	 static int countSubArray = 0;
	 private static List<List<Integer>> allPossibleCombinationMultiplyIsLessThanNumber(int[] array, int target){

		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 List<Integer> innerList = new ArrayList<>();
		 findAllPossibleCombinationMultiplyLessThanNumber(array, target, 1, 0, list, innerList);
		 System.out.print("has total count of sub array " + countSubArray + " : ");
		 return list;	
	 }
	 
	 private static void findAllPossibleCombinationMultiplyLessThanNumber(int[] array, int target, int product, int begin, List<List<Integer>> list, List<Integer> innerList) {

		 if(product <= target){
			 if(innerList.size() > 0){
				 list.add(new ArrayList<Integer>(innerList));
				 ++countSubArray;
			 }
		 }		 

		 for(int i = begin; i < array.length; i++){
			 
			 if(array[i] > target)
				 continue;
			 
			 int nextProduct = product * array[i];			 
			 innerList.add(array[i]);			 
			 findAllPossibleCombinationMultiplyLessThanNumber(array, target, nextProduct, i+1, list, innerList);
			 innerList.remove(innerList.size()-1);				 
		 }
	 }
	 
	 /*
	  * Find the contiguous sub array within an array (containing at least one number) which has the largest sum.
		For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
		the contiguous sub array [4,-1,2,1] has the largest sum = 6.
	  */
	 private static int maxSubArraySumValue(int[] nums){
		 
		 if(nums == null || nums.length == 0)
			 return 0;
		 
		 if(nums.length == 1)
			 return nums[0];
	 
		 int max = nums[0];
		 int curSum = nums[0];
		 
		 for(int i = 1; i < nums.length; i++){
			 
			 curSum = Math.max(nums[i], curSum + nums[i]);
			 max = Math.max(max, curSum);
		 }
		 
		 return max;
	 }
	 
	 /*
	  * Find the contiguous sub array within an array (containing at least one number) which has the largest product.
		For example, given the array [2,3,-2,4], the contiguous sub array [2,3] has the largest product = 6.
	  */
	 private static int maxSubArrayMultiplyValue(int[] nums){
		 
		 if(nums == null || nums.length == 0)
			 return 0;
		 
		 if(nums.length == 1)
			 return nums[0];
	 
		 int[] max = new int[nums.length];
		 int[] min = new int[nums.length];
		 max[0] = nums[0];
		 min[0] = nums[0];
		 int result = nums[0];
		 
		 for(int i = 1; i < nums.length; i++){
			 
			 if(nums[i] > 0){
				 max[i] = Math.max(nums[i], max[i-1] * nums[i]);
				 min[i] = Math.min(nums[i], min[i-1] * nums[i]);
			 }
			 else {				 
				 max[i] = Math.max(nums[i], min[i-1] * nums[i]);
				 min[i] = Math.min(nums[i], max[i-1] * nums[i]);
			 }

			 result = Math.max(result, max[i]);
		 }
		 
		 return result;
	 }

	 /*
	  * 560. Continuous Sub array Sum. 523 is also similar
	  * Given an array of integers and an integer k, you need to find the total number of continuous sub arrays whose sum equals to k.

		Example 1:
		Input:nums = [1,1,1], k = 2
		Output: 2
	  */
	 private static int countSubArrayContinuesSumToNumber(int[] nums, int k) {
		 
		 if(nums == null || nums.length == 0 || k == 0)
			 return 0;
		 
		    int count = 0;
		    int sumVal = 0;
		    int traget = Math.abs(k);
		    Map<Integer, Integer> indexMap = new HashMap<>();
		    indexMap.put(0, 1);		    
		    
		    for (int i = 0; i < nums.length; i++) {
		        sumVal += nums[i];
		        count += indexMap.getOrDefault(sumVal - traget, 0);
		        indexMap.put(sumVal, indexMap.getOrDefault(sumVal, 0) + 1);
		        
//		        if(indaxMap.containsKey(sumVal))
//		        	indaxMap.replace(sumVal, indaxMap.get(sumVal) + 1);
//		        else
//		        	indaxMap.put(sumVal, 1);		        
		    }
		
		    return count;        
	 }
	  
	 /*
	  * 560. Continuous Sub array Sum
	  * Given an array of integers and an integer k, you need to find the total number of continuous sub arrays whose sum equals to k.

		Example 1:
		Input:nums = [1,1,1], k = 2
		Output: 2
		
		NOTE: This solution is not correct and need to be fixed. It is not satisfying all of the use cases.
	  */
	 private static List<List<Integer>> allPossibleSubArrayWithContinuesSumToNumber(int[] nums, int target){

		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 if(nums == null || nums.length == 0 || nums.length == 1){
			 System.out.print(target + " and sub array : ");
			 return list;
		 }
		 
		 int[] arr = new int[1];
		 
		 List<Integer> innerList = new ArrayList<>();
		 findAllPossibleSubArrayWithContinuesSumToNumber(nums, target, 0, 0, arr, list, innerList);
		 System.out.print(arr[0] + " and sub array : ");
		 
		 return list;
	 }
	 
	 //This is not correct and need to be fixed.
	 private static void findAllPossibleSubArrayWithContinuesSumToNumber(int[] array, int target, int product, int begin, int[] arr,  List<List<Integer>> list, List<Integer> innerList) {

		 if(product == target){
			 if(validateAllInOrder(innerList)){
				 ++arr[0];
				 list.add(new ArrayList<Integer>(innerList));
			 }
			 return;
		 }		 

		 for(int i = begin; i < array.length; i++){
			 
			 int nextProduct = product + array[i];
			 
			 if(nextProduct > target)
				 continue;
			 
			 if(nextProduct == target && i > begin && (i - (i-1) == 1 && nextProduct != array[i]))
				 break;
			 
			 innerList.add(array[i]);			 
			 findAllPossibleSubArrayWithContinuesSumToNumber(array, target, nextProduct, i+1, arr, list, innerList);
			 innerList.remove(innerList.size()-1);				 
		 }
	 }
	 
	 private static boolean validateAllInOrder(List<Integer> innerList){
		 for(int i=1; i< innerList.size()-1; i++){
			 if(innerList.get(i) - innerList.get(i-1) != 1)
				 return false;
		 }
		 return true;
	 }
	 
	 /*
	  * 410. Split Array Largest Sum
	  * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous sub arrays. 
	  * Write an algorithm to minimize the largest sum among these m sub arrays.
	  * Example:
	  * Input:
		nums = [7,2,5,10,8]
		m = 2		
		Output:	18		
		Explanation:
		There are four ways to split nums into two sub arrays.
		The best way is to split it into [7,2,5] and [10,8],
		where the largest sum among the two sub arrays is only 18.
	  */	 
	 private static int findMaxSumValueKPairSubArray(int[] nums, int m){
			
	        if(nums == null || nums.length == 0)
	            return 0;

		    List<Integer> innerList = new ArrayList<Integer>();
		    int[] prev = new int[1];
		    findMaxSumValueKPairSubArrayCombination(nums, m, 0, prev, 0, innerList);
		    return prev[0];	     
	 }	
		 
	 private static void findMaxSumValueKPairSubArrayCombination(int[] array, int k, int target, int[] prev, int begin, List<Integer> innerList) {
		 
		 if(innerList.size() > k)
			 return;
		 
	     if(k == innerList.size() && target > prev[0]){	    	 
	    	 prev[0] = target;	    	 
	         return;
	     }
	     
	     for(int i = begin; i < array.length; i++) {
	    	 int nextTarget = target + array[i];	    	 
	         innerList.add(array[i]);             
	         findMaxSumValueKPairSubArrayCombination(array, k, nextTarget, prev, i + 1, innerList);
	         innerList.remove(innerList.size() - 1);
	     }     
	 }
	 
	 private static int findMaxLengthSubArrayContiguousBinaryArray(int[] nums){
			
		if(nums == null || nums.length == 0 || nums.length == 1 )
			return 0;
 
		if(nums.length == 2 ){
			if(nums[0] != nums[1])
				return 2;
			else
				return 0;
		}

		int countOfZero = 0;
		int countOfOnes = 0;
	    int max = 0;

	    Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
	    indexMap.put(0, -1);
	    
	    for (int i = 0; i < nums.length; i++) {
	    	
	    	if(nums[i] == 0)
	    		++countOfZero;
	    	
	    	if(nums[i] == 1)
	    		++countOfOnes;	   
	    	
	    	int diffOneAndZero = Math.abs(countOfOnes - countOfZero);
	    	if(indexMap.containsKey(diffOneAndZero))
	    		max = Math.max(max, i - indexMap.getOrDefault(diffOneAndZero, 0));
	    	else
	    		indexMap.put(diffOneAndZero, i);

	    }
	
	    return max;   
	 }	
	 
	 /* 239
	  * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
	  *	For example,
	  *	Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
	  *
	  *Window position                Max
		---------------               -----
		[1  3  -1] -3  5  3  6  7       3
		 1 [3  -1  -3] 5  3  6  7       3
		 1  3 [-1  -3  5] 3  6  7       5
		 1  3  -1 [-3  5  3] 6  7       5
		 1  3  -1  -3 [5  3  6] 7       6
		 1  3  -1  -3  5 [3  6  7]      7
		 
	  * Therefore, return the max sliding window as [3,3,5,5,6,7].
	  */
	 private static int[] findSlidingWindowMaxValue(int[] nums, int k){
		 
		  if(nums == null || nums.length < 1)
			  return new int[0];
		  
		  int[] arr = new int[nums.length-k+1];
		  int index = 0;
		  PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		 
		  for(int i = 0; i < nums.length; i++){
			  
			  pq.add(nums[i]);
			  
			  if(pq.size() == k){
				  
				  arr[index] = pq.peek();				  
				  pq.remove(nums[i-k+1]);
				  index++;
			  }
		  }
		  
		  return arr; 
	 } 
}
