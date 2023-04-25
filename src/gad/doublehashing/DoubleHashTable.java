package gad.doublehashing;

import java.util.Optional;

public class DoubleHashTable<K, V> {

	@SuppressWarnings("unchecked")
	public DoubleHashTable(int primeSize, HashableFactory<K> hashableFactory) {
		// Erstellt ein Array von Pairs: (Pair<K, V>[]) new Pair[primeSize];
	}

	public int hash(K key, int i) {
		return 0;
	}

	public boolean insert(K k, V v) {
		return false;
	}

	public Optional<V> find(K k) {
		return null;
	}

	public int collisions() {
		return 0;
	}

	public int maxRehashes() {
		return 0;
	}
}