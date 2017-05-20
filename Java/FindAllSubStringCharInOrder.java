package Algo.Test;

public class FindAllSubStringCharInOrder {

	public static void main(String[] args) {
		System.out.println(constainsAllCharactersInOrder("google","goe"));
		System.out.println(constainsAllCharactersInOrder("google","geo"));
		System.out.println(constainsAllCharactersInOrder("google","get"));
	}
	
	private static boolean constainsAllCharactersInOrder(String bigStr, String smallStr)
	{
    
	    if( bigStr == null || smallStr == null)
	        return false;
	    
	    int lenBig = bigStr.length();
	    int lenSmall = smallStr.length();
	    int index = 0;
	    
	    if(lenBig < lenSmall)
	        return false;
	    
	    for(int i=0; i < lenBig; i++){
	    	
	        char curChar = bigStr.charAt(i);
	        
	        if(curChar == smallStr.charAt(index)){
	            if( index == (lenSmall - 1))
	            	return true;
	            else
	            	++index;       
	         }	        
	    }
	    
	    return false;
	}
}
