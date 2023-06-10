package gad.doublehashing;

public class DoubleHashInt implements DoubleHashable<Integer> {
	private int m;
	private int prime;

	public DoubleHashInt(int primeSize) {
		m = findNextPrime(primeSize);
		prime = findNextPrime(m - 1);
	}

	private int findNextPrime(int n) {
		while (!isPrime(n)) {
			n++;
		}
		return n;
	}
	private boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}


	@Override
	public int hash(Integer key) {
		int positiveX = Math.abs(key);
		return positiveX % m;
	}

	@Override
	public int hashTick(Integer key) {
		int positiveX = Math.abs(key);
		int remainder = positiveX % prime;
		int hashTick = prime - remainder;
		return (hashTick == prime) ? 0 : hashTick;
	}
}