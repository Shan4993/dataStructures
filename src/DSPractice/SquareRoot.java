package DSPractice;

public class SquareRoot {
	// Q: Get the square root of a number
	public static double squareRoot(double num) {
		if (num < 0)
			return -1;
		if (num == 0 || num == 1)
			return num;

		double start = 0;
		double end = num;
		double precision = .000001;

		if (num < 1)
			start = 1;

		while (end - start > precision) {
			double mid = start + end / 2;
			double midSq = mid * mid;
			if (midSq == num) {
				return mid;
			} else if (midSq > num) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return (start + end) / 2;
	}

	public static void main(String[] args) {
		System.out.println(squareRoot(64));
		System.out.println(squareRoot(101));
		System.out.println(squareRoot(0));
		System.out.println(squareRoot(1));
		System.out.println(squareRoot(.5));
	}
}
