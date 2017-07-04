package Algo.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingCharInString {

	static class Tuple {
		int indexVal;
		int countVal;
		
		Tuple(int index, int count){
			indexVal = index;
			countVal = count;
		}
	}
	
	public static void main(String[] args) {
		
		String input = "aacbaadce";
		System.out.println("First unique charachter in string by using HashMap '" + input + " : " + firstUniqueChar(input));
		System.out.println("First unique charachter in string by using LinkedHashMap '" + input + " : " + firstUniqueCharByLinkedHM(input));
		System.out.println("First unique charachter in string by using Char Array '" + input + " : " + firstUniqueCharArray(input));
		System.out.println("First unique charachter index in string by using LinkedHashMap '" + input + " : " + FirstUniqueCharIndexByLinkedHM(input));
		System.out.println("First unique charachter index in string by using Char Array '" + input + " : " + firstUniqueCharIndexCharArray(input));
	}
	

	/*
	Given a string, find the first non-repeating character in it. For example, 
	if the input string is "GeeksforGeeks", then output should be "f" and 
	if input string is "GeeksQuiz", then output should be "G".
	*/	
	public static char firstUniqueChar(String str){
		
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
            	Tuple tup = new Tuple(i, 1);
            	map.put(c, tup);
            }			
		}
        
        for (Map.Entry<Character, Tuple> pair : map.entrySet()) {
        	
        	if(pair.getValue().countVal == 1 && (lowestIndex > pair.getValue().indexVal || lowestIndex == -1)){
        		lowestIndex = pair.getValue().indexVal;
        		myChar = pair.getKey();
        	}
        }
        
		return myChar;
	}
	
	public static char firstUniqueCharByLinkedHM(String str){
		
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
	            
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
        	
        	if(pair.getValue() == 1){
        		myChar = pair.getKey();
        		break;
        	}
        }        
        
		return myChar;
	}
	
	public static int FirstUniqueCharIndexByLinkedHM(String str){
		
		LinkedHashMap<Character, Tuple> map = new LinkedHashMap<Character, Tuple>();
		int index = -1;
		
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if(map.containsKey(c)){
            	if(map.get(c).countVal < 2)
            		map.get(c).countVal= 2;
            }
            else {
            	map.put(c, new Tuple(i, 1));
            }			
		}
	            
        for (Map.Entry<Character, Tuple> pair : map.entrySet()) {
        	
        	if(pair.getValue().countVal == 1){
        		index = pair.getValue().indexVal;
        		break;
        	}
        }        
        
		return index;
	}
	
    public static char firstUniqueCharArray(String s) {
    	
        int[] arrayOfAlfabed = new int[256];
        
        for(int i=0;i<s.length();i++){
            arrayOfAlfabed[s.charAt(i)]++;
        }
        
        for(int i=0;i<s.length();i++){
            if (arrayOfAlfabed[s.charAt(i)]==1) 
            	return s.charAt(i);
        }
        
        return ' ';       
    }
    
    public static int firstUniqueCharIndexCharArray(String s) {
        int[] arrayOfAlfabed =new int[256];
        char[] arr =s.toCharArray();
    
        for(char c : arr ){
            arrayOfAlfabed[c]++;
        }
        
        for(int i=0;i<arr.length;i++){
            if (arrayOfAlfabed[arr[i]]==1) 
            	return i;
        }
    
        return -1;       
    }	
}
