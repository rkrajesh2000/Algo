package Algo.Test;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid1 = new char[][]
				{
					{'1','1','1','1','0'},
					{'1','1','0','1','0'},
					{'1','1','0','0','0'},
					{'0','0','0','0','0'}
				};
		
		NumberOfIslands obj = new NumberOfIslands();
		System.out.println("Num of Islands grid#1 : " + obj.NumIslands(grid1));
		
		char[][] grid2 = new char[][]
				{
					{'1','1','0','0','0'},
					{'1','1','0','1','0'},
					{'0','0','1','0','0'},
					{'0','0','0','1','1'}
				};
		
		System.out.println("Num of Islands grid#1 : " + obj.NumIslands(grid2));		
	}

    public  int[] xDir = new int[] { 1, 0, -1,0};
    public  int[] yDir = new int[] { 0, -1, 0,1 };

    public int NumIslands(char[][] grid)
    {
        int count = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;


        if (grid == null || rowLength == 0 || colLength == 0)
        {
            return 0;
        }

        boolean[][] visited = new boolean[rowLength][colLength];

        for (int row = 0; row < rowLength; row++)
        {

            for (int col= 0; col < colLength; col++)
            {
                if (grid[row][col] == '0' || visited[row][col])
                    continue;
                explore(row, col, rowLength, colLength, grid, visited);

                count++;
            }
        }
        
        return count;
    }

    private void explore(int row, int col, int rowLength, int colLength, char[][] grid, boolean[][] visited)
    {
        if (!shouldExplore(row, col,rowLength,colLength, grid,visited))
            return;
        visited[row][col] = true;

        for(int i=0 ; i<4;i++)
        {
            explore(row + xDir[i], col + yDir[i], rowLength, colLength, grid,visited);
        }
        
      
    }

    private boolean shouldExplore(int row, int col, int rowLength, int colLength, char[][] grid, boolean[][] visited)
    {
        if(row >=0 && row < rowLength && col >=0 && col < colLength && grid[row][col] == '1'  && !visited[row][col])
        {
            return true;
        }

        return false;
    }
}
