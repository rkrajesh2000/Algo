package Algo.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllCombinationInArrayAddUpToNumber {

	public static void main(String[] args) {

		int target = 8;

        int[] arrayForPairs = new int[] { 3, 5, 4, 2, 1, 7, 6, -1, 10, 9 };
		//int[] arrayForPairs = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		//int[] arrayForPairs = new int[] {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        System.out.print("Input Array : [");
       	for(int val : arrayForPairs ){
    		System.out.print(val);
    		System.out.print(",");
    	}
       	
       	System.out.print("] and target number : " + target);
        System.out.println("");
        System.out.print("Result with unique conbination : ");
        
        for (List<Integer> list : uniqueCombinationAddUpToNumber(arrayForPairs, target)) {
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
        System.out.println("");
        System.out.print("Result with all possible conbination : ");
        
        for (List<Integer> list : allPossibleCombinationAddUpToNumber(arrayForPairs, target)) {
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
	public static List<List<Integer>> uniqueCombinationAddUpToNumber(int[] array, int target){

	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> combinationList = new ArrayList<Integer>();
	    Arrays.sort(array);
	    uniqueCombinationAdd(array, target, 0, list, combinationList);
	    return list;	     
	}
	 
	 private static void uniqueCombinationAdd(int[] array, int target, int begin, List<List<Integer>> list, List<Integer> combinationList) {
	 
	     if( target == 0){
	         list.add(new ArrayList<Integer>(combinationList));
	         return;
	     }
	     
         int num = Integer.MIN_VALUE;

	     for(int i = begin; i < array.length; i++) {
             if(num != array[i]) {

	             combinationList.add(array[i]);
	             
                if(target - array[i] < 0){
                  continue;
                }
	             int nextTarget = target - array[i];
	             uniqueCombinationAdd(array, nextTarget , i + 1, list, combinationList);
	             combinationList.remove(combinationList.size() - 1);
                 num = array[i];
             }
	     }     
	 }
	 
	 /*Find all possible combinations of k numbers that add up to a number n, 
	  * given that only numbers from 1 to 9 can be used and each combination 
	  * should be a unique set of numbers.*/	 
	 public static List<List<Integer>> allPossibleCombinationAddUpToNumber(int[] array, int target){
	
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> combinationList = new ArrayList<Integer>();
	    allPossibleCombinationAdd(array, target, 0, list, combinationList);
	    return list;
	     
	 }	
	 
	 private static void allPossibleCombinationAdd(int[] array, int target, int begin, List<List<Integer>> list, List<Integer> combinationList) {
		 
	     if( target == 0){
	         list.add(new ArrayList<Integer>(combinationList));
	         return;
	     }
	     
	     for(int i = begin; i < array.length; i++) {
	    	 
             if(target - array[i] < 0){
                 continue;
               }	    	 
             combinationList.add(array[i]);
             int nextTarget = target - array[i];
             allPossibleCombinationAdd(array, nextTarget , i + 1, list, combinationList);
             combinationList.remove(combinationList.size() - 1);
	     }     
	 }	 
}
