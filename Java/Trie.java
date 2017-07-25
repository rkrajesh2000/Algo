package Algo.Test;

public class Trie {

	public TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
 
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){

            int index = c-'a';
            
            if(p.arr[index]==null)                
                p.arr[index] = new TrieNode();

            p=p.arr[index];
        }
        p.isEnd=true;
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
    	
        TrieNode p = searchNode(word);
        
        if( p == null )
            return false;
        else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	
        TrieNode p = searchNode(prefix);        
        return p == null ? false : true;
    }
 
    public TrieNode searchNode(String s){
    	
        TrieNode p = root;
        
        for(char c : s.toCharArray()){

            int index = c-'a';
            
            if(p.arr[index] != null)
                p = p.arr[index];
            else
                return null;            
        }
 
        if(p==root)
            return null;
 
        return p;
    }
    
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("rajesh");
		t.insert("kumar");
		t.insert("rajkabi");
		t.insert("rajkumar");
		
		System.out.println("Is rajesh present in tries : " + t.search("rajesh"));
		System.out.println("Is word like raj is present in tries : " + t.startsWith("raj"));
		System.out.println("Is word like taj is present in tries : " + t.startsWith("taj"));
	}    
}
