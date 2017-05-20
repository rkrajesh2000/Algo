package Algo.Test;

import java.util.*;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */
public class FindWordBreakInDictionary2 {

	public static void main(String[] args) {

		List<String> wordDict = new ArrayList<String>();
		wordDict.add("Deepak");
		wordDict.add("Rajesh");
		wordDict.add("Senthil");
		wordDict.add("Vikas");
		wordDict.add("Kum");
		wordDict.add("ar");
		wordDict.add("Anurag");
		wordDict.add("RajeshK");
		wordDict.add("umar");
		
		String target = "RajeshKumar";

		System.out.println("Word break for " + target + " found allPossibleWordBreakCombination(): " + allPossibleWordBreakCombination(target,wordDict));
		System.out.println("Word break for " + target + " found wordBreakLC(): " + wordBreakLC(target,wordDict));
		
	}
	
	 private static List<List<String>> allPossibleWordBreakCombination(String target, List<String> wordDict){
	//private static List<String> allPossibleWordBreakCombination(String target, List<String> wordDict){
			
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        int  minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {
            int n = str.length();
            
            if (n < minL) 
            	minL = n;   
            
            wordDictSet.add(str);
        }		 
        
	    List<List<String>> list = new LinkedList<List<String>>();
	    LinkedList<String> innerList = new LinkedList<String>();
	    addAllWordBreakCombination(wordDict, target, 0, minL, list, innerList);
	    return list;	     
	 }	
	 
	 private static void addAllWordBreakCombination(List<String> wordDict, String target, int begin, int minL, List<List<String>> list, LinkedList<String> innerList) {
		 
	     if(target.length() == begin){

	    	 list.add(new LinkedList<String>(innerList));
	         return;
	     }
	     
	     for(int i = begin; i < target.length(); i++) {
	    	 
	    	 if((i + minL) > target.length())
	    		 break;
	    	 
	    	 String nextTarget = target.substring(begin, i+ minL);
	    	 
             if(!wordDict.contains(nextTarget)){
                 continue;
               }	    	 
             
             innerList.add(nextTarget);             
             addAllWordBreakCombination(wordDict, target , i + minL, minL, list, innerList);
             innerList.remove(innerList.size() - 1);
	     }     
	 }
	 
	 private static List<String> wordBreakLC(String s, List<String> wordDict) {
	        
	        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
	        int  minL = Integer.MAX_VALUE;
	        
	        for (String str : wordDict) {
	            int n = str.length();
	            
	            if (n < minL) 
	            	minL = n;   
	            
	            wordDictSet.add(str);
	        }		 
	        
	        List<String> list = new LinkedList<String>();
		    LinkedList<String> innerList = new LinkedList<String>();
		    addAllWordBreakCombinationLC(wordDictSet, s, 0, minL, list, innerList);
		    return list;        
	 }
	    
	 private static void addAllWordBreakCombinationLC(HashSet<String> array, String target, int begin, int minL, List<String> list, LinkedList<String> combinationList) {
			 
		     if(target.length() == begin){
		    	 list.add(String.join(" ", combinationList));		    	 
		         return;
		     }
		     
		     for(int i = begin; i < target.length(); i++) {
		    	 
		    	 if((i + minL) > target.length())
		    		 break;
		    	 
		    	 String nextTarget = target.substring(begin, i + minL);
		    	 
	             if(!array.contains(nextTarget)){
	                 continue;
	               }	    	 
	             
	             combinationList.add(nextTarget);             
	             addAllWordBreakCombinationLC(array, target , i + minL, minL, list, combinationList);
	             combinationList.remove(combinationList.size() - 1);
		     }     
		 }  	 
}
