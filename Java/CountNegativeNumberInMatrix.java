package Algo.Test;

public class CountNegativeNumberInMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = new int[][]{
				{-3, -2, -1, 1},
				{-2,  2,  3, 4},
				{ 4,  5,  7, 8}
		};

		System.out.println("Negative number count in a row and column wise sorted matrix is : " + CountNegativeNumber(matrix));
	}
	
	private static int CountNegativeNumber(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;
		int count = 0;
		int i = 0;
		int j = m - 1;
		
		while(j >= 0 && i < n){
			if(matrix[i][j] < 0){			
				count = count + (j + 1);
				++i;
			}
			else
				--j;
		}
			
		return count;
	}
}
