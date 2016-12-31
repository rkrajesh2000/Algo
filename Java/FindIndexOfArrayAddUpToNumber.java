package Algo.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class FindIndexOfArrayAddUpToNumber {

	public static void main(String[] args) {

		int[] number = new int[] {-1,-2,-3,-4,-5};
		int[] out = indexOfPairAddUpToNumber(number,-8);
		System.out.println("[" + String.valueOf(out[0]) + "," + String.valueOf(out[1]) + "]");
		
        StringBuilder sb = new StringBuilder();
        int givenNum = 12;
        sb.append("\nFind all the pair of 2 numbers in array, which add up to the number : " + String.valueOf(givenNum));
        sb.append("\nGiven array (value|index) is : { 1|0, 2|1, 6|2, 6|3, 3|4, 4|5, 8|6, 6|7, 4|8, 8|9, 9|10 } is and pairs are\n");
        sb.append("pairAddUpToNumber : ");
        int[] arrayForPairs = new int[] { 1, 2, 6, 6, 3, 4, 8, 6, 4, 8, 9 };
        pairAddUpToNumber(arrayForPairs, givenNum, sb);	
        System.out.println(sb);
        
        int[] threeSumArray = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println("Find three sum equals to zero in an array :");
        //System.out.println(threeSum(threeSumArray));  
        
        for (List<Integer> list : threeSum(threeSumArray)) {
        	System.out.print("[");
        	
        	for(int val : list ){
        		System.out.print(val);
        		System.out.print(",");
        	}
        	
        	System.out.print("],");
        }
	}

	// Index Of 2 Pair in an array, which add up to the input number
	public static int[] indexOfPairAddUpToNumber(int[] nums, int target){
		
		if(nums == null || nums.length < 2)
			return new int[]{-1,-1};;
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
				
		for(int i = 0; i < nums.length; i++){
			
			if(map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i]) + "," + String.valueOf(i)) ;
			else
				map.put(nums[i], String.valueOf(i));
		}
		
		for(int i = 0; i < nums.length; i++){
			
			int val = target - nums[i];
			
			//This is for duplicate numbers
			if(val == nums[i] && map.containsKey(val))
			{
				String[] iStr = map.get(nums[i]).split(",");
				
				if(iStr.length > 1){				
					for(int j = 0; j < iStr.length; j++){
						for(int k=(j+1); k < iStr.length; k++){
							if ((nums[Integer.parseInt(iStr[j])] + nums[Integer.parseInt(iStr[k])]) == target){
								return new int[]{Integer.parseInt(iStr[j]),Integer.parseInt(iStr[k])};
							}
						}
					}
				}
				
				if(map.containsKey(val))
					map.remove(val);
				
			}
			else if( val != nums[i] && map.containsKey(val))
			{
				String[] iStr = map.get(nums[i]).split(",");
				String[] iStrVal = map.get(val).split(",");
				
			
				for(int j = 0; j < iStr.length; j++){
					for(int k = 0; k < iStrVal.length; k++){
						if ((nums[Integer.parseInt(iStr[j])] + nums[Integer.parseInt(iStrVal[k])]) == target){
							return new int[]{Integer.parseInt(iStr[j]),Integer.parseInt(iStrVal[k])};
						}
					}
				}
				
				if(map.containsKey(val))
					map.remove(val);
			}
		}
		
		return new int[]{-1,-1};
	}
	
    // Find all the pair of 2 numbers in array, which add up to the number
    // Example: Find all pairs of 2 numbers in the given array, which add up to the number 10.	
    private static void pairAddUpToNumber(int[] array, int num, StringBuilder sb)
    {
    	HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();

    	for(int n : array ) {
            if (ht.containsKey(n))
                ht.put(array[n], ht.get(n) + 1);
//            else
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

            if (ht.containsKey(val))
                ht.remove(val);
        }
        else if (val > 0 && val != n && ht.containsKey(val) && (int)ht.get(val) > 0)
        {
            for (int j = 0; j < ((int)ht.get(val) * (int)ht.get(n)); j++)
            {
            	sb.append(" ( " + String.valueOf(val) + "," + String.valueOf(n) + " ) ");
            }

            if (ht.containsKey(val))
                ht.remove(val);

            if (ht.containsKey(n))
                ht.remove(n);
        }
    }	
	
    //Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
    //Find all unique triplets in the array which gives the sum of zero
    //For example, given array S = {-1 0 1 2 -1 -4},
    // Output: (-1, 0, 1), (-1, -1, 2)
    //Time complexity is O(n^2)
	public static List<List<Integer>> threeSum(int[] nums) {
//    public static String threeSum(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
//	    StringBuilder sb = new StringBuilder();
	 
	    if(nums == null || nums.length<3)
//	    	return "";
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
	                    
//	                    sb.append("[" + String.valueOf(nums[i]) + ", " + String.valueOf(nums[j]) + ", " + String.valueOf(nums[k]) +"]");
//	                    sb.append(", ");
	                    
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

}
