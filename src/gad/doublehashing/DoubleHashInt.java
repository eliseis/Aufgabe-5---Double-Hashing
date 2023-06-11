package gad.doublehashing;

public class DoubleHashInt implements DoubleHashable<Integer> {
	private int m;

	public DoubleHashInt(int primeSize) {
		m = primeSize;
	}
	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	@Override
	public int hash(Integer key) {
		if (key < 0){
			return (key * getRandomNumber(1,m) % m) + m;
		}
		return key % m;
	}

	@Override
	public int hashTick(Integer key) {
		if (key < 0){
			return (key % (m - 1)) + m;
		}
		return key % (m - 1) + 1;
	}
}