package Algo.Test;

public class FindUniquePath {

	public static void main(String[] args) {

		System.out.println("uniquePaths() --> Total Unique paths found : " + uniquePaths(3,7));
		System.out.println("uniquePathsByDFS() --> Total Unique paths found by DFS : " + uniquePathsByDFS(3,7));
		
		int[][] grid = new int[][]{
		  {0,0,0},
		  {0,1,0},
		  {0,0,0}
		};
	
		System.out.println("uniquePathsWithObstacle() --> Total Unique paths found : " + uniquePathsWithObstacle(grid));
		
		int[][] grid2 = new int[][]{
				  {1,2,5},
				  {3,2,1}
				  //{7,8,9}
				};
			
				System.out.println("minPathSum(): Minimum paths sum : " + minPathSum(grid2));		
	}
	
	private static void printMatrix(int[][] matrix){
		
		System.out.println();
		
		for(int i = 0; i < matrix.length; ++i){
			for(int j = 0; j < matrix[0].length; ++j){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}		
	}

	private static int uniquePaths(int n, int m)
	{
		if(n == 0 && m == 0)
			return 0;
		
		if(n == 1 && m == 1)
			return 1;
		
		int[][] matrix = new int[n][m];

		
		for(int i = 0; i < n; i++){
			matrix[i][0] = 1;
		}

		for(int i = 0; i < m; i++){
			matrix[0][i] = 1;
		}

		for(int i = 1; i < n; i++){
			for(int j = 1; j < m; j++){
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
			}			
		}
		
		printMatrix(matrix);
		
		return matrix[n-1][m-1];
	}
	
	private static int uniquePathsByDFS(int n, int m){
		return dfs(0,0,n,m);
	}
	
	private static int dfs(int i, int j, int n, int m){
	    if(i==m-1 && j==n-1){
	        return 1;
	    }
	 
	    if(i<m-1 && j<n-1){
	        return dfs(i+1,j,n,m) + dfs(i,j+1,n,m);
	    }
	 
	    if(i<m-1){
	        return dfs(i+1,j,n,m);
	    }
	 
	    if(j<n-1){
	        return dfs(i,j+1,n,m);
	    }
	 
	    return 0;
	}
	
	private static int uniquePathsWithObstacle(int[][] obstacleGrid)
	{
	    if(obstacleGrid==null||obstacleGrid.length==0)
	        return 0;
	    
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		
		if(n == 0 && m == 0)
			return 0;
		
		if(n == 1 && m == 1 && obstacleGrid[0][0] == 1)
		    return 0;
		    
		if(n == 1 && m == 1 && obstacleGrid[0][0] != 1)
			return 1;
		
	    if((n > 1 && m > 1) && (obstacleGrid[0][0]==1||obstacleGrid[n-1][m-1]==1)) 
	        return 0;
	    
		int[][] matrix = new int[n][m];
		matrix[0][0] = 1;
		
		for(int i = 0; i < n; i++){
		    if(obstacleGrid[i][0] != 1)
		        matrix[i][0] = 1;
//		    else 
//		    	matrix[i][0] = (i-1) >= 0 ? matrix[i-1][0] : 1;
		}
		
		for(int i = 0; i < m; i++){
		    if(obstacleGrid[0][i] != 1)
		    	matrix[0][i] = 1;
//		    else 
//		    	matrix[0][i] = (i-1) >= 0 ? matrix[0][i-1] : 1;
    
		}
		
		for(int i = 1; i < n; i++){
			for(int j = 1; j < m; j++){
				if(obstacleGrid[i][j] != 1)
//					matrix[i][j] = 0;
//				else
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
			}			
		}
		
		printMatrix(matrix);
		
		return matrix[n-1][m-1];
	}	

	public static int minPathSum(int[][] grid) {
		
		if(grid == null || grid.length == 0)
			return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] matrix = new int[m][n];
		matrix[0][0] = grid[0][0];
		
		   // initialize top row
	    for(int i=1; i<n; i++){
	    	matrix[0][i] = matrix[0][i-1] + grid[0][i] ;
	    }
		
	    // initialize left column
	    for(int j=1; j<m; j++){
	    	matrix[j][0] = matrix[j-1][0] + grid[j][0] ;
	    }
		
	    // fill up the matrix table
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            if(matrix[i-1][j] > matrix[i][j-1]){
	            	matrix[i][j] = matrix[i][j-1] + grid[i][j];
	            }else{
	            	matrix[i][j] = matrix[i-1][j] + grid[i][j];
	            }
	        }
	    }
	 
	    printMatrix(matrix);
	    
	    return matrix[m-1][n-1];
	}
}
