package Algo.Test;
import java.util.*;
public class StringOprations {

	public static void main(String[] args) {
		
		String[] arr = new String[] {"eat", "tea", "tan", "ate", "nat", "bat","tab", "ant"};
		System.out.print("anagramGroup() : ");
		displayList(anagramGroup(arr));
		System.out.println();		
		System.out.print("findMinmumWindowSubString() ADOBECODEBANC : " + findMinmumWindowSubString("abc","a"));
		//System.out.print("findMinmumWindowSubString() ADOBECODEBANC : " + findMinmumWindowSubString("ADOBECODEBANC","ABC"))	;	
	}
	
	private static void displayList(List<List<String>> inputList){
		System.out.print("[ ");
        for (List<String> list : inputList) {
        	System.out.print("[");
        	
        	int counter = 0;
        	for(String val : list ){
        		System.out.print(val);
        		
        		++counter;
        		if(counter < list.size())
        			System.out.print(",");
        	}
        	
        	System.out.print("], ");
        } 
        System.out.print("]");
	}	
	
	/* 49
	 * Given an array of strings, group anagrams together.
	   For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	   Return: [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
	 */
	private static List<List<String>> anagramGroup(String[] strs){
		
		List<List<String>> list = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String s: strs){
			char[] charArr = new char[26];
			
			for(int i=0; i<s.length(); i++){
				charArr[s.charAt(i)-'a']++;
			}
			
			String newStr = new String(charArr);
			
			if(map.containsKey(newStr))
				map.get(newStr).add(s);
			else{
				List<String> l = new ArrayList<>();
				l.add(s);
				map.put(newStr, l);
			}
		}
		
		list.addAll(map.values());		
		return list;
	}
	
    /*
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
		For example,
		S = "ADOBECODEBANC"
		T = "ABC"
		Minimum window is "BANC".
     
      # Idea: Two pointers: moving end forward to find a valid window,
      # moving start forward to find a smaller window
      # counter and hash_map to determine if the window is valid or not
     * 
     */
   
    public static String findMinmumWindowSubString(String s, String t) {

    		if(s == null || t == null || s.length() < t.length())  
    			return "";
    		
    		if(s.equals(t))
    			return t;
    		
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();

            for(char c : t.toCharArray())//initialize hash map here
            {
                if (map.containsKey(c))
                {
                    map.replace(c, map.get(c) + 1);
                }
                else
                {
                    map.put(c, 1);
                }
            }

            int begin = 0, end = 0;  //two pointers, one point to tail and one  head            
            int counter = t.length(); //  # Works as a counter of how many chars still need to be included in a window
            int min = Integer.MAX_VALUE;
            int minStartIndex = 0;

            while (end < s.length())
            {
               //If element found in hash
                if (map.containsKey(s.charAt(end)))
                {
                   // Then we decreased the counter, if this char is must to be included                     
                    if (map.get(s.charAt(end)) > 0) 
                    	counter--;
                    
                    //decrement counter it may be negative when more than desired character in s
                     map.put(s.charAt(end), map.get(s.charAt(end)) - 1);                                        
                }   
                
               // If the current window has all the desired chars
                while (counter == 0)
                {
                   // See if this window is smaller
                    if (end - begin + 1 < min)
                    {
                        min = end - begin+1;
                        minStartIndex = begin;
                    }
                    
                   // if s[begin] is desired, we need to update the hash_map value and the counter
                    
                    if (map.containsKey(s.charAt(begin)))
                    {

                        map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
                        
                       //increment counter if we jump over one character while back tracking start.

                        if (map.get(s.charAt(begin)) > 0)
                        {
                            counter++;
                        }
                    }

                       // Move start forward to find a smaller window
                    begin++;
                }
                //Move end forward to find another valid window
                end++;
            }
            
//            if(minStartIndex == 0)
//            	end--;
            return min == Integer.MAX_VALUE ? "" : s.substring(minStartIndex, minStartIndex + min);
        }    
}
