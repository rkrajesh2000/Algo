package Algo.Test;
import java.util.HashMap;
import java.lang.Math;

public class Convertor {

	public static void main(String[] args) {
		System.out.println(
				numberToLetters(1)
				+ ", " + numberToLetters(25)
				+ ", " + numberToLetters(27)
                + ", " + numberToLetters(51)
                + ", " + numberToLetters(52)
                + ", " + numberToLetters(53)
                + ", " + numberToLetters(77)
                + ", " + numberToLetters(78)
                + ", " + numberToLetters(79)
                + ", " + numberToLetters(702)
                + ", " + numberToLetters(703)
                );
		
		System.out.println(numberToLetters(704)
                + ", " + numberToLetters(705)
                + ", " + numberToLetters(2600)
                + ", " + numberToLetters(25999)
                + ", " + numberToLetters(26000)
                + ", " + numberToLetters(26001)
				);
		
		System.out.println(lettersToNumber("ALLA"));
		
		int[] number = new int[] {-1,-2,-3,-4,-5};
		int[] out = indexOfPairAddUpToNumber(number,-8);
		System.out.println("[" + String.valueOf(out[0]) + "," + String.valueOf(out[1]) + "]");
		System.out.println(String.valueOf(reverseInteger(-1234)));
		System.out.println(String.valueOf(reverseInteger(1534236469)));
		System.out.println(String.valueOf(lengthOfLongestSubstring("abb")));
		
        int[] nums1 = new int[] {1, 2, 5, 8};
        int[] nums2 = new int[] { 3, 4, 7,10 };
		System.out.println(String.valueOf(String.valueOf(findMedianSortedArrays(nums1,nums2))));
		System.out.println(String.valueOf(String.valueOf(findMedianSortedArraysWtihKthEleSearch(nums1,nums2))));
		
	}
	
	public static String numberToLetters(int number){
		
		if(number <= 0)
			return "Not Applicable";
		
		char[] charArr = new char[]{ 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		
		if(number > 0 && number < 27)
			return String.valueOf(number) + " = " + String.valueOf(charArr[number]);
		
		StringBuffer sb = new StringBuffer();
		int runnerNum = number;
		String remainderLetter = "";
		
		while(runnerNum > 26){			
		
			int quotient = runnerNum / 26;
			
			if( (runnerNum % 26) == 0)
				--quotient;
			
			if(quotient > 0 && quotient < 27) {
				
				if( (runnerNum % 26) == 0)
					sb.append(String.valueOf(charArr[quotient]) + String.valueOf(charArr[0]) );
				else
					sb.append(String.valueOf(charArr[quotient]));
				
			}
			
			if(quotient > 26){
				
				int remainder = (runnerNum % 26);
				remainderLetter = String.valueOf(charArr[remainder]) + remainderLetter;
				runnerNum = quotient;
			}
			else{
				int remainder = (runnerNum % 26);
				
				if( remainder > 0)
					sb.append(String.valueOf(charArr[remainder]));
				
				runnerNum = quotient;
			}
				
		}
		
		return String.valueOf(number) + " = " + sb.toString() + remainderLetter;
	}
	
	public static int lettersToNumber(String letters){
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		map.put('F', 6);
		map.put('G', 7);
		map.put('H', 8);
		map.put('I', 9);
		map.put('J', 10);
		map.put('K', 11);
		map.put('L', 12);
		map.put('M', 13);
		map.put('N', 14);
		map.put('O', 15);
		map.put('P', 16);
		map.put('Q', 17);
		map.put('R', 18);
		map.put('S', 19);
		map.put('T', 20);
		map.put('U', 21);
		map.put('V', 22);
		map.put('W', 23);
		map.put('X', 24);
		map.put('Y', 25);
		map.put('Z', 26);
		
		if(letters == null || letters == "")
			return 0;
		
		int len = letters.length();
		int number = 0;
		
		for(int i=0; i < len; i++){
			
			char c = letters.charAt(i);
			
			number = number + (map.get(c) * (int)Math.pow((double)26, (double)(len-1-i)));
		}
		
		return number;
	}
	
	public static int[] indexOfPairAddUpToNumber(int[] nums, int target){
		
		if(nums == null || nums.length < 2)
			return new int[]{-1,-1};;
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
				
		for(int i = 0; i < nums.length; i++){
			
			if(map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i]) + "," + String.valueOf(i)) ;
			else
				map.put(nums[i], String.valueOf(i));
		}
		
		for(int i = 0; i < nums.length; i++){
			
			int val = target - nums[i];
			
			if(val == nums[i] && map.containsKey(val))
			{
				String[] iStr = map.get(nums[i]).split(",");
				
				if(iStr.length > 1){				
					for(int j = 0; j < iStr.length; j++){
						for(int k=(j+1); k < iStr.length; k++){
							if ((nums[Integer.parseInt(iStr[j])] + nums[Integer.parseInt(iStr[k])]) == target){
								return new int[]{Integer.parseInt(iStr[j]),Integer.parseInt(iStr[k])};
							}
						}
					}
				}
				
				if(map.containsKey(val))
					map.remove(val);
				
			}
			else if( val != nums[i] && map.containsKey(val))
			{
				String[] iStr = map.get(nums[i]).split(",");
				String[] iStrVal = map.get(val).split(",");
				
			
				for(int j = 0; j < iStr.length; j++){
					for(int k = 0; k < iStrVal.length; k++){
						if ((nums[Integer.parseInt(iStr[j])] + nums[Integer.parseInt(iStrVal[k])]) == target){
							return new int[]{Integer.parseInt(iStr[j]),Integer.parseInt(iStrVal[k])};
						}
					}
				}
				
				if(map.containsKey(val))
					map.remove(val);
			}
		}
		
		return new int[]{-1,-1};
	}
	
	//Test Case: 1534236469, 1234, -1234
    public static int reverseInteger(int x) {
        try {

        	int number = Math.abs(x);
            int result = 0;
            
            while (number > 0) {
               
            	//Check if integer over flow may occur
            	long checker = ((long)result * 10) + ((long)number % 10);            	
            	if( checker > Integer.MAX_VALUE)
            		return 0;
            	
            	result = (result * 10) + (number % 10);                
                number = number / 10;
            }
            
            if(x < 0)
                result = result * -1;
            
            return result;

        }
        catch (StackOverflowError ex)
        { return 0; }
    }
    
    //Test Case: "aab", "bbbbb", "dvdf"
    public static int lengthOfLongestSubstring(String s)
    {
        if(s==null)
            return 0;
		boolean[] flag = new boolean[256];
	 
		int result = 0;
		int start = 0;
		char[] arr = s.toCharArray();
	 
		for (int i = 0; i < arr.length; i++) {
			char current = arr[i];
			if (flag[current]) {
				result = Math.max(result, i - start);
				// the loop update the new start point
				// and reset flag array
				// for example, abccab, when it comes to 2nd c,
				// it update start from 0 to 3, reset flag for a,b
				for (int k = start; k < i; k++) {
					if (arr[k] == current) {
						start = k + 1; 
						break;
					}
					flag[arr[k]] = false;
				}
			} else {
				flag[current] = true;
			}
		}
	 
		result = Math.max(arr.length - start, result);
	 
		return result;
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
