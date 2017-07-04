package Algo.Test;

import java.util.*;

public class ZigZagConvertor {

	public static void main(String[] args) {

		System.out.println(convertToZigZag("PAYPALISHIRING", 3));
		System.out.println(convertToZigZag("INTELISHIRING", 3));
		System.out.println(convertToZigZag("INTELISHIRING", 3));
		int[] arr = new int[] {4, 3, 7, 8, 6, 2, 1};
		//System.out.println(convertToZigZagArr(arr, arr.length/2).toString());
		System.out.print("convertToZigZagArr() : ");
		for(int i : convertToZigZagArr(arr, 3)){
			System.out.print(i + ",");
		}
		
		System.out.println();
		System.out.print("spiralRotation() : ");
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		for(int i : spiralRotation(matrix)){
			System.out.print(i + ",");
		}
		
		System.out.println();
		System.out.print("createAndReturnSpiralRotation() : ");
		System.out.println();
		for(int[] nums : createAndReturnSpiralRotation(3)){
			for(int n : nums)
				System.out.print(n + ",");
			
			System.out.println();
		}		
	}
   
	public static String convertToZigZag(String s, int numRows) {
		if (numRows == 1)
			return s;
	 
		StringBuilder sb = new StringBuilder();
		// step
		int step = 2 * numRows - 2;
		//System.out.println("numRows : " + numRows);
		//System.out.println("step : " + step);
		
		for (int i = 0; i < numRows; i++) {
			//first & last rows
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j = j + step) {
					sb.append(s.charAt(j));
					//System.out.println("1-j :" + j + ", i : " + i + ", Val : " + s.charAt(j));
				}
			//middle rows	
			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;
				
				//System.out.println("step1 : " + step1);
				//System.out.println("step2 : " + step2);
				
				while (j < s.length()) {
					sb.append(s.charAt(j));
					//System.out.println("2-j :" + j + ", i : " + i + ", Val : " + s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
	 
		return sb.toString();
	}	
	
	public static int[] convertToZigZagArr(int[] arrIn, int numRows) {
		if (numRows == 1)
			return arrIn;
	 
		int[] arrOut = new int[arrIn.length];
		int count = 0;

		int step = 2 * numRows - 2;
		
		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < arrIn.length; j = j + step) {
					arrOut[count++]= arrIn[j];
				}

			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;
				
				while (j < arrIn.length) {
					arrOut[count++]= arrIn[j];

					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
	 
		return arrOut;
	}
	
	/*
	 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
		For example,
		Given the following matrix:		
		[
		 [ 1, 2, 3 ],
		 [ 4, 5, 6 ],
		 [ 7, 8, 9 ]
		]
		You should return [1,2,3,6,9,8,7,4,5].
	*/
    public static List<Integer> spiralRotation(int[][] matrix) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;
        int rowStart = 0;
        int colStart = 0;
        
        while(rowStart < rowEnd && colStart < colEnd){
            
            for(int i=colStart; i < colEnd; ++i)
                list.add(matrix[rowStart][i]);
            
            ++rowStart;
            
            for(int i=rowStart; i < rowEnd; ++i)
                list.add(matrix[i][colEnd-1]);
                
            colEnd--;
            
            if(rowStart < rowEnd){
                
                for(int i = colEnd-1; i >= colStart; --i)
                    list.add(matrix[rowEnd-1][i]);
                
                rowEnd--;
            }
            
            if(colStart < colEnd){
                
                for(int i = rowEnd-1; i >= rowStart; --i)
                    list.add(matrix[i][colStart]);
                    
                colStart++;
            }
        }
        
        return list;
    }
    
    /*
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
		For example,
		Given n = 3,		
		You should return the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]
    */
    public static int[][] createAndReturnSpiralRotation(int n) {
        
    	if(n <= 0)
    		return null;
        
        int[][] matrix = new int[n][n];
        
        if(n == 1){
        	matrix[0][0] = 1;
            return matrix;
        }
        
        int count = 1;
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;
        int rowStart = 0;
        int colStart = 0;
        
        while(rowStart < rowEnd && colStart < colEnd){
            
            for(int i=colStart; i < colEnd; ++i)
            	matrix[rowStart][i] = count++;
             
            ++rowStart;
            
            for(int i=rowStart; i < rowEnd; ++i)
            	matrix[i][colEnd-1] = count++;
                
            colEnd--;
            
            if(rowStart < rowEnd){
                
                for(int i = colEnd-1; i >= colStart; --i)
                	matrix[rowEnd-1][i] = count++;
                
                rowEnd--;
            }
            
            if(colStart < colEnd){
                
                for(int i = rowEnd-1; i >= rowStart; --i)
                	matrix[i][colStart] = count++;
                    
                colStart++;
            }
        }
        
        
        return matrix;
    }    
}
