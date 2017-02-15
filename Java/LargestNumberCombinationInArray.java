package Algo.Test;

import java.util.*;

public class LargestNumberCombinationInArray {

	public static void main(String[] args) {
		
		int arr[] = new int[] { 1, 9, 7, 97, 12};
		System.out.println(GetLargestNumber(arr));

	}

	private static String GetLargestNumber(int[] arr){
		
		int num1 = 0, num2 = 0;
		StringBuffer sb = new StringBuffer();
		Arrays.sort(arr);
		sb.append(arr[0]);
		
		for(int i = 1; i < arr.length; i++){
			
			num1 = Integer.parseInt(sb.toString() + arr[i]);
			num2 = Integer.parseInt(arr[i] + sb.toString());
			
			if(num1 > num2)
				sb.append(arr[i]);
			else
				sb.insert(0, arr[i]);
		}
		
		return sb.toString();
	}
}
