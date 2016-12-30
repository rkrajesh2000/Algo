package Algo.Test;

import java.util.HashMap;

public class FindIndexOfArrayAddUpToNumber {

	public static void main(String[] args) {

		int[] number = new int[] {-1,-2,-3,-4,-5};
		int[] out = indexOfPairAddUpToNumber(number,-8);
		System.out.println("[" + String.valueOf(out[0]) + "," + String.valueOf(out[1]) + "]");
	}

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
}
