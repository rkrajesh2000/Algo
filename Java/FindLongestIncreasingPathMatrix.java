package Algo.Test;

public class FindLongestIncreasingPathMatrix {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) {
        
		int matrix1[][] = {
				{1, 2, 3, 4, 5, 6},
				{7, 8, 9, 10, 11, 12},
				{13, 14, 15, 16, 17, 18},
				{19, 20, 21, 22, 23, 24},
				{25, 26, 27, 28, 29, 30}
    		};
		
		System.out.println("Original matrix #1");
		printPath(matrix1);
		System.out.println("After calculation");
       	System.out.println("Longest Increasing Path Matrix in matrix #1 : " + longestIncreasingPath(matrix1));
       	
		int matrix2[][] = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
				}; 
		
		System.out.println("Original matrix #2");
		printPath(matrix2);
		System.out.println("After calculation");
		System.out.println("Longest Increasing Path Matrix in matrix #2 [1, 2, 6, 9] : " + longestIncreasingPath(matrix2));
	}
 
    private static int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
 
        int[][] mem = new int[matrix.length][matrix[0].length];
        int longest=0;
 
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                longest = Math.max(longest, dfs(matrix, i, j, mem));
            }
        }
        
        printPath(mem);
        
        return longest;
    }
 
    private static int dfs(int[][] matrix, int i, int j,  int[][] mem){
        if(mem[i][j]!=0)
            return mem[i][j];
 
        for(int m=0; m<4; m++){
            int x = i+dx[m];
            int y = j+dy[m];
 
            if(x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && matrix[x][y] > matrix[i][j]){
                mem[i][j]=Math.max(mem[i][j], dfs(matrix, x, y, mem));
            }
        } 
 
        return ++mem[i][j];
    }
 
    private static void printPath(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(" " + matrix[i][j] +
                                 " ");
            System.out.println();
        }
    }
}
