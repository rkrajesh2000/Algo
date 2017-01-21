package Algo.Test;

import java.util.ArrayList;
import java.util.List;

public class FindCombinationOfKAddUpToNumber {

	public static void main(String[] args) {
	    int k = 3;
	    int n = 9;
	    System.out.println("");
	    System.out.print("All possible combinations of " + k + " numbers that add up to a number " + n + ", \ngiven that only numbers from 1 to 9 can be used and each  : ");
	    
	    for (List<Integer> list : allPossible3CombinationAddUpToNumber(k, n)) {
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
	
	private static List<List<Integer>> allPossible3CombinationAddUpToNumber(int k, int target){
			
		    List<List<Integer>> list = new ArrayList<List<Integer>>();
		    List<Integer> combinationList = new ArrayList<Integer>();
		    allPossible3CombinationAdd(k, target, 1, list, combinationList);		    
		    return list;		     
	}
	 
	 private static void allPossible3CombinationAdd(int k, int target, int begin, List<List<Integer>> list, List<Integer> combinationList) {
		 
	     if( target == 0 && combinationList.size() == k){
	         list.add(new ArrayList<Integer>(combinationList));
	         return;
	     }
	     
	     for(int i = begin; i < 10; i++) {
	    	 
          if(target - i < 0 || combinationList.size() > k){
              continue;
            }	    	 
          combinationList.add(i);
          int nextTarget = target - i;
          allPossible3CombinationAdd(k, nextTarget , i + 1, list, combinationList);
          combinationList.remove(combinationList.size() - 1);
	     }     
	 }	     
}
