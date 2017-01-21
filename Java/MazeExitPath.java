package Algo.Test;

public class MazeExitPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MazeExitPath rat = new MazeExitPath();
//        int maze[][] = {
//        					{1, 0, 1, 1, 1},
//        					{1, 0, 1, 0, 1},
//        					{1, 1, 1, 0, 1},
//        					{1, 1, 0, 0, 1}
//                		};

        int maze[][] = {
				{1, 0, 0, 0, 0},
				{1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 0, 0, 1}
    		};
        if(rat.findExitPath(maze,4, 5)){
        	System.out.println("Exit path found in maze");
        }
        else
        	System.out.println("Exit path not found in maze");
	}

    
    
    /* A utility function to print solution matrix
       sol[N][M] */
    void printPath(int sol[][], int n, int m)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
                System.out.print(" " + sol[i][j] +
                                 " ");
            System.out.println();
        }
    }
 
    /* A utility function to check if x,y is valid
        index for N*M maze */
    boolean isValidIndex(int maze[][], int x, int y, int n, int m)
    {
        // if (x,y outside maze) return false
        return (x >= 0 && x < n && y >= 0 &&
                y < m && maze[x][y] == 1);
    }
 
    /* This function solves the Maze problem using
       Backtracking. It mainly uses solveMazeUtil()
       to solve the problem. It returns false if no
       path is possible, otherwise return true and
       prints the path in the form of 1s. Please note
       that there may be more than one solutions, this
       function prints one of the feasible solutions.*/
    boolean findExitPath(int maze[][], int n, int m)
    {
    	int sol[][] = new int [n][m];
    	
        if (exitPathUtil(maze, 0, 0, sol, n, m) == false)
        {
            return false;
        }
 
        printPath(sol, n, m);
        return true;
    }
 
    /* A recursive utility function to solve Maze
       problem */
    boolean exitPathUtil(int maze[][], int x, int y,
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
 
            
            //System.out.print(x + ", " + y + " = " + maze[x][y] + " | ");
            
            /* Move forward in x direction */
            if (exitPathUtil(maze, x + 1, y, sol, n, m))
                return true;
 
            /* If moving in x direction doesn't give
               solution then Move down in y direction */
            if (exitPathUtil(maze, x, y + 1, sol, n, m))
                return true;
            
            /* If none of the above movements work then
               BACKTRACK: unmark x,y as part of solution
               path */
            sol[x][y] = 0;
            return false;
        }
//        else if (isValidIndex(maze, x-1, y, n, m) == true){        
//        	
//        	System.out.print((x -1) + ", " + y + " = " + maze[x-1][y] + " | ");
//        	
//            if (solveMazeUtil(maze, x-1, y, sol, n, m))
//                return true;
//            
//            if (solveMazeUtil(maze, x-1, y-1, sol, n, m))
//                return true;            
//            
//            sol[x-1][y] = 0;
//            return false;
//        }
//        else if (isValidIndex(maze, x-1, y-1, n, m) == true){        
//        	
//        	System.out.print((x -1) + ", " + (y-1) + " = " + maze[x-1][y-1] + " | ");        	
//           
//            if (solveMazeUtil(maze, x-1, y-1, sol, n, m))
//                return true;            
//            
//            sol[x-1][y-1] = 0;
//            return false;
//        }
        
        return false;
    }
}