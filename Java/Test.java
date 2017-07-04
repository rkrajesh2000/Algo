package Algo.Test;

class Test{  
	 
	public static void main(String args[]){  	

		 System.out.println("Factorial: " + factorial(5));
		 System.out.print("Fibonacci: ");	
		 fibonacci(5);
		 System.out.println();
		 System.out.println("myAtoi: " + myAtoi("89789"));
		 System.out.println("maxWaterContainerArea: " + maxWaterContainerArea(new int[] {1,3, 5,4,21}));
		 System.out.println("Terrain water flow leve: " + waterFlowLevel(new int[] {7, 4, 4, 4, 5}));	
		 assert waterFlowLevel(new int[]{7, 4, 4, 4, 5}) == 3;
		 
		//int[] nums = new int[]{-50,-50,-49,-48,-47,-47,-47,-46,-45,-43,-42,-41,-40,-40,-40,-40,-40,-40,-39,-38,-38,-38,-38,-37,-36,-35,-34,-34,-34,-33,-32,-31,-30,-28,-27,-26,-26,-26,-25,-25,-24,-24,-24,-22,-22,-21,-21,-21,-21,-21,-20,-19,-18,-18,-18,-17,-17,-17,-17,-17,-16,-16,-15,-14,-14,-14,-13,-13,-12,-12,-10,-10,-9,-8,-8,-7,-7,-6,-5,-4,-4,-4,-3,-1,1,2,2,3,4,5,6,6,7,8,8,9,9,10,10,10,11,11,12,12,13,13,13,14,14,14,15,16,17,17,18,20,21,22,22,22,23,23,25,26,28,29,29,29,30,31,31,32,33,34,34,34,36,36,37,37,38,38,38,39,40,40,40,41,42,42,43,43,44,44,45,45,45,46,47,47,47,47,48,49,49,49,50};
		int[] nums = new int[]{-3,-1,-1,0,0,0,0,0,2};
		
		System.out.print("removeDuplicates() : ");
		int len = removeDuplicates(nums);
		for(int i=0; i< len; i++){
			System.out.print(nums[i] + ",");
		}		 
		
		System.out.println();
		System.out.println("divide(-2147483648 / 2 ) : " + divide(-2147483648, 2));
		System.out.println("trapRainWaterWithBuffur() : " + trapRainWaterWithBuffur(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println("trapRainWaterWithNoBuffur() : " + trapRainWaterWithNoBuffur(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println("trapRainWaterWithBuffurFor2D() : " + trapRainWaterWithBuffurFor2D(new int[][] {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}}));
		System.out.println("totalCandy() : " + totalCandy(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println("HouseRobber() : " + HouseRobber(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));	
		System.out.println("canJumpAndReachEnd() : " + canJumpAndReachEnd(new int[] {2,0,0}));	
		System.out.println("canJumpAndReachEnd2() : " + canJumpAndReachEnd2(new int[] {2,0,0}));	
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
	     * n vertical lines are drawn such that the two end points of line i is at (i, ai) and (i, 0). 
	     * Find two lines, which together with x-axis forms a container, such that the container contains 
	     * the most water.
	     */
	    private static int maxWaterContainerArea(int[] height) {
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
	    public static int waterFlowLevel(int[] terrain) {
	        
	        if(terrain == null || terrain.length == 0)
	          return 0;
	        
	        // assume terrain[0] and terrain[terrain.length - 1] are the high points
	        
	        int spillHeight = Math.min(terrain[0], terrain[terrain.length - 1]);
	        int volume = 0;
	        
	        for (int i = 1; i < terrain.length - 1; i++) {
	          // we already know that terrain[i] < spill_height
	           volume = volume + (spillHeight - terrain[i]);
	        }
	        
	        return (volume < 0 ? 0 : volume);
	  }
	  
	  /*
		Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
		Do not allocate extra space for another array, you must do this in place with constant memory.
		For example, Given input array nums = [1,1,2],
	  */
	  private static int removeDuplicates(int[] nums) {
	    	
	        if(nums == null || nums.length == 0)
	            return 0;
	        
	        if(nums.length == 1)
	            return 1;
	        
	        int newLen = 1;
	        int tail = 1;
	        int pre = nums[0];
	        
	        for(int i=1; i < nums.length; i++){

	        	if (pre == nums[i])
	            	continue;
	        	        	
	            nums[tail] = nums[i];
	            ++tail;
	            ++newLen;
	            pre = nums[i];
	        }
	        
	        return newLen;
	    }	
	  
	    /*
	     * Divide two number without using  operation / or *
	     */
	    public static int divide(int dividend, int divisor) {
	        
	        int ans = 0;
	        
	        if(divisor==0) 
	        	return Integer.MAX_VALUE;
	        
	        if(divisor == -1 && dividend == Integer.MIN_VALUE)
	            return Integer.MAX_VALUE;
	    
	        if(divisor == 1 && dividend == Integer.MIN_VALUE)
	            return Integer.MIN_VALUE;
	            
	        long dividendRunner =  Math.abs((long) dividend);
	        long divisorRunner =  Math.abs((long) divisor); 
	        
	        while(dividendRunner >= divisorRunner ){
	            int n = 0;
	            while(dividendRunner >= (divisorRunner << n)){
	                n++;
	            }
	            ans = ans + (1 << (n-1));
	            dividendRunner = dividendRunner - (divisorRunner << (n-1));
	        }
	        
	        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
	            return ans;
	        }else{
	            return -ans;
	        }
	    }
	    
	    /* 42.
	     * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	     * compute how much water it is able to trap after raining.
		 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	     */
	    public static int trapRainWaterWithBuffur(int[] height) {
	        int volume = 0;
	     
	        if(height==null || height.length<=2)
	            return volume;
	     
	        int left[] = new int[height.length];
	        int right[]= new int[height.length];
	     
	        //scan from left to right
	        int max = 0;
	        left[0] = 0;
	        for(int i=0; i<height.length; i++){
	            if(height[i]<max){
	                left[i]=max;
	            }else{
	                left[i]=height[i];
	                max = height[i];
	            }
	        }
	     
	        //scan from right to left
	        max = 0;
	        right[height.length-1]=0;
	        
	        for(int i=height.length-1; i>=0; i--){
	            if(height[i]<max){
	                right[i]=max;
	            }else{
	                right[i]=height[i];
	                max = height[i];
	            }
	        }
	     
	        //calculate total
	        for(int i=0; i<height.length; i++){
	            volume+= Math.min(left[i],right[i])-height[i];
	        }
	     
	        return volume;
	    }
	    
	    /* 42.
	     * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	     * compute how much water it is able to trap after raining.
		 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	     */
	    public static int trapRainWaterWithNoBuffur(int[] height) {
	    	
	        int volume = 0;
	        
	        if(height == null || height.length <= 2)
	            return volume;
	        
	    	int left = 0;
	    	int right = height.length -1;
	    	int max = 0;
	    	
	    	
	    	while(left <= right){
	    		
	    		if(height[left] <= height[right]){
	    			if(height[left] >= max)
	    				max = height[left];
	    			else
	    				volume = volume + (max - height[left]);
	    			
	    			++left;
	    		}
	    		else{
	    			if(height[right] >= max)
	    				max = height[right];
	    			else
	    				volume = volume + (max - height[right]); 
	    			
	    			--right;
	    		}
	    	}
	    	
	    	return volume;
	    }
	    
	    public static int trapRainWaterWithBuffurFor2D(int[][] heightMap) {
	        int volume = 0;
	     
	        if(heightMap==null || heightMap.length<=2 || heightMap[0].length<=2)
	            return volume;
	     
	        int left[][] = new int[heightMap.length][heightMap[0].length];
	        int right[][]= new int[heightMap.length][heightMap[0].length];
	        int top[][] = new int[heightMap.length][heightMap[0].length];
	        int bottom[][]= new int[heightMap.length][heightMap[0].length];
	        
	        //scan from left to right
	        int max = 0;
	        //left[0][0] = 0;
	        
	        for(int i=0; i<heightMap.length; i++){
	        	max = heightMap[i][0];
	        	for(int j=0; j<heightMap[0].length; j++){
		            if(heightMap[i][j]<max){
		                left[i][j]=max;
		            }else{
		                left[i][j]=heightMap[i][j];
		                max = heightMap[i][j];
		            }
	        	}
	        }
	     
	        //scan from right to left
	        max = 0;
	        right[heightMap.length-1][heightMap[0].length-1]=0;
	        
	        for(int i=heightMap.length-1; i>=0; i--){
	        	max = heightMap[i][heightMap[0].length-1];
	        	for(int j=heightMap[0].length-1; j>=0; j--){
		            if(heightMap[i][j]<max){
		                right[i][j]=max;
		            }else{
		                right[i][j]=heightMap[i][j];
		                max = heightMap[i][j];
		            }
	        	}
	        }

	        //scan from left to top
	        max = 0;
	        
	        for(int i=0; i<heightMap[0].length; i++){
	        	max = heightMap[0][i];
	        	for(int j=0; j<heightMap.length; j++){
		            if(heightMap[j][i]<max){
		            	top[j][i]=max;
		            }else{
		            	top[j][i]=heightMap[j][i];
		                max = heightMap[j][i];
		            }
	        	}
	        }

	        //scan from left to bottom
	        max = 0;
	        //bottom[heightMap.length-1][heightMap[0].length-1]=0;
	        
	        for(int j=heightMap[0].length-1; j>=0; j--){
	        	max = heightMap[heightMap.length-1][heightMap[0].length-1];
	        	for(int i=heightMap.length-1; i>=0; i--){
		            if(heightMap[i][j]<max){
		            	bottom[i][j]=max;
		            }else{
		            	bottom[i][j]=heightMap[i][j];
		                max = heightMap[i][j];
		            }
	        	}
	        }
	        
	        System.out.println("heightMap: ");
	        displayArray(heightMap);
	        System.out.println();
	        System.out.println("left: ");
	        displayArray(left);
	        System.out.println();
	        System.out.println("right: ");
	        displayArray(right);
	        System.out.println();
	        System.out.println("top: ");
	        displayArray(top);
	        System.out.println();
	        System.out.println("bottom: ");
	        displayArray(bottom);
	        System.out.println();
	        
	        int min = 0;
	        //calculate total
//	        for(int i=1; i<heightMap.length-1; i++){	
//	        	
//	        	for(int j=1; j<heightMap[0].length-1; j++){
//	        		min = Integer.MAX_VALUE;
//	        		System.out.println(min);
//	        		min = Math.min(min, Math.min(left[i][j],right[i][j]));
//	        		System.out.println(min);
//	        		min = Math.min(min, Math.min(top[i][j],bottom[i][j]));
//	        		volume+= min-heightMap[i][j];
//	        		System.out.println(min + ", " + heightMap[i][j] + ", " + volume);
//	        	}
//	        }    
	        
	        int tracker[][]= new int[heightMap.length][heightMap[0].length];
	        
	        for(int i=1; i<heightMap.length-1; i++){	
	        	
	        	for(int j=1; j<heightMap[0].length-1; j++){
	        		min = Integer.MAX_VALUE;
	        		int preVal = 0;
	        		int minI = -1;
	        		int minJ = -1;
	        		
	        		if(heightMap[i-1][j] < min){
	        			min = heightMap[i-1][j];
	        			minI = i-1;
	        			minJ = j;
	        		}
	        		
	        		if(heightMap[i+1][j] < min){
	        			min = heightMap[i+1][j];
	        			minI = i+1;
	        			minJ = j;	        			
	        		}
	        		
	        		if(heightMap[i][j-1] < min){
	        			min = heightMap[i][j-1];
	        			minI = i;
	        			minJ = j-1;	        			
	        		}
	        		
	        		if(heightMap[i][j+1] < min){
	        			min = heightMap[i][j+1];
	        			minI = i;
	        			minJ = j+1;
	        		}
	        		
	        		if(heightMap[i][j] < min){
	        			tracker[i][j] = min-heightMap[i][j];
	        			volume+= (min-heightMap[i][j]);
	        			
	        			if(minI != -1 && minJ != -1) {
	        				tracker[i][j] = tracker[i][j] + tracker[minI][minJ];
	        				volume+= tracker[minI][minJ];
	        			}
	        		}
	        			
	        		//min = Math.min(min, Math.min(left[i][j],right[i][j]));
	        		//min = Math.min(min, Math.min(top[i][j],bottom[i][j]));
	        		
	        		//volume+= min-heightMap[i][j];
	        		System.out.println(min + ", " + heightMap[i][j] + ", " + volume);
	        	}
	        } 
	        return volume;
	    }	    

		private static void displayArray(int[][] inputList){
	        for (int[] list : inputList) {
	        	System.out.print("[");
	        	
	        	int counter = 0;
	        	for(int val : list ){
	        		System.out.print(val);
	        		
	        		++counter;
	        		if(counter < list.length)
	        			System.out.print(",");
	        	}
	        	
	        	System.out.print("]");
	        	System.out.println();
	        } 
		}
		
	    /*
	     *  There are N children standing in a line. Each child is assigned a rating value. You are giving candies to these children subjected to the following requirements:
		 *	1. Each child must have at least one candy.
		 *	2. Children with a higher rating get more candies than their neighbors.
		 *	What is the minimum candies you must give? Solve with O(n) 
	     */
	    public static int totalCandy(int[] ratings) {
	    	if (ratings == null || ratings.length == 0) {
	    		return 0;
	    	}
	     
	    	int[] candies = new int[ratings.length];
	    	candies[0] = 1;
	     
	    	//from let to right
	    	for (int i = 1; i < ratings.length; i++) {
	    		if (ratings[i] > ratings[i - 1]) {
	    			candies[i] = candies[i - 1] + 1;
	    		} else { 
	    			// if not ascending, assign 1
	    			candies[i] = 1;
	    		}
	    	}
	     
	    	int result = candies[ratings.length - 1];
	     
	    	//from right to left
	    	for (int i = ratings.length - 2; i >= 0; i--) {
	    		int cur = 1;
	    		if (ratings[i] > ratings[i + 1]) {
	    			cur = candies[i + 1] + 1;
	    		}
	     
	    		result += Math.max(cur, candies[i]);
	    		candies[i] = cur;
	    	}
	     
	    	return result;
	    }
	    
	    /*
	     * 
	     */
	    private static int HouseRobber(int[] nums){
	    	
	    	if(nums == null || nums.length == 0)
	    		return 0;
	    	
	    	int even = 0;
	    	int odd = 0;
	    	
	    	for(int i=0; i < nums.length; i++){
	    		if(i%2 == 0){
	    			even += nums[i];
	    			even = even > odd ? even : odd;
	    		}
	    		else{
	    			odd += nums[i];
	    			odd = even > odd? even : odd;
	    		}
	    	}
	    	
	    	return (even > odd? even : odd);
	    }
	    
		 private static boolean canJumpAndReachEnd(int[] nums){
				
			 if(nums == null || nums.length <= 1)
				 	return true;
			 
			 int max = nums[0];
			 
			 for(int i=0; i <nums.length; i++){
				 
				 if(max <= i && nums[i] == 0)
					 return false;
				 
				 if( nums[i]+i > max)
					 max = nums[i] + i;
				 
				 if(max >= nums.length - 1)
					 return true;
			 }
			 
			 return false;
		 }
		 
		 private static boolean canJumpAndReachEnd2(int[] nums){
				
			 if(nums == null || nums.length <= 1)
				 	return true;
			 
			 int max = nums[0];
			 
			 for(int i=1; i <nums.length; i++){
				 
				 if(max < i)
					 return false;
				 
				 max = Math.max(max, nums[i]+i );
				 
				 if(max >= nums.length - 1)
					 return true;
			 }
			 
			 return false;
		 }			 
}
