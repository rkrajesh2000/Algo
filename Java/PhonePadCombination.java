/**
 * 
 */
package Algo.Test;

import java.util.*;


/**
 * @author Rajesh
 * Phone digit letter combination
 */
public class PhonePadCombination {

    private static HashMap<Character, char[]> map = new HashMap<Character, char[]>();
    
    static{
	    map.put('2', new char[]{'a','b','c'});
	    map.put('3', new char[]{'d','e','f'});
	    map.put('4', new char[]{'g','h','i'});
	    map.put('5', new char[]{'j','k','l'});
	    map.put('6', new char[]{'m','n','o'});
	    map.put('7', new char[]{'p','q','r','s'});
	    map.put('8', new char[]{'t','u','v'});
	    map.put('9', new char[]{'w','x','y','z'});
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.print("Phone digit letter combination1 :");
		
        for (String val : letterCombinations("234")) {
        	        	
        		System.out.print(val);
        		System.out.print(",");
         }	
        
        System.out.println();
		System.out.print("Phone digit letter combination2 (Not Working) :");
		
        for (String val : letterCombinations2("234")) {
        	        	
        		System.out.print(val);
        		System.out.print(",");
         }        
	}

	public static List<String> letterCombinations(String digits) {
		
	    List<String> result = new ArrayList<String>();
	    if(digits.equals(""))
	        return result;
	 
	    helper(digits, 0, result, new StringBuilder());	 
	    return result;
	}
	 
	public static void helper( String digits, int start, List<String> result, StringBuilder sb){
		
	    if(start == digits.length()){
	        result.add(sb.toString());
	        return;
	    }
	 
	    char c = digits.charAt(start);
	    char[] arr = map.get(c);
	 
	    for(int i=0; i < arr.length; i++){
	        sb.append(arr[i]);
	        helper(digits, start+1, result, sb);
	        sb.deleteCharAt(sb.length()-1);
	    }
	}
	
	//Not Working Need to fix
	public static List<String> letterCombinations2(String digits) {
		
	    List<String> result = new ArrayList<String>();
	    if(digits.equals(""))
	        return result;
	 
	    int len = digits.length();
	    
	    for(int i=0; i < len; i++){
	    	for(int j = i+1; j < len; j++){	    		
	    		helper2(map.get(digits.charAt(i)), map.get(digits.charAt(j)), result);
	    	}
	    }	    
	 
	    return result;	 
	}
	
	public static void helper2(char[] chaSet1, char[] charSet2, List<String> result){
		
		for(int i = 0; i < chaSet1.length; i++){
			for(int j = 0; j < charSet2.length; j ++)
				result.add(String.valueOf(chaSet1[i]) + String.valueOf(charSet2[j]));
		}
	}
}
