package Algo.Test;

import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		
		System.out.println("findAllPermutationInArray() : ");
		for(List<Integer> innerList: findAllPermutationInArray(new int[]{1,2,3},0)){
			for(int n : innerList){
				System.out.print(n + ",");
			}
			System.out.println();
		}		
		
		System.out.println("findAllPermutationInString() : ");
		for(String s : findAllPermutationInString("123")){
			System.out.println(s);
		}
		
		System.out.println("uniqueCombinationPermutation() : ");
		for(List<Integer> innerList: uniquePermutationCombination(new int[]{1,2,1,2})){
			for(int n : innerList){
				System.out.print(n + ",");
			}
			System.out.println();
		}	
		
		System.out.println("palindromePermutationCombination() : ");
		for(List<Integer> innerList: palindromePermutationCombination(new int[]{1,2,1,2})){
			for(int n : innerList){
				System.out.print(n + ",");
			}
			System.out.println();
		}
		
		
		
		System.out.print("palindromePermutationCombinationString() : ");

		for(String s : palindromePermutationCombinationString("aabbc")){
			System.out.print(s + ", ");
		}
		
		System.out.println();
		System.out.println("Kth Permutation in a Sequence by findKthPermutationInSequence() : " + findKthPermutationInSequence(5, 5));
		System.out.println("Kth Permutation in a Sequence by findKthInSequenceByNextPermutation(): " + findKthInSequenceByNextPermutation(5, 5));		
		System.out.println("isPalindromePermutationPossibleInString(String) : " + isPalindromePermutationPossibleInString("ababc"));
		System.out.println("isPalindromePermutationPossibleInArray(Innteger) : " + isPalindromePermutationPossibleInArray(new int[]{1,2,1}));
		System.out.println("shortPermutationInLongString(String, String) : " + shortPermutationInLongString("hello","ooolleohooleh"));
		
		
		//5,3,4,9,7,6 -- 5,3,6,4,7,9
		System.out.print("nextLargestPermutation() : ");
		for(int n : nextLargestPermutation(new int[]{5,3,4,9,7,6})){
			System.out.print(n + ",");
		}
	}
	
	private static List<List<Integer>> findAllPermutationInArray(int[] nums, int index){
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return null;
		else if(index == nums.length){
			list.add(new ArrayList<Integer>());
			return list;
		}
		
		int curVal = nums[index];
		List<List<Integer>> listTemp = findAllPermutationInArray(nums, index + 1);
		
		for(List<Integer> innerList : listTemp){
			int listSize = innerList.size();			
			for(int i = 0; i <= listSize; i++){
				list.add(insertValueAt(innerList,curVal, i));
			}
		}				
		
		return list;
	}
	
	private static List<Integer> insertValueAt(List<Integer> innerList, int curVal, int pos){
		List<Integer> list = new ArrayList<Integer>(innerList);
		list.add(pos, curVal);
		return list;
	}
	
	private static List<String> findAllPermutationInString(String s){
		
		List<String> permutaion = new ArrayList<>();
		
		if(s == null)
			return null;
		else if(s.length() == 0){
			permutaion.add("");
			return permutaion;
		}
		
		String curChar = s.substring(0,1);
		String remainder = s.substring(1);
		List<String> list = findAllPermutationInString(remainder);
				
		for(String valStr : list){
			for(int i = 0; i <= valStr.length(); i++){
				permutaion.add(insertValueStringAt(valStr, curChar, i));
			}
		}
		
		return permutaion;
	}
	
	private static String insertValueStringAt(String valStr, String curChar, int pos){
		
		return valStr.substring(0, pos) + curChar + valStr.substring(pos);
	}
	
	private static List<List<Integer>> uniquePermutationCombination(int[] nums){

	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    
	    if(nums == null || nums.length == 0)
	        return list;
	        
	    if(nums.length == 1){
	        list.add(convertArrayToList(nums));
	        return list;
	    }
	    
	    addUniquePermutationCombination(nums, 0, list);
	    return list;   
	}

	private static void addUniquePermutationCombination(int[] nums, int start, List<List<Integer>> list) {
		 
	     if( start >= nums.length){
	         list.add(convertArrayToList(nums));
	         return;
	     }

	     for(int i = start; i < nums.length; i++) {
             if(isDuplicateExists(nums, start, i)) {
            	 swap(nums, start, i );
	             addUniquePermutationCombination(nums, start + 1, list);
	             swap(nums, start, i );
             }
	     }		 
	 }
	 
	 private static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
	 
	 private static List<Integer> convertArrayToList(int[] nums) {
	 	List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) 
			list.add(nums[i]);
		
		return list;
	}
	 
	 private static boolean isDuplicateExists(int[] nums, int start, int end) {
		for (int i = start; i < end; i++) {
			if (nums[i] == nums[end]) {
				return false;
			}
		}
		return true;
	}	
	
	private static List<List<Integer>> palindromePermutationCombination(int[] nums){

	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    
	    if(nums == null || nums.length == 0)
	        return list;
	        
	    if(!isPalindromePermutationPossibleInArray(nums)){
	        return list;
	    }
	    
	    addPalindromePermutationCombination(nums, 0, list);
	    return list;   
	}
	
	private static void addPalindromePermutationCombination(int[] nums, int start, List<List<Integer>> list) {
		 
	     if( start >= nums.length){
	    	 if(isPalindromeArray(nums))
	    		 list.add(convertArrayToList(nums));
	    	 
	         return;
	     }

	     for(int i = start; i < nums.length; i++) {
             if((nums[start] != nums[i] || start == i) && isDuplicateExists(nums, start, i)) {
            	 swap(nums, start, i );
            	 addPalindromePermutationCombination(nums, start + 1, list);
	             swap(nums, start, i );
             }
	     }		 
	}

	private static boolean isPalindromeArray(int[] nums){
		
		int i = 0;
		int j = nums.length-1;
		
		while(i< j){
			
			if(nums[i] != nums[j])
				return false;
			
			i++;
			j--;
		}
		return true;
	}
	
	private static boolean isPalindromePermutationPossibleInArray(int[] nums){
		
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i))
                set.remove(i);
        }
        return set.size() <= 1;		
	}
	
	/*
	 * Time complexity is O(n) and space complexity O(128), since 128 is constant so it is O(1)
	 */
	private static boolean isPalindromePermutationPossibleInString(String s){
		
		int[] arr = new int[128];
		int count = 0;
		
		for(int i=0; i < s.length(); i++){
			arr[s.charAt(i)]++;
			if(arr[s.charAt(i)] % 2 == 0)
				--count;
			else
				++count;
		}
		return count <= 1;		
	}
	
	private static boolean isPalindromePermutationPossibleInString(String s, int[] arr){
		
		int count = 0;
		
		for(int i=0; i < s.length(); i++){
			arr[s.charAt(i)]++;
			if(arr[s.charAt(i)] % 2 == 0)
				--count;
			else
				++count;
		}
		return count <= 1;		
	}
	
	
	/*
	 * Time complexity : O(Factorial(n/2 + 1)) = n/2!, string.reverse() function will take n/4 time.
	 * Space complexity : O(n). The depth of recursion tree can go up to n/2 in the worst case
	 */
	private static List<String> palindromePermutationCombinationString(String s){
		SortedSet<Integer> t = new TreeSet<Integer>(Collections.reverseOrder());
		t.remove(t.size()-1);
				
		List<String> list = new ArrayList<>();
		int[] arr = new int[128];
		if(!isPalindromePermutationPossibleInString(s, arr))
			return list;
		
		char[] charArr = new char[s.length()/2];
		String charMiddle = "";
		int charCount =0;
		
		for(int i=0; i < arr.length; i++){
			
			if(arr[i] % 2 == 1)
				charMiddle = String.valueOf((char)i);

			for(int j=0; j < arr[i]/2; j++)
				charArr[charCount++] = (char)i;
		}
		
		addPalindromePermutationCombinationString(charArr, charMiddle, 0, list);	
		return list;
	}
	
	private static void addPalindromePermutationCombinationString(char[] charArr, String charMiddle, int start, List<String> list){
		
		if(start == charArr.length){
			list.add(String.valueOf(charArr) + charMiddle + (new StringBuffer(String.valueOf(charArr))).reverse());			
		}
		else{
			
			for(int i = start; i<charArr.length; i++){
				if(charArr[start] != charArr[i] || start == i){
					swapChar(charArr, start, i);
					addPalindromePermutationCombinationString(charArr, charMiddle, start + 1, list);
					swapChar(charArr, start, i);
				}
			}
		}
	}
	
	 private static void swapChar(char[] charArr, int start, int end) {
		char temp = charArr[start];
		charArr[start] = charArr[end];
		charArr[end] = temp;
	}
	 
	/*
	 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
		If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
		The replacement must be in-place, do not allocate extra memory.
		Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
		1,2,3 --> 1,3,2
		3,2,1 --> 1,2,3
		1,1,5 --> 1,5,1
	 *	Traverse the given number from rightmost digit, keep traversing till you find a digit ‘d’ 
	 *  which is smaller than the previously traversed digit
	 *	Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’ say ‘e’. 
	 *  Swap the above found two digits ‘d’ and ‘e’
	 *  Now sort all digits from position next to ‘d’ to the end of number. 
	 *  The number that we get after sorting is the output.
	 */
	private static int[] nextLargestPermutation(int[] nums){
		 
        if (nums == null || nums.length == 0 || nums.length == 1)
            return nums;	
        
		 int n = nums.length-1;		 
		 int i = n;
		 
		 while(i > 0 && nums[i-1] >= nums[i])
			 i--;
		 
		 if(i <= 0){
			 System.out.println("Next number is not possible so goes back to 1st smallest permutation. ");
			 Arrays.sort(nums);
			 return nums;
		 }
		 
		 int j = i-1;
		 int nextSmallest = j;
		 int x = nums[i-1];
		 
		 while(j <= n){
			 if(nums[j] > x && nums[nextSmallest] >= x)
				 nextSmallest = j;
			 
			 j++;
		 }
		 
		 swap(nums,i-1, nextSmallest);
		 
		 while(i < n){
			 swap(nums,i, n);
			 i++;
			 n--;
		 }
		 
		 return nums;
	 }
	/*
	 *  Time complexity : O(l1+26*(l2-l1)), where l1 is the length of string s1 and l2 is the length of string s2
		Space complexity : O(1) because using Constant space is used.
	 */
	private static boolean shortPermutationInLongString(String s1, String s2){
		
		if(s2 == null || s1 == null || s1.length() > s2.length())
			return false;
		
		int[] arrSmall = new int[26];
		
		for(int i = 0; i < s1.length(); i ++){
			arrSmall[s1.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i <= s2.length() - s1.length(); i++){
			if(arrSmall[s2.charAt(i) - 'a'] > 0){
				int index = isPermutationPossible(i, i + s1.length(), s2, arrSmall);
				
				if(index == -1)
					return true;
				else
					i = index;					
				
			}
		}
		
		return false;
	}
	
	private static int isPermutationPossible(int start, int end, String longStr, int[] arrSmall){
		int[] arr = new int[26];
		int index = -1;
		
		for(int i = start; i < end; i ++){
			arr[longStr.charAt(i) - 'a']++;
		}
	
		for(int i = start; i < end; i ++){
			int currIndex = longStr.charAt(i) - 'a';
			if( arrSmall[currIndex] == 0 || arr[currIndex] != arrSmall[currIndex]){
				index = i;
				return index;
			}
		}
		
		return index;
	}
	
	public static String findKthInSequenceByNextPermutation(int n, int k) {
		
		int[] num = new int[n];
		
		for(int i = 1; i <= n; i++){
			num[i-1] = i;
		}
		
		for(int i = 1; i < k; i++){
			
			num = nextLargestPermutation(num);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < num.length; i++){			
			sb.append(num[i]);
		}
		
		return sb.toString();
	}
	
	public static String findKthPermutationInSequence(int n, int k) {
		
		boolean[] output = new boolean[n];
		StringBuilder sb = new StringBuilder("");
 
		int[] factorial = new int[n];
		factorial[0] = 1;
 
		for (int i = 1; i < n; i++)
			factorial[i] = factorial[i - 1] * i;
 
		for (int i = n - 1; i >= 0; i--) {
			int num = 1;
 
			while (k > factorial[i]) {
				num++;
				k = k - factorial[i];
			}
 
			for (int j = 0; j < n; j++) {
				if (j + 1 <= num && output[j]) {
					num++;
				}
			}
 
			output[num - 1] = true;
			sb.append(Integer.toString(num));
		}
 
		return sb.toString();
	}	
}
