package Algo.Test;

class Test extends Thread{  
	int c = 0 ; 
	static int maxVal = 0;
	 public void run(){  
		 
		 for(int i=0 ; i<100 ; i++)
		      c++;  
		 
		 if (maxVal < c)
			 maxVal = c;
	 }  
	 
	public static void main(String args[]){  
		 Test t1=new Test();  
		 Test t2=new Test();  
		 Test t3=new Test();  
		 t1.start();  
		 try{  
		  t1.join();  
		 }catch(Exception e){System.out.println(e);}  
		  
		 t2.start();  
		 t3.start(); 
		 
		 System.out.println(maxVal);
		 System.out.println("Factorial: " + factorial(5));
		 System.out.println("Fibonacci: ");	
		 fibonacci(5);
		 System.out.println();
		 System.out.println("myAtoi: " + myAtoi("89789"));
		 System.out.println("maxArea: " + maxArea(new int[] {1,3, 5,4,21}));
		 System.out.println("Terrain water flow leve: " + capacity(new int[] {7, 4, 4, 4, 5}));	
		 assert capacity(new int[]{7, 4, 4, 4, 5}) == 3;
		 System.out.println("Terrain water flow leve: " + capacity(new int[] {3, 4, 5, 4, 3}));
		 assert capacity(new int[]{3, 4, 5, 4, 3}) == 0;
		 System.out.println("Terrain water flow leve: " + capacity(new int[] {7, 4, 4, 4, 5, 4, 7}));
		 assert capacity(new int[]{7, 4, 4, 4, 5, 4, 7}) == 14;
	 }
	
	public static int factorial(int n)
	{
		if(n==0)
			return 1;
		
		return n * factorial(n-1);
	}
	
	 static int n1=0,n2=1,n3=0;    
	 public static void fibonacci(int count){    
	    if(count>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         fibonacci(count-1);    
	     }    
	 }
	 
	    public static int myAtoi(String str) {
	        
	        int result = 0;
	        int isNeg = 1;
	        if(str == null || str == "")
	            return result;
	            
	        for(int i=0; i < str.length(); i++) {
	            char c = str.charAt(i);
                if(c == '+' || c == '-' || c == '/' || c == '*')
		        	 if(result == 0){
		        		 isNeg = c == '-' ? -1 : 1;
	        	        continue;
		        	 }
	        	    else
	        	        break;
	        	else
	        		result = (result * 10) + (str.charAt(i) - '0');	        		            
	        }
	        
	        return result * isNeg;
	    }
	    
	    /*
	     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
	     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	     * Find two lines, which together with x-axis forms a container, such that the container contains 
	     * the most water.
	     */
	    private static int maxArea(int[] height) {
	    	if (height == null || height.length < 2) {
	    		return 0;
	    	}
	     
	    	int max = 0;
	    	int left = 0;
	    	int right = height.length - 1;
	     
	    	while (left < right) {
	    		max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
	    		if (height[left] < height[right])
	    			left++;
	    		else
	    			right--;
	    	}
	     
	    	return max;       
	    }
	    
	    /**
	     * Given a terrain, we would like to know the amount of water that can be held in
	     * this terrain during a flood.
	     *
	     * To simplify the problem, consider a 2D terrain, which we estimate using a sequence
	     * of discrete columns (or bars), from left to right. There are no spaces (or gaps)
	     * between these. Each column has an integer height  0.
	     *
	     * The input is a list (or array) of heights from left to right.
	     *
	     * e.g. plateau: [5, 5, 5, 5, 5] ~> 0
	     * e.g. plateau: [5, 5, 5, 5, 4] ~> 0
	     * e.g. valley: [7, 4, 4, 4, 5] ~> 3
	     * e.g. valley: [7, 4, 4, 4, 5, 6] ~> 7
	     * e.g. valley: [7, 4, 4, 4, 5, 4, 7] ~> 14
	     * e.g. valley: [5, 3, 3, 3, 5] ~> 6
	     * e.g. hill: [3, 4, 5, 4, 3] ~> 0
	     * e.g. double valley: [5, 4, 4, 5, 3, 3, 5] ~> 6
	     * e.g. slope: [3, 4, 5, 6, 7, 8] ~> 0
	     * e.g. slope: [8, 7, 6, 5, 4, 3] ~> 0
	     * e.g. other: [1, 2, 3, 4, 5, 6, 8, 12, 9, 8, 10] ~> 3
	     * e.g. valley: [7, 4, 5, 4, 5] ~> 2
	     * e.g. nested valley: [7, 2, 2, 5, 3, 3, 8] ~> 20
	     */
	    public static int capacity(int[] terrain) {
	        
	        if(terrain == null || terrain.length == 0)
	          return 0;
	        
	        // assume terrain[0] and terrain[terrain.length - 1] are the high points
	        
	        int spill_height = Math.min(terrain[0], terrain[terrain.length - 1]);
	        int volume = 0;
	        
	        for (int i = 1; i < terrain.length - 1; i++) {
	          // we already know that terrain[i] < spill_height
	           volume = volume + (spill_height - terrain[i]);
	        }
	        
	        return (volume < 0 ? 0 : volume);
	        //return (volume);
	        
	        /*
	        int left = 0;
	        int right = terrain.length -1;
	        int max = 0;
	        
	        while(left < right)
	        {
	            max = Math.max(max, (right - left) * Math.min(terrain[left], terrain[right]));
	            
	            if(terrain[left] < terrain[right]){
	                left++;
	            }
	            else{
	              right--;
	            }
	          
	        }
	        
	        return max;
	        */
	  }	    
}
