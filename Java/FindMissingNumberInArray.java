package Algo.Test;

public class FindMissingNumberInArray {

	public static void main(String[] args) {
		// If Two missing number: https://www.careercup.com/question?id=18774665
		
		int arr[] = {1,2,4,5,6};
		System.out.println("Missing number by BinarySearchRecurssive is : " + getMissingNumberByBinarySearchRecurssive(arr,0,5));
		System.out.println("Missing number by BinarySearchIterative is : " + getMissingNumberByBinarySearchIterative(arr,0,5));
		System.out.println("Missing number by Normal is : " + getMissingNumber(arr,5));
		System.out.println("Missing number by XOR is : " + getMissingNumberXOR(arr,5));
	}

	private static int getMissingNumberByBinarySearchRecurssive(int[] arr, int left, int right) {

		if (left >= right - 1) { //Deal with the edge condition
			if ((left > 0) && (arr[left] > arr[left - 1] + 1))
				return (arr[left] - 1);
			else
				return (arr[left] + 1);
		}

		int mid = left + (right - left) / 2;
		
		if (mid - left < arr[mid] - arr[left])
			return getMissingNumberByBinarySearchRecurssive(arr, left, mid);
		else
			return getMissingNumberByBinarySearchRecurssive(arr, mid, right);
	}
	
	private static int getMissingNumberByBinarySearchIterative( int[] arr, int start , int end)
	{
		if (end < start)
			return -1; // not found means Ok
		else {
				int mid = (start + end)>> 1;

				if( mid - start ==1 && arr[mid] - arr[start] > 1)
					return arr[mid]-1;
				if ( end - mid == 1 && arr[end] - arr[mid] > 1)
					return arr[mid]+1;

				if( arr[mid] - arr[start] != mid - start ){
					return getMissingNumberByBinarySearchIterative (arr, start ,mid);
				}
				else if ( (arr[end] - arr[mid]) != (end - mid) ){
					return getMissingNumberByBinarySearchIterative (arr, mid ,end);
				}
			}
		
		return -1;
	}
	
	private static int getMissingNumber(int arr[], int n)
	{
	    int total;
	    total  = (n+1)*(n+2)/2; 
	    //System.out.println("total Out : " + total);
	    
	    for ( int i = 0; i< n; i++){
	    	//System.out.println("total before: " + total);
	    	//System.out.println("total i, arr[i]: " + i + ", " + arr[i]);
	    	total -= arr[i];
	    	//System.out.println("total after : " + total);	    	
	    }
	       
	    return total;
	}
	
	private static int getMissingNumberXOR(int arr[], int n)
	{
	    int i;
	    int x1 = arr[0]; /* For xor of all the elements in array */
	    int x2 = 1; /* For xor of all the elements from 1 to n+1 */
	    
	    for (i = 1; i< n; i++){
	        x1 = x1^arr[i];
	    }
	    
	    for ( i = 2; i <= n+1; i++){	
	        x2 = x2^i;  
	    }
	    
	    return (x1^x2);
	}	
}
