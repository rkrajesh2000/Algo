package Algo.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class FindPairInArrayAddUpToNumber {

	public static void main(String[] args) {

		int[] number = new int[] {-1,-2,-3,-4,-5};
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
        
        int[] fourSumArray = new int[] {-1, 0, -1, 0, -2, 2};
        System.out.print("Find four sum equals to zero in an array :");  
        
        for (List<Integer> list : fourSum(fourSumArray,0)) {
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
    	HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();

    	for(int n : array ) {
            if (ht.containsKey(n))
                ht.put(array[n], ht.get(n) + 1);
            else
            	ht.put(n, 1);
        }

    	for(int n : array ) {    		
            int val = num;
            val = val - n;
            pairAddUpToNumberCheckForRemainning(val, n, ht, sb);
        }
    }
    
    private static void pairAddUpToNumberCheckForRemainning(int val, int n, HashMap<Integer, Integer> ht, StringBuilder sb)
    {
        if (val == n && ht.containsKey(val) && (int)ht.get(val) > 1)
        {
            for (int j = 0; j < (int)ht.get(val); j++)
            {
                sb.append(" ( " + String.valueOf(val) + "," + String.valueOf(n) + " ) ");
            }

            ht.remove(val);
        }
        else if (val != n && ht.containsKey(val) && (int)ht.get(val) > 0)
        {
            for (int j = 0; j < ((int)ht.get(val) * (int)ht.get(n)); j++)
            {
            	sb.append(" ( " + String.valueOf(val) + "," + String.valueOf(n) + " ) ");
            }

            ht.remove(val);
            ht.remove(n);
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
	                    List<Integer> l = new ArrayList<Integer>();
	                    l.add(nums[i]);
	                    l.add(nums[j]);
	                    l.add(nums[k]);
	                    result.add(l);
	                    
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
	                    List<Integer> t = new ArrayList<Integer>();
	                    t.add(nums[i]);
	                    t.add(nums[j]);
	                    t.add(nums[k]);
	                    t.add(nums[l]);
	                    result.add(t);
	 
	                    k++;
	                    l--;
	 
	                    while(k<l &&nums[k]==nums[k-1]){
	                        k++;
	                    }
	                    
	                    while(k<l &&nums[l]==nums[l+1] ){
	                        l--;
	                    }
	                }	 
	            }
	        }
	    }
	 
	    return result;
	}
}
