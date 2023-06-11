package gad.doublehashing;

import java.util.Optional;

public class DoubleHashTable<K, V> {
	private Pair<K, V>[] table;
	private int size;
	private int collisions;
	private int maxRehashes;
	private DoubleHashable<K> hashable;
	@SuppressWarnings("unchecked")
	public DoubleHashTable(int primeSize, HashableFactory<K> hashableFactory) {
		size = primeSize;
		table = (Pair<K, V>[]) new Pair[size];
		collisions = 0;
		maxRehashes = 0;
		hashable = hashableFactory.create(size);
	}

	public int hash(K key, int i) {
		return 0;
	}

	public boolean insert(K k, V v) {
		int rehashes = 0;
		int index = hash(k, rehashes);

		while (table[index] != null && !table[index].one().equals(k)) {
			rehashes++;
			index = hash(k, rehashes);
		}

		if (table[index] != null) {
			table[index].two();
		} else {
			table[index] = new Pair<>(k, v);
		}

		if (rehashes > maxRehashes) {
			maxRehashes = rehashes;
		}

		return true;
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