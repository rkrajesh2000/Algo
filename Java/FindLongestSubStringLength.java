package Algo.Test;

import java.util.HashSet;

public class FindLongestSubStringLength {

	public static void main(String[] args) {

		System.out.println("lengthOfLongestSubstring(): " + lengthOfLongestSubstring("abcedefbkokkflasdf") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("abcedefbkokkflasdf"));
		System.out.println("lengthOfLongestSubstring(): " + lengthOfLongestSubstring("bbbbb") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("bbbbb"));
		System.out.println("lengthOfLongestSubstring(): " + lengthOfLongestSubstring("dvdf") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("dvdf"));
		System.out.println("lengthOfLongestSubstringWithBuffer(): " + lengthOfLongestSubstringWithBuffer("abb") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("abb"));
		System.out.println("lengthOfLongestSubstringWithBuffer(): " + lengthOfLongestSubstringWithBuffer("bbbbb") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("bbbbb"));
		System.out.println("lengthOfLongestSubstringWithBuffer(): " + lengthOfLongestSubstringWithBuffer("dvdf") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("dvdf"));	
	}

    //Test Case: "aab", "bbbbb", "dvdf"
	//Time Complexity depends and worst case it is O(n^2)
	private static int lengthOfLongestSubstring(String s)
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
    
    private static int lengthOfLongestSubstringWithBuffer(String s) {
        
    	if(s==null || s.length()==0)
            return 0;
     
        HashSet<Character> set = new HashSet<Character>();     
        int max=0;     
        int i=0;
        int start=0;
        
        while(i<s.length()){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                max = Math.max(max, set.size());
                
                while(start<i && s.charAt(start) != c){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
     
            i++;
        }
     
        max = Math.max(max, set.size());

        return max;
    }
    
    public static String valueOfLongestSubstring(String input){

        HashSet<Character> set = new HashSet<Character>();

        StringBuffer longestOverAll = new StringBuffer();
        StringBuffer longestTillNow = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (set.contains(c)) {
               
            	if (longestTillNow.length() > longestOverAll.length()) {
                    longestOverAll = longestTillNow;
                }
            	
                longestTillNow = new StringBuffer();                
                longestTillNow.append("");
                set.clear();
            }
            
            longestTillNow.append(c);
            set.add(c);
        }
        
        if(longestOverAll.length()  == 0){
            return input;
        }     
        else {
            return longestOverAll.toString();
        } 
    }    
}
