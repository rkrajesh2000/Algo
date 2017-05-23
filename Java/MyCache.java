package Algo.Test;

import java.util.*;

public class MyCache<K, V> implements MyCacheInterface<K, V> {

    Object lock = new Object();
    public HashMap<K,V> myCache;
    
    private MyCache(){
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    
	public MyCache<K, V> getInstance() {
		return new MyCache<K,V>();
	}	
	
	@Override
    public void setCache(K key, V value){
        
        if(myCache == null)
        {
            synchronized(lock){
               if(myCache == null){
                   myCache = new HashMap<K,V>();
                   myCache.put(key, value);
               }
               else
                   myCache.put(key, value);               
            }
        } 
        else
        {
            synchronized(lock){
                myCache.put(key, value);
            }
        }              
        
    }
    
    @Override
    public V getCache(K key){
        if(myCache != null && myCache.containsKey(key))
            return myCache.get(key);
         else
             return null; 
         
    }    
    
    @Override
    public void removeCache(K key){
    
        synchronized(lock){
        if(myCache != null && myCache.containsKey(key))
             myCache.remove(key);
          }
    }
}
