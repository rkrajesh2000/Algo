package Algo.Test;

public class FindFirstIndexOfSubstring {

	public static void main(String[] args) {
		
		System.out.println("First sub string index of 'def' in 'abcdefg' : " + firstIndexOfSubString("abcdefg","def"));
	}

	private static int firstIndexOfSubString(String mainString, String subString) {
	   int result = -1;
	   if (mainString == null || subString == null)
		   return result;
	   
	   int mainLength= mainString.length();
	   int subLength = subString.length();
	  
	   if(mainLength < subLength)
		   return result;
	   
	   for(int i =0 ;i < (mainLength - subLength); i++){
		   
		   char cur = mainString.charAt(i);
		   
		   if ( cur == subString.charAt(0) && (mainString.substring(i, subLength + i).equals(subString)) ){
			   return i;
	    
		   }
	   }
	   
	   return result;
	 }	
}
