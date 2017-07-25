package Algo.Test;

import java.util.*;

/*
 * 146 
 * LRU Cache
 */

public class LRUCache {
	
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;
    
    static class Node
    {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {            
            this.key = key;
            this.val = val;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	
        if (map.containsKey(key)) {
        	
            Node n = map.get(key);
            removeNode(n);
            setHead(n);
            return n.val;
        }

        return -1;        
    }
    
    public void put(int key, int value) {
    	
        if (map.containsKey(key)) {
        	
            Node old = map.get(key);
            old.val = value;
            removeNode(old);
            setHead(old);
        }
        else
        {
            Node created = new Node(key, value);
            
            if (map.size() >= capacity) {
                map.remove(end.key);
                removeNode(end);
            }

            setHead(created);
            map.put(key, created);
        }        
    }
    
    private void removeNode(Node n)
    {
        if (n.prev != null)
            n.prev.next = n.next;
        else
            head = n.next;

        if (n.next != null)
            n.next.prev = n.prev;
        else
            end = n.prev;
    }

    private void setHead(Node n)
    {
        n.next = head;
        n.prev = null;

        if (head != null)
            head.prev = n;

        head = n;

        if (end == null)
            end = head;
    }  
    
	public static void main(String[] args) {
		
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(1, 101);
        lruCache.put(2, 102); 
        lruCache.put(3, 103);
        lruCache.put(4, 104);
        lruCache.put(5, 105);
        lruCache.put(6, 106);
        lruCache.put(7, 107);
        lruCache.put(8, 108);
        lruCache.put(9, 109);
        System.out.println(lruCache.get(7));
        lruCache.put(10, 110);
        lruCache.put(11, 111);
        System.out.println(lruCache.get(1));
        lruCache.put(12, 112);
        lruCache.put(7, 117);
        System.out.println(lruCache.get(9));   
   }		
}
