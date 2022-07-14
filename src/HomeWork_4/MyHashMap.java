package HomeWork_4;

public interface MyHashMap<K,V> extends Iterable<V> {
    boolean insert(K key,V value);
    boolean delete(K key);
    V get(K key);
    int size();
}
