package Algo.Test;

public class ArrayProduct {

	/*
	 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal 
	 to the product of all the elements of nums except nums[i].
	 Solve it without division and in O(n).
	 For example, given [1,2,3,4], return [24,12,8,6]
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4};
		
		System.out.print("Input Array is : ");
		for(int n : nums)
			System.out.print(n + ", ");
		
		System.out.println();
		System.out.print(" and output product is by productExceptSelf() : ");		
		
		for(int n : productExceptSelf(nums))
			System.out.print(n + ", ");
		
		System.out.println();
		System.out.print(" and output product is by productExceptSelf2() : ");
		
		for(int n : productExceptSelf2(nums))
			System.out.print(n + ", ");		
		
		int[][] matrix = new int[][] {
		        		  {3, 0, 1, 4, 2},
		        		  {5, 6, 3, 2, 1},
		        		  {1, 2, 0, 1, 5},
		        		  {4, 1, 0, 1, 7},
		        		  {1, 0, 3, 0, 5}
						};
		
		System.out.println();
		System.out.print("Sum between for points in matrix is by sumBeweenMatrixPoints() : " + sumBeweenMatrixPointsIn2D(matrix, 1, 2, 2, 4));	
		
		int[] arr = new int[]{-2, 0, 3, -5, 2, -1};		
		sumBetweenIndexs(arr, 0, 2);		
	}
	
    public static int[] productExceptSelf(int[] nums) {
        
        if(nums == null || nums.length < 2)
            return nums;
        
        int[] result = new int[nums.length];
        int[] nums1 = new int[nums.length];
        int[] nums2 = new int[nums.length];
        
        nums1[0] = 1;
        nums2[nums.length - 1] = 1;
        
        for(int i=0; i < nums.length - 1; i++){
            nums1[i+1] = nums1[i] * nums[i];
        }
        
        for(int i = nums.length - 1; i > 0; i--){
            nums2[i-1] = nums2[i] * nums[i];
        }  

        for(int i=0; i < nums.length; i++){
            result[i] = nums1[i] * nums2[i];
        }        
        
        return result;
    }
    
    public static int[] productExceptSelf2(int[] nums) {
        
        int prod =nums[0];        
        int count = nums[0]==0 ?1:0;
        
        for(int i = 1; i < nums.length;i++)
        {
        	//System.out.println(i + " Before " + count + ", " + prod);
        	
           if(nums[i] == 0)
             count++;
           
           if(count>1)
           {
               prod=0;
               break;
           }
         
           prod = nums[i] ==0 ? prod : prod * nums[i]; 
           //System.out.println(i + " After " + count + ", " + prod + "," + nums[i]);
        }
        
        
        for(int i = 0; i < nums.length;i++)
        {
           //System.out.println(i + " Before2 " + count + ", " + prod);
           if(count==1)
           {
               if(nums[i]==0)
                 nums[i] = prod;
               else
                 nums[i] = 0;
           }
           else if(count==0)
           {
               nums[i] = prod/nums[i];
           }
           else
           {
               nums[i] =0;
           }
           //System.out.println(i + " After2 " + count + ", " + prod + "," + nums[i]);
        }
        
        return nums;        
    }   
    
    /*
     * 304 
     * Range Sum Query 2D - Immutable
     * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) 
     * and lower right corner (row2, col2).
     * Given matrix = [
		  [3, 0, 1, 4, 2],
		  [5, 6, 3, 2, 1],
		  [1, 2, 0, 1, 5],
		  [4, 1, 0, 1, 7],
		  [1, 0, 3, 0, 5]
		]
		
		sumBeweenMatrixPoints(2, 1, 4, 3) -> 8
		sumBeweenMatrixPoints(1, 1, 2, 2) -> 11
		sumBeweenMatrixPoints(1, 2, 2, 4) -> 12
     */
    private static int sumBeweenMatrixPointsIn2D(int[][] matrix, int row1, int col1, int row2, int col2){
    	
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return 0;
    	
    	int[][] preCompute = new int[matrix.length + 1][matrix[0].length + 1];
    	
    	for(int i = 1 ; i <= matrix.length; i++ ){
    		for(int j = 1 ; j <= matrix[0].length; j++ ){
    			preCompute[i][j] = preCompute[i-1][j] + preCompute[i][j-1] - preCompute[i-1][j-1] + matrix[i-1][j-1];
    		}
    	}
    	
    	int minRow = Math.min(row1, row2);
    	int maxRow = Math.max(row1, row2);
    	int minCol = Math.min(col1, col2);
    	int maxCol = Math.max(col1, col2);
    	
    	
    	return  preCompute[minRow][minCol] + preCompute[maxRow+1][maxCol+1] - preCompute[maxRow+1][minCol] - preCompute[minRow][maxCol+1] ;
    }
    
    /* 303
     * Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive
     * Given nums = [-2, 0, 3, -5, 2, -1]
		sumRange(0, 2) -> 1
		sumRange(2, 5) -> -1
		sumRange(0, 5) -> -3
     */
	private static void sumBetweenIndexs(int[] arr, int start, int end){
		
		int[] aux = new int[arr.length];
		aux[0] = arr[0];
		
		for(int i=1; i<arr.length; i++){
			aux[i] = aux[i-1] + arr[i];
		}
		
		if(start > 0)
			System.out.print("Sum of values between indexes (" + start + ", " + end + ") : " + (aux[end] - aux[start-1]));
		else
			System.out.print("Sum of values between indexes (" + start + ", " + end + ") : " + (aux[end]));
	}    
}
