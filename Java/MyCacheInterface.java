package Algo.Test;

public interface MyCacheInterface<K, V>{
    public void setCache(K key, V value);
    public V getCache(K key);
    public void removeCache(K key);
}
