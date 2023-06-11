package gad.doublehashing;

public class DoubleHashString implements DoubleHashable<String> {
	private int m;
	public DoubleHashString(int primeSize) {
		m = primeSize;
	}

	@Override
	public int hash(String key) {
		int hash = calculateHash(key, m);
		return hash;
	}

	@Override
	public int hashTick(String key) {
		int hash = calculateHash(key, m - 1);
		return hash;
	}

	private int calculateHash(String key, int modulo) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = (31 * hash + key.charAt(i)) % modulo;
		}
		return hash;
	}
}