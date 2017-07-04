package Algo.Test;

import java.util.*;

public class SearchWord {

	static boolean[][] visited;
	
	public static class TrieWordNode {
		TrieWordNode[] next;
	    String trieWord;

	    public TrieWordNode() {
	        this.next = new TrieWordNode[26];
	    }
	}
	
	public static void main(String[] args) {

		char[][] board = new char[][]{
				{'a','b','c','e'},
				{'s','f','c','s'},
				{'a','d','e','w'}
		};
		
		System.out.println("Is word exists in matrix by wordExistsInMatrix() : " + wordExistsInMatrix(board,"abcced"));
		System.out.println("Is word exists in matrix by wordExistsInMatrix() : " + wordExistsInMatrix(board,"abcb"));
		
		System.out.print("Find all words present in matrix by findWordsInMatrix(): ");
		
		String[] words = new String[]{"abcced", "abcb", "cfsade", "fcsd", "aadg"};
		
		for(String s: findWordsInMatrix(board, words)){
			System.out.print(s + ", ");
		}
		
		System.out.println();
		System.out.print("Find all words present in matrix by findWordsInMatrixByTries(): ");
		
		for(String s: findWordsInMatrixByTries(board, words)){
			System.out.print(s + ", ");
		}
	}
	
	/* 79
	 * Given a 2D board and a word, find if the word exists in the grid.		
		The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
		For example,
		Given board =		
		[
		  ['A','B','C','E'],
		  ['S','F','C','S'],
		  ['A','D','E','E']
		]
		word = "ABCCED", -> returns true,
		word = "SEE", -> returns true,
		word = "ABCB", -> returns false.
	 */
	public static boolean wordExistsInMatrix(char[][] board, String word) {

	    for (int i=0; i<board.length; i++) {
	    	for (int j=0; j < board[i].length; j++) {
	    		if (exist(board, i, j, word, 0)) return true;
	    	}
	    }
	    
	    return false;
	}

	private static boolean exist(char[][] board, int i, int j, String word, int index) {
		if (index == word.length()) 
			return true;
		
		if (i<0 || j<0 || i== board.length || j == board[i].length) 
			return false;
		
		char c = board[i][j];
		if (c == '#' || board[i][j] != word.charAt(index)) 
			return false;

		board[i][j] = '#';
		boolean exist = exist(board, i, j+1, word, index+1)
			|| exist(board, i, j-1, word, index+1)
			|| exist(board, i+1, j, word, index+1)
			|| exist(board, i-1, j, word, index+1);
		
		board[i][j] = c;
		
		return exist;
	}
	
    private static List<String> findWordsInMatrix(char[][] board, String[] words) {
        
        List<String> list = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
                
        for(String word: words){
            visited = new boolean[board.length][board[0].length];
            for (int i=0; i<board.length; i++) {
            	for (int j=0; j<board[i].length; j++) {
            		if (exist(board, i, j, word, 0) && !set.contains(word)) {
            		    set.add(word);
            		    list.add(word);
            		}
            	}
            }
        }
        
        return list;

    }
 
    private static List<String> findWordsInMatrixByTries(char[][] board, String[] words) {
        
        List<String> list = new ArrayList<>();
        TrieWordNode trie = getTries(words);

        for (int i=0; i<board.length; i++) {
        	for (int j=0; j<board[i].length; j++) {
        		existInTries(board, i, j, trie, list);
        	}
        }
        
        return list;
    }
    
    private static TrieWordNode getTries(String[] words){
    	
    	TrieWordNode trie = new TrieWordNode();
        
        for(String word : words){
        	
        	TrieWordNode p = trie;
        	for(char c : word.toCharArray()){
        		
        		int index = c-'a';        		
        		if(p.next[index] == null)
        			p.next[index] = new TrieWordNode();
        		
        		p = p.next[index];
        	}
        	
        	p.trieWord = word;
        }
        
        return trie;
    }
    
	private static void existInTries(char[][] board, int i, int j, TrieWordNode trie, List<String> list) {
		
		if (i<0 || j<0 || i>= board.length || j >= board[i].length ) 
			return;
			
		char c = board[i][j];	
		
		if(c == '#' || trie.next[c - 'a'] == null)
			return;
		
		TrieWordNode nextTrie = trie.next[c - 'a'];
		
		if (nextTrie.trieWord != null) {
			list.add(nextTrie.trieWord);
			nextTrie.trieWord = null; // This is to eliminate duplicate
		}

		board[i][j] = '#';
		existInTries(board, i-1, j, nextTrie, list);	
		existInTries(board, i+1, j, nextTrie, list);	
		existInTries(board, i, j-1, nextTrie, list);		
		existInTries(board, i, j+1, nextTrie, list);	
		board[i][j] = c;
	}    
}
