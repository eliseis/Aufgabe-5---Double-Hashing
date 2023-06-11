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
		return ( hashable.hash(key) + i * hashable.hashTick(key)) % size;
	}

	public boolean insert(K k, V v) {
		int rehashes = 0;
		int index = hash(k, rehashes);


		while (table[index] != null && !table[index].one().equals(k)) {
			rehashes++;
			if (rehashes >= size){
				collisions++;
				return false;
			}
			index = hash(k, rehashes);
		}

		if (rehashes > 0) {
			collisions++;
		}
		table[index] = new Pair<>(k, v);

		if (rehashes > maxRehashes) {
			maxRehashes = rehashes;
		}

		return true;
	}

	public Optional<V> find(K k) {
		int rehashes = 0;
		int index = hash(k, rehashes);

		while (table[index] != null && rehashes < size) {
			if (table[index].one().equals(k)) {
				return Optional.of(table[index].two());
			}

			rehashes++;
			index = hash(k, rehashes);
		}

		return Optional.empty();
	}

	public int collisions() {
		return collisions;
	}

	public int maxRehashes() {
		return maxRehashes;
	}
}