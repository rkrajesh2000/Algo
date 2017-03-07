package Algo.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class FindPairInArrayAddUpToNumber {

	public static void main(String[] args) {

		//int[] number = new int[] {-1,-2,-3,-4,-5};
		int givenNum = -8;
        StringBuilder sb = new StringBuilder();
        givenNum = 12;
        sb.append("Find all the pair of 2 numbers in array, which add up to the number : " + String.valueOf(givenNum));
        sb.append("\nGiven array (value|index) is : { 1|0, 2|1, 6|2, 6|3, 3|4, 4|5, 8|6, 6|7, 4|8, 8|9, 9|10 } is and pairs are\n");
        sb.append("pairAddUpToNumber : ");
        int[] arrayForPairs = new int[] { 1, 2, 6, 6, 3, 4, 8, 6, 4, 8, 9 };
        pairAddUpToNumber(arrayForPairs, givenNum, sb);	
        System.out.println(sb);
        
        int[] threeSumArray = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.print("Find three sum equals to zero in an array by threeSum() :");
        
        for (List<Integer> list : threeSum(threeSumArray)) {
        	System.out.print("[");
        	
        	for(int val : list ){
        		System.out.print(val);
        		System.out.print(",");
        	}
        	
        	System.out.print("],");
        }
        
        System.out.println("");       
        
        System.out.print("Find three sum equals to zero in an array by allPossibleKCombinationAddUpToNumber() :");        

        for (List<Integer> list : allPossibleKCombinationAddUpToNumber(threeSumArray,3, 0)) {
        	System.out.print("[");
        	
        	for(int val : list ){
        		System.out.print(val);
        		System.out.print(",");
        	}
        	
        	System.out.print("],");
        }
        
        System.out.println("");
        
        int[] fourSumArray = new int[] {-1, 0, -1, 0, -2, 2};
        System.out.print("Find four sum equals to zero in an array by fourSum():");  
        
        for (List<Integer> list : fourSum(fourSumArray,0)) {
        
        	System.out.print("[");
        	
        	for(int val : list ){
        		System.out.print(val);
        		System.out.print(",");
        	}
        	
        	System.out.print("],");
        }
        
        System.out.print("\nFind four sum equals to zero in an array by allPossibleKCombinationAddUpToNumber() :");  
        
        for (List<Integer> list : allPossibleKCombinationAddUpToNumber(fourSumArray,4, 0)) {
        
        	System.out.print("[");
        	
        	for(int val : list ){
        		System.out.print(val);
        		System.out.print(",");
        	}
        	
        	System.out.print("],");
        }        
	}
	
	 
    // Find all the pair of 2 numbers in array, which add up to the number
    // Example: Find all pairs of 2 numbers in the given array, which add up to the number 10.	
    private static void pairAddUpToNumber(int[] array, int num, StringBuilder sb)
    {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    	for(int n : array ) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
            	map.put(n, 1);
        }

    	for(int n : array ) {    		
            int val = num;
            val = val - n;
            pairAddUpToNumberCheckForRemainning(val, n, map, sb);
        }
    }
    
    private static void pairAddUpToNumberCheckForRemainning(int val, int n, HashMap<Integer, Integer> map, StringBuilder sb)
    {
        if (val == n && map.containsKey(val) && (int)map.get(val) > 1)
        {
            for (int j = 0; j < (int)map.get(val); j++)
            {
                sb.append(" ( " + String.valueOf(val) + "," + String.valueOf(n) + " ) ");
            }

            map.remove(val);
        }
        else if (val != n && map.containsKey(val) && (int)map.get(val) > 0)
        {
            for (int j = 0; j < ((int)map.get(val) * (int)map.get(n)); j++)
            {
            	sb.append(" ( " + String.valueOf(val) + "," + String.valueOf(n) + " ) ");
            }

            map.remove(val);
            map.remove(n);
        }
    }	
	
    //Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
    //Find all unique triplets in the array which gives the sum of zero
    //For example, given array S = {-1 0 1 2 -1 -4},
    // Output: (-1, 0, 1), (-1, -1, 2)
    //Time complexity is O(n^2)
	public static List<List<Integer>> threeSum(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	    if(nums == null || nums.length<3)
	        return result;
	 
	    Arrays.sort(nums);
	 
	    for(int i=0; i<nums.length-2; i++){
	        if(i==0 || nums[i] > nums[i-1]){
	            int j=i+1;
	            int k=nums.length-1;
	 
	            while(j<k){
	                if(nums[i]+nums[j]+nums[k]==0){
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(nums[i]);
	                    list.add(nums[j]);
	                    list.add(nums[k]);
	                    result.add(list);
	                    
	                    j++;
	                    k--;
	 
	                    //handle duplicate here
	                    while(j<k && nums[j]==nums[j-1])
	                        j++;
	                    while(j<k && nums[k]==nums[k+1])
	                        k--;
	 
	                }else if(nums[i]+nums[j]+nums[k]<0){
	                    j++;
	                }else{
	                    k--;
	                }
	            }
	        }	 
	    }
	 
	    return result;
	    //return sb.toString();
	}

	//A typical k-sum problem. Time is N to the power of (k-1)
	public static List<List<Integer>> fourSum(int[] nums, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	    if(nums==null|| nums.length<4)
	        return result;
	 
	    Arrays.sort(nums);
	 
	    for(int i=0; i<nums.length-3; i++){
	        if(i!=0 && nums[i]==nums[i-1])
	            continue;
	        for(int j=i+1; j<nums.length-2; j++){
	            if(j!=i+1 && nums[j]==nums[j-1])
	                continue;
	            int k=j+1;
	            int l=nums.length-1;
	            while(k<l){
	                if(nums[i]+nums[j]+nums[k]+nums[l]<target){
	                    k++;
	                }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
	                    l--;
	                }else{
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(nums[i]);
	                    list.add(nums[j]);
	                    list.add(nums[k]);
	                    list.add(nums[l]);
	                    result.add(list);
	 
	                    k++;
	                    l--;
	 
	                    while(k<l && nums[k]== nums[k-1]){
	                        k++;
	                    }
	                    
	                    while(k<l && nums[l]== nums[l+1] ){
	                        l--;
	                    }
	                }	 
	            }
	        }
	    }
	 
	    return result;
	}
	
	// Test Case: [-6,14,-11,7,-5,-8,12,-13,-3,-14,7,0,-7,-15,-5,-9,-13,-7,-5,9,8,-13,-6,-8,-12,7,-10,11,8,-14,12,9,-15,-14,1,-5,-7,-10,-10,5,-9,12,12,-1,12,14,-2,-15,-8,0,9,7,2,10,14,-3,2,11,-6,-13,12,13,11,5,14,-11,7,14,-6,12,-4,-7,9,-7,-1,-1,-8,4,-9,-9,-11,-15,5,6,10,4,11,-10,-8,12,-8,-10,10,11,2,9,-15,-14,0,-13,14,11,-5,0,-11,1,6,-12]
	private static List<List<Integer>> allPossibleKCombinationAddUpToNumber(int[] array, int k, int target){
		
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> innerList = new ArrayList<Integer>();
	    Arrays.sort(array);
	    allPossibleKCombinationAdd(array, k, target, 0, list, innerList);
	    return list;		     
	}
	 
	 private static void allPossibleKCombinationAdd(int[] array, int k, int target, int begin, List<List<Integer>> list, List<Integer> innerList) {
		 
	     if( target == 0 && innerList.size() == k){
	         list.add(new ArrayList<Integer>(innerList));
	         return;
	     }
	     
	     int num = Integer.MIN_VALUE;
	     
	     for(int i = begin; i < array.length; i++) {
      	      if(innerList.size() > k && target != 0 ){
                 continue;
              }	  
      	      
		      if(num != array[i]) {
	    	      innerList.add(array[i]);
			      int nextTarget = target - array[i];
			      allPossibleKCombinationAdd(array, k, nextTarget , i + 1, list, innerList);
			      innerList.remove(innerList.size() - 1);
			      num = array[i];
			     } 
	     }
	}	
	
}
