package Algo.Test;

import java.util.*;

public class LargestNumberCombinationInArray {

	public static void main(String[] args) {
		
		Integer arr[] = new Integer[] { 1, 9, 7, 97, 12};
		System.out.println("Largest Number can be created by array : " + getLargestNumberByDescendingOrder(arr));
		System.out.println("");
		System.out.println("Largest Number can be created by array : " + getLargestNumberByLexicographicSort(arr));		
	}

	//Given an array of integer create largest number using 
	private static String getLargestNumberByLexicographicSort(Integer[] arr){
		
		int num1 = 0, num2 = 0;
		StringBuffer sb = new StringBuffer();
		
		System.out.println("Array before lexicographic sort :" + Arrays.toString(arr));	
		
	    Arrays.sort(arr, new Comparator<Integer>() {
	        @Override
	        public int compare(Integer n1, Integer n2) {
	            return n2.toString().compareTo(n1.toString());
	        }
	    });	
	    
	    System.out.println("Array after lexicographic sort  :" + Arrays.toString(arr));	
	    
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
	
	private static String getLargestNumberByDescendingOrder(Integer[] arr){
		
		int num1 = 0, num2 = 0;
		StringBuffer sb = new StringBuffer();
		
		System.out.println("Array before Normal sort :" + Arrays.toString(arr));	
		
	    Arrays.sort(arr);
	    
	    System.out.println("Array after Normal sort  :" + Arrays.toString(arr));	
	    
		sb.append(arr[arr.length -1]);
		
		for(int i = (arr.length -2); i >= 0; i--){
			
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