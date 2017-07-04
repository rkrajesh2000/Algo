package Algo.Test;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class FindLongestPrefixInArray {

	public static void main(String[] args) {
		
		String[] arrStr = new String[]{"abcde","abcefg","abcfgh","abcghi","abchij"};
		System.out.println("Common prefix is : " + longestCommonPrefix(arrStr));
	}
	
	private static String longestCommonPrefix(String[] strs) {
		
	    if(strs==null || strs.length==0){
	        return "";
	    }
	    
	    int minLen = Integer.MAX_VALUE;
	    
	    for(String s: strs){
	    	if (minLen > s.length())
	    		minLen = s.length();
	    }
	    
	    for(int i = 0; i < minLen; i++){
	    	for(int j=0; j < strs.length -1; j++){
	    		String s1 = strs[j];
	    		String s2 = strs[j+1];
	    		
	    		if(s1.charAt(i) != s2.charAt(i)){
	    			return s1.substring(0,i);
	    		}
	    	}
	    }
	    
	    return strs[0].substring(0, minLen);
	}
}
