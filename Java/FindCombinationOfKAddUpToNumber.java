package Algo.Test;

import java.util.ArrayList;
import java.util.List;

public class FindCombinationOfKAddUpToNumber {

	public static void main(String[] args) {
	    int k = 3;
	    int n = 9;
	    System.out.println("");
	    System.out.print("All possible combinations of " + k + " numbers that add up to a number " + n + ", \ngiven that only numbers from 1 to 9 can be used and each  : ");
	    
	    for (List<Integer> list : allPossibleKCombinationAddUpToNumber(k, n)) {
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
	
	private static List<List<Integer>> allPossibleKCombinationAddUpToNumber(int k, int target){
			
		    List<List<Integer>> list = new ArrayList<List<Integer>>();
		    List<Integer> innerList = new ArrayList<Integer>();
		    allPossibleKCombinationAdd(k, target, target, 1, list, innerList);		    
		    return list;		     
	}
	 
	 private static void allPossibleKCombinationAdd(int k, int target, int targetIterator, int begin, List<List<Integer>> list, List<Integer> innerList) {
		 
	     if( target == 0 && innerList.size() == k){
	         list.add(new ArrayList<Integer>(innerList));
	         return;
	     }
	     
	     for(int i = begin; i < targetIterator; i++) {
	    
	    	 int nextTarget = target - i;
	    	 
	    	 if(nextTarget < 0 || innerList.size() > k){
	              break;
	         }
	    	 
	    	 innerList.add(i);          
	    	 allPossibleKCombinationAdd(k, nextTarget , targetIterator, i + 1, list, innerList);
	    	 innerList.remove(innerList.size() - 1);
	     }     
	 }	     
}
