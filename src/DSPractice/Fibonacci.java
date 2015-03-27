package DSPractice;

public class Fibonacci {
	// Q: Return nth fibonacci number
	public static void nthFib(int n){
		int answer = fib(n-1);
		System.out.println(answer);
		//technically first fib number is 0 not 1 so have to adjust
	}
	
	public static int fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n > 1)
			return fib(n - 1) + fib(n - 2);
		else
			return -1;
	}

	public static void main(String args[]) {
		System.out.print("The 5th fibonacci number is ");
		nthFib(5);
	}
}
