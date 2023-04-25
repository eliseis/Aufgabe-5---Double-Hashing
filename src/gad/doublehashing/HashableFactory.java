package gad.doublehashing;

public interface HashableFactory<K> {
	DoubleHashable<K> create(int primeSize);
}
