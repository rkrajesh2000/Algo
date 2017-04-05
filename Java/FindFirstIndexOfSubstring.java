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
	   
	   for(int i =0 ;i < mainLength; i++){
		   
		   char cur = mainString.charAt(i);
		   
		   if (cur == subString.charAt(0)){
			   if (i + subLength <= mainLength)
			   {
				   if ((mainString.substring(i, subLength + i).equals(subString)))
					   return i;
			   }
			   else
				   return result;
	    
		   }
	   }
	   
	   return result;
	 }	
}