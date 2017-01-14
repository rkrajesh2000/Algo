package Algo.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPairInArrayAddUpToNumber {

	public static void main(String[] args) {

		int target = 8;

        int[] arrayForPairs = new int[] { 3, 5, 4, 2, 1, 7, 6, -1, 10, 9 };

        System.out.print("Input Array : [");
       	for(int val : arrayForPairs ){
    		System.out.print(val);
    		System.out.print(",");
    	}
       	
       	System.out.print("] and target number : " + target);
        System.out.println("");
        System.out.print("Result : ");
        
        for (List<Integer> list : pairAddUpToNunber(arrayForPairs, target)) {
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

	public static List<List<Integer>> pairAddUpToNunber(int[] array, int target){

	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> pairList = new ArrayList<Integer>();
	    //Arrays.sort(array);
	    pairAdd(array, target, 0, list, pairList);
	    return list;
	     
	}
	 
	 private static void pairAdd(int[] array, int target, int begin, List<List<Integer>> list, List<Integer> pairList) {
	 
	     if( target == 0){
	         list.add(new ArrayList<Integer>(pairList));
	         return;
	     }
	     
	     for(int i = begin; i < array.length; i++) {
	         
             pairList.add(array[i]);
             int nextTarget = target - array[i];
             pairAdd(array, nextTarget , i + 1, list, pairList);
             pairList.remove(pairList.size() - 1);
	     }     
	 } 
}
