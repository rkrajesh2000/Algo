package Algo.Test;

import java.util.*;

public class LargestNumberCombinationInArray {

	public static void main(String[] args) {
		
		Integer arr[] = new Integer[] { 1, 9, 7, 97, 12};
		System.out.println("Largest Number can be created by array : " + getLargestNumberByLexicographicSort(arr));
		
		findKthNumberLexicalOrder(13,2);
		lexicalOrder(13);
	}

	//Given an array of integer create largest number using 
	private static String getLargestNumberByLexicographicSort(Integer[] arr){
		
		int num1;
		int num2;
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
	

	private static void lexicalOrder(int n){
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= n; i++){
			list.add(i);
		}
		
		Collections.sort(list, new Comparator<Integer>() {
	        @Override
	        public int compare(Integer n1, Integer n2) {
	            return n1.toString().compareTo(n2.toString());
	        }
	    });	
		
		System.out.println("Lexical Order : ");
		for(int num : list){
			System.out.print(num + ", ");
		}
	}
	
    private static void findKthNumberLexicalOrder(int n, int k) {
        
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= n; i++){
			list.add(i);
		}
		
		Collections.sort(list, new Comparator<Integer>() {
	        @Override
	        public int compare(Integer n1, Integer n2) {
	            return n1.toString().compareTo(n2.toString());
	        }
	    });	  
	    
		System.out.println(k +"nd number in lexical order : " + list.get(k-1));
    }	
}
