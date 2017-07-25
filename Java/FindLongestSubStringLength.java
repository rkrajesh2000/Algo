package Algo.Test;

import java.util.*;

import Algo.Test.FindFirstNonRepeatingCharInString.Tuple;

public class FindLongestSubStringLength {

	public static void main(String[] args) {

		System.out.println("lengthOfLongestSubstring(): " + lengthOfLongestSubstring("abcedefbkokkflasdf") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("abcedefbkokkflasdf"));
		System.out.println("lengthOfLongestSubstring(): " + lengthOfLongestSubstring("bbbbb") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("bbbbb"));
		System.out.println("lengthOfLongestSubstring(): " + lengthOfLongestSubstring("dvdf") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("dvdf"));
		System.out.println("lengthOfLongestSubstringWithBuffer(): " + lengthOfLongestSubstringWithBuffer("abcedefbkokkflasdf") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("abcedefbkokkflasdf"));
		System.out.println("lengthOfLongestSubstringWithBuffer(): " + lengthOfLongestSubstringWithBuffer("abcacbbdc") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("abcacbbdc"));
		System.out.println("lengthOfLongestSubstringWithBuffer(): " + lengthOfLongestSubstringWithBuffer("dvdf") + ", valueOfLongestSubstring(): " + valueOfLongestSubstring("dvdf"));
		System.out.println("lengthOfLongestSubstring2(): " + lengthOfLongestSubstring2("abcacbbdc") + ", valueOfLongestSubstring2(): " + valueOfLongestSubstring2("abcacbbdc"));
		System.out.println("longestSubStringWithTwoDistinctChar() for input aabbcccc with sub string : " + longestSubStringWithTwoDistinctChar("aabbcccc"));
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
	
	// O(n), abcacbbdc
	public static int lengthOfLongestSubstring2(String s) {
	     
	     if (s == null || s.length() == 0) 
	    	 return 0;
	     
	     HashMap<Character,Integer> map  = new HashMap<Character,Integer>();	     
	     int maxLen = 0;	     
	     int left =0;

	     
	     for(int i = 0; i< s.length(); i++) {
	    	  
	    	  char c = s.charAt(i);
	    	  
	    	  if(map.containsKey(c)) 
		           left = Math.max(left,map.get(c) +1);		    	  	    	  
	    	  
	          maxLen=  Math.max(maxLen,i-left +1);
	          map.put(c,i);
	     }	     
	     
	     return  maxLen;	     
	}

	// O(n), abcacbbdc
	public static String valueOfLongestSubstring2(String s) {
	     
	     if (s == null || s.length() == 0) 
	    	 return "";
	     
	     HashMap<Character,Integer> map  = new HashMap<Character,Integer>();
	     int startIndex= 0;
	     int maxLen = 0;	     
	     int left =0;
	     
	     for(int i = 0; i< s.length(); i++) {
	    	  
	    	  char c = s.charAt(i);
	    	  
	    	  if(map.containsKey(c)) 
		           left = Math.max(left, map.get(c) + 1);	 
  	  
	    	  if(maxLen < (i - left + 1))
	    		  startIndex = left;
	    	  	    	  
	          maxLen=  Math.max(maxLen, i - left + 1);
	          map.put(c,i);
	     }	     
	     
	     return  s.substring(startIndex , startIndex + maxLen);	     
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
    
    public static String valueOfLongestSubstring(String s){

    	if(s==null || s.length()==0)
            return s;
     
        HashSet<Character> set = new HashSet<Character>();     
        StringBuffer longestOverAll = new StringBuffer();
        StringBuffer longestTillNow = new StringBuffer();        
   
        int i=0;
        int start=0;
        
        while(i<s.length()){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);                
            }else{
                
            	if (longestTillNow.length() > longestOverAll.length()) 
            		longestOverAll = longestTillNow;                                
            	
                while(start < i && s.charAt(start) != c){
                    set.remove(s.charAt(start));
                    start++;
                }               

                start++;
                longestTillNow = new StringBuffer(); 
                longestTillNow.append(s.substring(start, i));
            }
     
            i++;
            longestTillNow.append(c);
        }
     
       	if (longestTillNow.length() > longestOverAll.length()) 
            longestOverAll = longestTillNow;
        

        return longestOverAll.toString(); 
    }
    /*
     * 159
     * Longest Substring with At Most Two Distinct Characters
     */
    public static String longestSubStringWithTwoDistinctChar(String s){
        
    	 if(s == null || s.length() < 1) 
    		 return null;
    	 
        HashMap<Character,Integer> map = new HashMap<>();     
        int left = 0;
        int startIndex = 0;
        int maxLen = 0;
        char prevChar = s.charAt(0);
        
        map.put(s.charAt(0), 0);
        
        for(int i=1; i<s.length(); i++){
        	char c = s.charAt(i);
        	
        	if(map.size() >= 2 && !map.containsKey(c)){
        		
        		left = map.get(s.charAt(i-1));
       			removeAllFromMapExceptInputKey(map,s.charAt(i-1));        		
        		map.put(c,i);     
        	}
        	else if( !map.containsKey(c) || (prevChar != c && map.containsKey(c))){
        		map.put(c, i);
        	}

    		if(map.size() == 2 && maxLen < (i - left + 1))
        		startIndex = left;  	
    		
    		if(map.size() == 2)
    			maxLen=  Math.max(maxLen, i - left + 1);
    		
        	prevChar = c;
        }        

        System.out.print("Length is " + maxLen + " for ");
        return s.substring(startIndex, startIndex + maxLen);
    }
    
    private static void removeAllFromMapExceptInputKey(HashMap<Character,Integer> map, char c){
		 char keyToRemove = ' ';
		 for (Map.Entry<Character,Integer> pair : map.entrySet()) {
			if(c != pair.getKey()) 
				keyToRemove = pair.getKey();
		 }
		 
		 if(keyToRemove != ' ')
			 map.remove(keyToRemove);
    }
}
