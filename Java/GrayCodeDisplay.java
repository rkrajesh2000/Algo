package Algo.Test;

import java.util.*;

public class GrayCodeDisplay {

	public static void main(String[] args) {

		System.out.println("grayCode() :");
		
		for(int i : grayCode(3)){
			System.out.println(i);
		}
		
		System.out.println();
		System.out.print("Find the smallest Sparse number which is greater than or equal to N by UnOptimized : ");
		findSparseNumberUnOptimized(6);
		System.out.println();
		System.out.print("Find the smallest Sparse number which is greater than or equal to N by Optimized: " + findSparseNumberOptimized(6));
		
		int[][] matrix = new int[][]{
		        {0 , 0 , 3 , 0 , 4 },
		        {0 , 0 , 5 , 7 , 0 },
		        {0 , 0 , 0 , 0 , 0 },
		        {0 , 2 , 6 , 0 , 0 }
		    };
		createSparseMatrix(matrix);
	}
	
	public static List<Integer> grayCode(int n) {
	    if(n==0){
	        List<Integer> list = new ArrayList<Integer>();
	        list.add(0);
	        return list;
	    }
	 
	    List<Integer> result = grayCode(n-1);
	    int numToAdd = 1<<(n-1); //This would give [2 ^ (n-1)] value
	 
	    for(int i=result.size()-1; i>=0; i--){
	        result.add( numToAdd + result.get(i) );
	    }
	 
	    return result;
	}
	
	//This is not an optimized solution
	private static void findSparseNumberUnOptimized(int num) {

		if((num & (num << 1)) == 0){ //(num << 1) is same as (num * 2)
			System.out.println(num);			
			return;
		}
			
		for (int i = num + 1; i < Integer.MAX_VALUE; i++) {

			if ((i & (i << 1)) == 0) {				
				System.out.print(i);				
				return;
			}
		}
	}
	
	/*
	 * Find Next Sparse Number
	 * This is an optimized solution
	 */
	private static int findSparseNumberOptimized(int num) {		
		List<Integer> list = new ArrayList<Integer>();
		int n = num;

		while(n > 0){
			list.add(n & 1 );	// This is same as (n%2)	
			n >>= 1;			// This is same as (n/2)
		}
		
		// There might be extra bit in result, so add one extra bit
		list.add(0);
		int tracker = 0;
		
		for(int i = 1; i < list.size() -1; i++){

			if(list.get(i) == 1 && list.get(i-1) == 1 && list.get(i+1) != 1){
				
				list.set(i+1, 1);
				
				//Start back track and add 0 till last tracker point
				for(int j = i; j >= tracker; j--)
					list.set(j, 0);				
				
				++tracker;
			}
		}		
	    
	    int ans = 0;
	    
	    for (int i = 0; i < list.size(); i++)
	        ans += list.get(i) *(1<<i); // (1<<i) is same as multiplying 2
	    
	    return ans;
	}
	
	//Sparse Matrix and its representations. store only non zero values to save space
	private static void createSparseMatrix(int[][] matrix) {
		
		System.out.println();
		System.out.println("Input matrix");
		
		int size = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] != 0)
					size++;
				
				System.out.print(matrix[i][j] + " ,");
			}
			System.out.println();
		}
		
		int[][] sparseMatrix = new int[3][size];
		int k = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] != 0){
					sparseMatrix[0][k] = i;
					sparseMatrix[1][k] = j;
					sparseMatrix[2][k] = matrix[i][j];
					++k;
				}
			}
		}
		
		System.out.println("Sparse matrix");
		for(int i = 0; i < sparseMatrix.length; i++){
			for(int j = 0; j < sparseMatrix[0].length; j++){
				System.out.print(sparseMatrix[i][j] + " ,");
			}
			System.out.println();
		}
	}
}
