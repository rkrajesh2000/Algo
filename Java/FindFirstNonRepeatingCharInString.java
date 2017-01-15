package Algo.Test;

import java.util.HashMap;
import java.util.Iterator;
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

	}
	
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
        
        Iterator<Entry<Character, Tuple>> it = map.entrySet().iterator();
        
        while (it.hasNext()) {
        	Map.Entry<Character, Tuple> pair = it.next();
        	
        	if(pair.getValue().countVal == 1 && (lowestIndex > pair.getValue().indexVal || lowestIndex == -1)){
        		lowestIndex = pair.getValue().indexVal;
        		myChar = pair.getKey();
        	}
        }
        
		return myChar;
	}
}
