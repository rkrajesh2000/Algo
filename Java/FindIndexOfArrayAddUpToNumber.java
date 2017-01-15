package Algo.Test;

import java.util.HashMap;

public class FindIndexOfArrayAddUpToNumber {

	public static void main(String[] args) {
		
		int[] number = new int[] {-1,-2,-3,-4,-5};
		int givenNum = -8;
		int[] out = indexOfPairAddUpToNumber(number,givenNum);
		System.out.print("Index Of Pair Add Up To Number " + String.valueOf(givenNum) + " : [" + String.valueOf(out[0]) + "," + String.valueOf(out[1]) + "]");
	}

	//Index Of 2 Pair in an array, which add up to the input number
	//Time complexity depends on the put and get operations of HashMap 
	//which is normally O(1).
	//Test Case: {-1,-2,-3,-4,-5} and -8. Output [2,4]
	//Input: numbers={2, 7, 11, 15}, target=9 
	//Output: index1=0, index2=1. Time complexity of this solution is O(n)
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
				
				map.remove(val);
			}
		}
		
		return new int[]{-1,-1};
	}
}
