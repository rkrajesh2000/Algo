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
//		wordDict.add("Deepak");
//		wordDict.add("Rajesh");
//		wordDict.add("Senthil");
//		wordDict.add("Vikas");
//		wordDict.add("Kum");
//		wordDict.add("ar");
//		wordDict.add("Anurag");
//		wordDict.add("RajeshK");
//		wordDict.add("umar");		
//		String target = "RajeshKumar";

		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		String target = "catsanddog";

		System.out.println("Word break for " + target + " found allPossibleWordBreakCombination(): " + allPossibleWordBreakCombination(target,wordDict));
		System.out.println("Word break for " + target + " found wordBreakLC() recursion : " + wordBreakLC(target,wordDict));
		System.out.println("Word break for " + target + " found wordBreakVG() iteration  : " + wordBreakVG(target,wordDict));
		
		
	}
	
	private static int  minL = Integer.MAX_VALUE;
	
	//This Method returns list of list
	private static List<List<String>> allPossibleWordBreakCombination(String target, List<String> wordDict){
			
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {
            int n = str.length();
            
            if (n < minL) 
            	minL = n;   
            
            wordDictSet.add(str);
        }		 
        
	    List<List<String>> list = new LinkedList<List<String>>();
	    LinkedList<String> innerList = new LinkedList<String>();
	    addAllWordBreakCombination(wordDict, target, 0, list, innerList);
	    return list;	     
	 }	
	 
	 private static void addAllWordBreakCombination(List<String> wordDict, String target, int begin, List<List<String>> list, LinkedList<String> innerList) {
		 
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
             addAllWordBreakCombination(wordDict, target , i + minL, list, innerList);
             innerList.remove(innerList.size() - 1);
	     }     
	 }
	 
	 // This Method returns list of string
	 private static List<String> wordBreakLC(String s, List<String> wordDict) {
	        
	        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
	        minL = Integer.MAX_VALUE;
	        
	        for (String str : wordDict) {
	            int n = str.length();
	            
	            if (n < minL) 
	            	minL = n;   
	            
	            wordDictSet.add(str);
	        }		 
	        
	        List<String> list = new LinkedList<String>();
		    LinkedList<String> innerList = new LinkedList<String>();
		    addAllWordBreakCombinationLC(wordDictSet, s, 0, list, innerList);
		    return list;        
	 }
	    
	 private static void addAllWordBreakCombinationLC(HashSet<String> wordDictSet, String target, int begin, List<String> list, LinkedList<String> innerList) {
			 
		     if(target.length() == begin){
		    	 list.add(String.join(" ", innerList));		    	 
		         return;
		     }
		     
		     for(int i = begin; i < target.length(); i++) {
		    	 
		    	 if((i + minL) > target.length())
		    		 break;
		    	 
		    	 String nextTarget = target.substring(begin, i + minL);
		    	 
	             if(!wordDictSet.contains(nextTarget)){
	                 continue;
	               }	    	 
	             
	             innerList.add(nextTarget);             
	             addAllWordBreakCombinationLC(wordDictSet, target , i + minL, list, innerList);
	             innerList.remove(innerList.size() - 1);
		     }     
	 }
	 
	 static class Data
	 {
	     public int index;
	     public String value;
	     
	     public Data(int indx, String word)
	     {
	         index= indx;
	         value = word;
	     }	     
	 }
	 
	 private static List<String> wordBreakVG(String s, List<String> wordDict) {		    
		  
        minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {
            int n = str.length();
            
            if (n < minL) 
            	minL = n;   
        }
	    
	    Queue<Data> queue = new LinkedList<Data>();
	    List<String> response = new ArrayList<String>();		    
	    Data dataTracker  = new Data(0,"");	
	    queue.offer(dataTracker);
	    
	    while(!queue.isEmpty())
	    {
	        Data data =  queue.poll();
	        int start = data.index;
	        
	        for(int i = start + minL; i <= s.length(); i++) {
	        	
	            String toCheck = s.substring(start, i);	            
	             
	            if(wordDict.contains(toCheck)) {
	            	
	                if(i == s.length()){	                	
	                    response.add(data.value + toCheck);	                    
	                }
	                else{
	                	dataTracker  = new Data(i, data.value + toCheck + " ");
	                    queue.offer(dataTracker);
	                }
	               
	            }
	        }
	    }

	    return response;
	}	 
}
