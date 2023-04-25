package gad.doublehashing;

public interface DoubleHashable<K> {

    int hash(K key);

    int hashTick(K key);
}
