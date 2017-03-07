package Algo.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class FindFirstNonRepeatingCharInString {

	class Tuple {
		int indexVal;
		int countVal;
	}
	
	public static void main(String[] args) {
		
		String input = "aacbaadce";
		System.out.println("First unique charachter in string '" + input + " : " + FirstUniqueChar(input));
		System.out.println("First unique charachter in string '" + input + " : " + FirstUniqueCharUnigLinkedHM(input));
	}
	

	/*
	Given a string, find the first non-repeating character in it. For example, 
	if the input string is "GeeksforGeeks", then output should be "f" and 
	if input string is "GeeksQuiz", then output should be "G".
	*/	
	public static char FirstUniqueChar(String str){
		
		HashMap<Character, Tuple> map = new HashMap<Character, Tuple>();
		char myChar = ' ';
		int lowestIndex = -1;
		
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if(map.containsKey(c)){           	
            	
            	if(map.get(c).countVal < 2)            		
            		map.get(c).countVal = 2;
            }
            else {
            	Tuple tup = new FindFirstNonRepeatingCharInString().new Tuple();
            	tup.indexVal = i;
            	tup.countVal = 1;
            	map.put(c, tup);
            }			
		}
        
        int counter = 0;
        
        for (Map.Entry<Character, Tuple> pair : map.entrySet()) {
        	
        	++counter;
        	
        	if(pair.getValue().countVal == 1 && (lowestIndex > pair.getValue().indexVal || lowestIndex == -1)){
        		lowestIndex = pair.getValue().indexVal;
        		myChar = pair.getKey();
        	}
        }
        
        System.out.println("Number Of iteration by Hash Map : " + counter);
		return myChar;
	}
	
	public static char FirstUniqueCharUnigLinkedHM(String str){
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		char myChar = ' ';
		
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if(map.containsKey(c)){
            	if(map.get(c) < 2)
            		map.replace(c, 2);
            }
            else {
            	map.put(c, 1);
            }			
		}
	    
        int counter = 0;        
        
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
        	
        	++counter;
        	
        	if(pair.getValue() == 1){
        		myChar = pair.getKey();
        		break;
        	}
        }        
        
        System.out.println("Number Of iteration by Linked Hash Map : " + counter);
		return myChar;
	}	
}
