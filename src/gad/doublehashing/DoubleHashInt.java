package gad.doublehashing;

public class DoubleHashInt implements DoubleHashable<Integer> {
	private int primSize;

	public DoubleHashInt(int primeSize) {
		this.primSize= primSize;
	}

	@Override
	public int hash(Integer key) {
		return key % primSize;
	}

	@Override
	public int hashTick(Integer key) {
		return (1 + key) % primSize - 1;
	}
}