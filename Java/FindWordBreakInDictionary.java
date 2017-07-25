package Algo.Test;

import java.util.*;

public class FindWordBreakInDictionary {

	private static int  minL = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("Deepak");
		wordDict.add("Rajesh");
		wordDict.add("Senthil");
		wordDict.add("Vikas");
		wordDict.add("Kum");
		wordDict.add("ar");
		wordDict.add("Anurag");
		
		String word = "RajeshKumar";
		
		System.out.println("Word break for " + word + " found wordBreakQ(): " + wordBreakQ(word,wordDict));		
		System.out.println("Word break for " + word + " found wordBreakDP(): " + wordBreakDP(word,wordDict));
		
		List<String> wordDict2 = new ArrayList<String>();
		wordDict2.add("cat");
		wordDict2.add("cats");
		wordDict2.add("and");
		wordDict2.add("sand");
		wordDict2.add("dog");
		String word2 = "catsanddog";

//		word2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		wordDict2.add("a");
//		wordDict2.add("aa");
//		wordDict2.add("aaa");
//		wordDict2.add("aaaa");
//		wordDict2.add("aaaaa");
//		wordDict2.add("aaaaaa");
//		wordDict2.add("aaaaaaa");
//		wordDict2.add("aaaaaaaa");
//		wordDict2.add("aaaaaaaaa");
//		wordDict2.add("aaaaaaaaaa");
				
		System.out.println("Word break for " + word2 + " found allPossibleWordBreakCombination(): " + allPossibleWordBreakCombination(word2,wordDict2));
		System.out.println("Word break for " + word2 + " found wordBreakListLC() recursion : " + wordBreakListLC(word2,wordDict2));
		System.out.println("Word break for " + word2 + " found wordBreakListVG() iteration  : " + wordBreakListVG(word2,wordDict2));
				
	}

	/*
	Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
	determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
	You may assume the dictionary does not contain duplicate words.

	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "dog"].

	Return true because "catsanddog" can be segmented as "cats and dog".
	 */
	private static boolean wordBreakQ(String s, List<String> wordDict) {
		
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {
        	minL = Math.min(minL, str.length());
            wordDictSet.add(str);
        }
        
    	if(wordDictSet.contains(s))
    		return true;
 
	    Queue<Integer> queue = new LinkedList<>();
	    boolean[] visited = new boolean[s.length()];
	    queue.offer(0);
	    
	    while (!queue.isEmpty()) {
	    	
	        int start = queue.poll();
	        
	        if (visited[start]) 
	        	continue;
	        	
            for (int i = start + minL; i < s.length(); i++) {
            	
                if (wordDictSet.contains(s.substring(start, i))) {
                    queue.offer(i);

                    if (wordDictSet.contains(s.substring(i,s.length()))) {
                        return true;
                    }
                }
            }
            
            visited[start] = true;
	        
	    }
	    return false;
	}

	/*
	Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
	determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
	You may assume the dictionary does not contain duplicate words.

	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "dog"].

	Return true because "catsanddog" can be segmented as "cats and dog".
	 */
    private static boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxL = 0;
        minL = Integer.MAX_VALUE;
        for (String str : wordDict) {
            
            minL = Math.min(minL, str.length());
            maxL = Math.max(maxL, str.length());
            set.add(str);
        }
        
        int n = s.length();
        boolean[]  dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            int minJ = Math.max(0, i - maxL);
            int maxJ = i - minL;
            
            if(maxJ < 0)
            	continue;
            
            for (int j = minJ; j <= maxJ; j++) {
                if (dp[j]) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }	
    
	private static List<LinkedList<String>> allPossibleWordBreakCombination(String word, List<String> wordDict){
		
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {
        	
        	minL = Math.min(minL, str.length());
            wordDictSet.add(str);
        }		 
        
	    List<LinkedList<String>> list = new ArrayList<LinkedList<String>>();
	    LinkedList<String> innerList = new LinkedList<String>();
	    addAllWordBreakCombination(wordDict, word, 0, list, innerList);
	    return list;	     
	 }	
	 
	 private static void addAllWordBreakCombination(List<String> wordDict, String word, int begin, List<LinkedList<String>> list, LinkedList<String> innerList) {
		 
	     if(word.length() == begin){

	    	 list.add(new LinkedList<String>(innerList));
	         return;
	     }
	     
	     for(int i = begin; i < word.length(); i++) {
	    	 
	    	 if((i + minL) > word.length())
	    		 break;
	    	 
	    	 String nextTarget = word.substring(begin, i+ minL);
	    	 
             if(!wordDict.contains(nextTarget)){
                 continue;
             }	    	 
             
             innerList.add(nextTarget);             
             addAllWordBreakCombination(wordDict, word , i + minL, list, innerList);
             innerList.removeLast();
	     }     
	 }
	 
	 //This Method returns list of string
	 private static List<String> wordBreakListLC(String s, List<String> wordDict) {
	        
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {

        	minL = Math.min(minL, str.length());
            wordDictSet.add(str);
        }		 
        
        List<String> list = new LinkedList<String>();
	    LinkedList<String> innerList = new LinkedList<String>();
	    addAllWordBreakCombinationLC(wordDictSet, s, 0, list, innerList);
	    return list;        
	 }
	    
	 private static void addAllWordBreakCombinationLC(HashSet<String> wordDictSet, String word, int begin, List<String> list, LinkedList<String> innerList) {
			 
	     if(word.length() == begin){
	    	 list.add(String.join(" ", innerList));		    	 
	         return;
	     }
	     
	     for(int i = begin; i < word.length(); i++) {
	    	 
	    	 if((i + minL) > word.length())
	    		 break;
	    	 
	    	 String nextTarget = word.substring(begin, i + minL);
	    	 
             if(!wordDictSet.contains(nextTarget))
                 continue;
             
             innerList.add(nextTarget);             
             addAllWordBreakCombinationLC(wordDictSet, word , i + minL, list, innerList);
             innerList.removeLast();
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
	 
	 /* 140
	  * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct 
	  * a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words. 
	  * Return all such possible sentences. For example, given
		s = "catsanddog",
		dict = ["cat", "cats", "and", "sand", "dog"].
		A solution is ["cats and dog", "cat sand dog"].
	  */
	 private static List<String> wordBreakListVG(String s, List<String> wordDict) {		    
		  
        minL = Integer.MAX_VALUE;
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        
        for (String word : wordDict) {
        	minL = Math.min(minL, word.length());
            wordDictSet.add(word);
        }        
        
	    List<String> response = new ArrayList<>();
	    Queue<Data> queue = new LinkedList<>();		    
	    queue.offer(new Data(0,""));
	    
	    while(!queue.isEmpty() && s.length() < 100)
	    {
	        Data data =  queue.poll();
	        int start = data.index;
	        
	        for(int i = start + minL; i <= s.length(); i++) {
	        	
	            String toCheck = s.substring(start, i);	            
	             
	            if(wordDictSet.contains(toCheck)) {
	            	
	                if(i == s.length())	                	
	                    response.add(data.value + toCheck);	   
	                else
	                    queue.offer(new Data(i, data.value + toCheck + " "));
	            }
	        }
	    }

	    return response;
	}    
}
