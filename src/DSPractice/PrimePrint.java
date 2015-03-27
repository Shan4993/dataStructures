package DSPractice;

public class PrimePrint {
	// Q: Print all primes less than a n
	// This takes n^2 time with no additional space requirement
	public static void main(String[] args) {
		findPrimes(100);
	}

	public static void findPrimes(int n) {
		if (n < 0) {
			System.out.println("Negative number");
		} else if (n == 0 || n == 1) {
			System.out.println("Input was 0 or 1");
		} else {
			for (int i = 1; i <= n; i++) {
				int count = 0;
				for (int j = i; j >= 1; j--) {
					if (i % j == 0) {
						count++;
					}
				}
				if (count == 2) {
					System.out.print(i + ", ");
				}
			}
		}
	}
}
