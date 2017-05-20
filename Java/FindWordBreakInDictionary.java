package Algo.Test;

import java.util.*;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "rajeshkumar",
dict = ["rajesh", "kumar"].

Return true because "rajeshkumar" can be segmented as "rajesh kumar".
 */
public class FindWordBreakInDictionary {

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("Deepak");
		wordDict.add("Rajesh");
		wordDict.add("Senthil");
		wordDict.add("Vikas");
		wordDict.add("Kum");
		wordDict.add("ar");
		wordDict.add("Anurag");
		
		String target = "RajeshKumar";
		
		System.out.println("Word break for " + target + " found wordBreakQ(): " + wordBreakQ(target,wordDict));		
		System.out.println("Word break for " + target + " found wordBreakDP(): " + wordBreakDP(target,wordDict));		
		System.out.println("Word break for " + target + " found wordBreakQDisplayWord(): " + wordBreakQDisplayWord(target,wordDict));
		
		
	}

	private static boolean wordBreakQ(String s, List<String> wordDict) {
		
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        int  minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {
            int n = str.length();
            
            if (n < minL) 
            	minL = n;   
            
            wordDictSet.add(str);
        }
        
    	if(wordDictSet.contains(s))
    		return true;
 
	    Queue<Integer> queue = new LinkedList<Integer>();
	    boolean[] visited = new boolean[s.length()];
	    queue.offer(0);
	    
	    while (!queue.isEmpty()) {
	    	
	        int start = queue.poll();
	        
	        if (visited[start]) 
	        	continue;
	        	
            for (int end = start + minL; end <= s.length()-1; end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.offer(end);

                    if (wordDictSet.contains(s.substring(end,s.length()))) {
                        return true;
                    }
                }
            }
            
            visited[start] = true;
	        
	    }
	    return false;
	}
	
	private static List<List<String>> wordBreakQDisplayWord(String s, List<String> wordDict) {
		
        HashSet<String> wordDictSet = new HashSet<String>(wordDict);
        int  minL = Integer.MAX_VALUE;
        
        for (String str : wordDict) {
            int n = str.length();
            
            if (n < minL) 
            	minL = n;   
            
            wordDictSet.add(str);
        }
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> result = new ArrayList<String>();
        
    	if(wordDictSet.contains(s)){
    		result.add(s);
    		list.add(result);
    		return list;
    	}
 
	    Queue<Integer> queue = new LinkedList<Integer>();
	    boolean[] visited = new boolean[s.length()];
	    queue.offer(0);
	    
	    while (!queue.isEmpty()) {
	    	
	        int start = queue.poll();
	        
	        if (visited[start]) 
	        	continue;
	        	
            for (int end = start + minL; end <= s.length()-1; end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.offer(end);
                    result.add(s.substring(start, end));

//                    if (wordDictSet.contains(s.substring(end,s.length()))) {
//                        result.add(s.substring(end,s.length()));
//                    }
//                    else 
//                    	result.remove(result.size()-1);
                }
                
                if(end == s.length()-1){
                	list.add(result);
                	result = new ArrayList<String>(); 
                }                
            }            

            visited[start] = true;
	        
	    }
	    return list;
	}
	
    private static boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxL = 0, minL = Integer.MAX_VALUE;
        for (String str : wordDict) {
            int n = str.length();
            
            if (n < minL) 
            	minL = n;
            
            if (n > maxL)
            	maxL = n;
            
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
}
