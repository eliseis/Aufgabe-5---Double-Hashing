package gad.doublehashing;

public class DoubleHashInt implements DoubleHashable<Integer> {
	private int m;
	private int prime;

	public DoubleHashInt(int primeSize) {
		m = primeSize;
	}

	@Override
	public int hash(Integer key) {
		if (key < 0){
			return (key % m) + m;
		}
		return key % m;
	}

	@Override
	public int hashTick(Integer key) {
		if (key < 0){
			return (key % (m - 1)) + m - 1;
		}
		return key % (m - 1);
	}
}