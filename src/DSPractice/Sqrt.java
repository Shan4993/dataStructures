package DSPractice;

public class Sqrt {

	public static void main(String[] arg) {
		System.out.println(sqrt(101));
		System.out.println(sqrt(96));
		System.out.println(sqrt(64));
		System.out.println(sqrt(.25));


	}
	
	public static double sqrt(double a) {
		if (a < 0)
			return -1;
		if (a == 0 || a == 1)
			return a;

		double precision = .00001;
		double start = 0, end = a;

		if (a < 1)
			end = 1;

		while (end - start > precision) {
			double mid = (start + end) / 2;
			double midSqr = mid * mid;
			if (midSqr == a)
				return mid;
			else if (midSqr < a)
				start = mid;
			else
				end = mid;
		}
		return (start + end) / 2;
	}
}
