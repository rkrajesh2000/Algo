package Algo.Test;

public class MedianOfSortedArrays {

	public static void main(String[] args) {

      int[] nums1 = new int[] {1, 2, 5, 8};
      int[] nums2 = new int[] { 3, 4, 7,10 };
      System.out.println(String.valueOf("Find Median of two Sorted Arrays by Array Merge : " + String.valueOf(findMedianSortedArrays(nums1,nums2))));
      System.out.println(String.valueOf("Find Median  of two Sorted Arrays by Finding Kth Element : " + String.valueOf(findMedianSortedArraysWtihKthEleSearch(nums1,nums2))));

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	    	if(nums1 == null || nums2 == null)
	    		return 0;
	    	
	    	int n = nums1.length;
	    	int m = nums2.length;
	    	int k = n + m;
	    	int[] nums3 = new int[k];    	
	        double medianOfBoth;

	        for (int i = 0; i < n; i++)
	            nums3[i] = nums1[i];
	        
	        nums1 = null;
	        
	        // Apply Merge Short        
	        int l = m + n - 1; // Index of last location of array a
	        int i = n - 1; // Index of last element in array a
	        int j = m - 1; // Index of last element in array b

	        // Start comparing from the last element and merge a and b
	        while (i >= 0 && j >= 0)
	        {
	            if (nums3[i] > nums2[j])
	            {
	                nums3[l--] = nums3[i--];
	            }
	            else
	            {
	                nums3[l--] = nums2[j--];
	            }
	        }

	        while (j >= 0)
	        {
	            nums3[l--] = nums2[j--];
	        }
	        
	        //Calculate median
	        int center = k / 2;

	        if ((k % 2) > 0)
	            medianOfBoth = (double)nums3[center];
	        else
	            medianOfBoth = ((double)nums3[center - 1] + (double)nums3[center]) / 2;    	
	        
	        return medianOfBoth;
	    }    
	    
	    public static double findMedianSortedArraysWtihKthEleSearch(int[] nums1, int[] nums2) {
	        
	        int total = nums1.length+nums2.length;
	        if(total%2==0){
	            return (findKthElementInTwoShortedArray((total/2)+1, nums1, nums2, 0, 0) + findKthElementInTwoShortedArray(total/2, nums1, nums2, 0, 0))/2.0;
	        }else{
	            return findKthElementInTwoShortedArray((total/2)+1, nums1, nums2, 0, 0);
	        }
	    }
	    
	    public static int findKthElementInTwoShortedArray(int k, int[] nums1, int[] nums2, int n1, int n2){
	        if(n1>=nums1.length)
	            return nums2[n2+k-1];
	     
	        if(n2>=nums2.length)
	            return nums1[n1+k-1];
	     
	        if(k==1)
	            return Math.min(nums1[n1], nums2[n2]);
	     
	        int m1 = (n1+k/2)-1;
	        int m2 = (n2+k/2)-1;
	     
	        int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
	        int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
	     
	        if(mid1<mid2){
	            return findKthElementInTwoShortedArray(k-k/2, nums1, nums2, m1+1, n2);
	        }else{
	            return findKthElementInTwoShortedArray(k-k/2, nums1, nums2, n1, m2+1);
	        }
	    }
}
