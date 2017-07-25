package Algo.Test;

public class MazeExitPath {

	boolean visited[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MazeExitPath pathFinder = new MazeExitPath();
        int maze[][] = {
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1}
                		};

        int maze2[][] = {
				{1, 0, 0, 0, 0},
				{1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 0, 0, 1}
    		};
        
        if(pathFinder.findExitPathShortest(maze,5, 6)){
        	System.out.println("Exit path found in maze (Shortest)");
        }
        else
        	System.out.println("Exit path not found in maze (Shortest)");    

        
        if(pathFinder.findExitPathForwardOnlyMove(maze2,4, 5)){
        	System.out.println("Exit path found in maze (ForwardOnlyMove)");
        }
        else
        	System.out.println("Exit path not found in maze (ForwardOnlyMove)");
        
        if(pathFinder.findExitPathLongest(maze,5, 6)){
        	System.out.println("Exit path found in maze (Longest). Not working need to fix.");
        }
        else
        	System.out.println("Exit path not found in maze (Longest). Not working need to fix.");          
	}

    
    
    /* A utility function to print solution matrix sol[N][M] */
    private void printPath(int sol[][], int n, int m)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
                System.out.print(" " + sol[i][j] +
                                 " ");
            System.out.println();
        }
    }
 
    
    /* A utility function to check if x,y is valid index for N*M maze */
    boolean isValidIndex(int maze[][], int x, int y, int n, int m)
    {
        if (x >= 0 && x < n && y >= 0 &&
                y < m && maze[x][y] == 1 && !visited[x][y]){
        	
        	visited[x][y] = true;
        	return true;
        }
        
        return false;
    }
 
    /* This function solves the Maze problem using
       Backtracking. It mainly uses exitPathShortestUtil()
       to solve the problem. It returns false if no
       path is possible, otherwise return true and
       prints the path in the form of 1s. Please note
       that there may be more than one solutions, this
       function prints one of the feasible solutions.*/    
    boolean findExitPathShortest(int maze[][], int n, int m)
    {
    	int sol[][] = new int [n][m];
    	visited = new boolean [n][m];
    	
        if (exitPathShortestUtil(maze, 0, 0, sol, n, m) == false)
        {
            return false;
        }
 
        printPath(sol, n, m);
        return true;
    }
 
    /* A recursive utility function to solve Maze problem */
    boolean exitPathShortestUtil(int maze[][], int x, int y,
                          int sol[][], int n, int m)
    {
        // if (x,y is goal) return true
        if (x == n - 1 && y == m - 1)
        {
            sol[x][y] = 1;
            return true;
        }
 
        // Check if maze[x][y] is valid
        if (isValidIndex(maze, x, y, n, m) == true)
        {
            // mark x,y as part of solution path
            sol[x][y] = 1;
 
            /* Move forward in x direction. Moving down */
            if (exitPathShortestUtil(maze, x + 1, y, sol, n, m))
                return true; 
            /* If moving in x direction doesn't give
               solution then in y direction. Move right */
            else if (exitPathShortestUtil(maze, x, y + 1, sol, n, m))
                return true;   
            /* Moving up in straight direction*/
            else if (exitPathShortestUtil(maze, x - 1, y , sol, n, m))
                return true; 
            /* Moving up and left direction*/
            else if (exitPathShortestUtil(maze, x, y - 1 , sol, n, m))
                return true;            
            
            /* If none of the above movements work then
               BACKTRACK: unmark x,y as part of solution path */            
            sol[x][y] = 0;
            return false;
        }        
        
        return false;
    }
    
    boolean isValidIndexForwardOnlyMove(int maze[][], int x, int y, int n, int m)
    {
        // if (x,y outside maze) return false
        return (x >= 0 && x < n && y >= 0 &&
                y < m && maze[x][y] == 1);

    }    
    
    boolean findExitPathForwardOnlyMove(int maze[][], int n, int m) {
    	int sol[][] = new int [n][m];
    	
        if (exitPathUtilForwardOnlyMove(maze, 0, 0, sol, n, m) == false)
        {
            return false;
        }
 
        printPath(sol, n, m);
        return true;
    }
    
    boolean exitPathUtilForwardOnlyMove(int maze[][], int x, int y, int sol[][], int n, int m) {
		// if (x,y is goal) return true
		if (x == n - 1 && y == m - 1)
		{
			sol[x][y] = 1;
			return true;
		}
		
		// Check if maze[x][y] is valid
		if (isValidIndexForwardOnlyMove(maze, x, y, n, m) == true) {
			// mark x,y as part of solution path
			sol[x][y] = 1;
			
			/* Move forward in x direction. Moving down */
			if (exitPathUtilForwardOnlyMove(maze, x + 1, y, sol, n, m))
			  return true;
			
			/* If moving in x direction doesn't give
			 solution then in y direction. Move right */
			else if (exitPathUtilForwardOnlyMove(maze, x, y + 1, sol, n, m))
			  return true;   
          
			
			/* If none of the above movements work then
			 BACKTRACK: unmark x,y as part of solution path */            
			sol[x][y] = 0;
			return false;
		}
		
		return false;
	}
    
    boolean findExitPathLongest(int maze[][], int n, int m)
    {
    	int sol[][] = new int [n][m];
    	visited = new boolean [n][m];
    	
        if (exitPathLongestUtil(maze, 0, 0, sol, n, m) == false)
        {
            return false;
        }
 
        printPath(sol, n, m);
        return true;
    }
 
    /* A recursive utility function to solve Maze problem */
    boolean exitPathLongestUtil(int maze[][], int x, int y,
                          int sol[][], int n, int m)
    {
        // if (x,y is goal) return true
        if (x == n - 1 && y == m - 1)
        {
            sol[x][y] = 1;
            return true;
        }
 
        // Check if maze[x][y] is valid
        if (isValidIndex(maze, x, y, n, m))
        {
            // mark x,y as part of solution path
            sol[x][y] = 1;
 
            /* Moving up and left direction*/
            if (exitPathLongestUtil(maze, x - 1, y , sol, n, m))
                return true; 
            /* Moving up in straight direction*/
            else if (exitPathLongestUtil(maze, x, y - 1 , sol, n, m))
                return true;   
            /* Move forward in x direction. Moving down */
            else if (exitPathLongestUtil(maze, x + 1, y, sol, n, m))
                return true; 
            /* If moving in x direction doesn't give solution then in y direction. Move right */
            else if (exitPathLongestUtil(maze, x, y + 1, sol, n, m))
                return true;            
            
            /* If none of the above movements work then
               BACKTRACK: unmark x,y as part of solution path */            
            sol[x][y] = 0;
            return false;
        }        
        
        return false;
    }    
}
