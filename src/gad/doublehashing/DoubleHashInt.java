package gad.doublehashing;

public class DoubleHashInt implements DoubleHashable<Integer> {
	private int m, x;

	public DoubleHashInt(int primeSize) {
		m = primeSize;
		x = getRandomNumber(1,m - 1);
	}
	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	@Override
	public int hash(Integer key) {
		if (key < 0){
			key = -1 * key;
		}
		return (int) ((long) key) % m;
	}

	@Override
	public int hashTick(Integer key) {
		if (key < 0){
			key = -1 * key;
		}
		return key % (m - 1) + 1;
	}
}