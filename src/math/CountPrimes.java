package math;

public class CountPrimes {

	public static void main(String[] args) {
		//countPrimes(10);
		System.out.println(isPrime(27));
	}

	public static int countPrimes(int n) {

		boolean[] primes = new boolean[n];

		for (int i = 2; i < Math.sqrt(n); i++) {
			if (primes[i] == false) {
				for (int j = i * i; j < n; j += i) {
					primes[j] = true;
				}
			}
		}

		int countPrimes = 0;

		for (int i = 2; i < n; i++) {
			if (primes[i] == false) {
				countPrimes++;
			}
		}
		System.out.println(countPrimes);
		return countPrimes;
	}
	
	
	public static boolean isPrime(int n) {
		if(n<=1) {
			return false;
		}
		for(int i=2;i<Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}

}
