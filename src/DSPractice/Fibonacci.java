package DSPractice;

public class Fibonacci {
	// Q: Return nth fibonacci number
	
	public static void nthFib(int n){
		int ans = fib(n-1); //adjust 1
		System.out.println(ans);
	}
	
	public static int fib(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fib(n-1) + fib(n-2);
	}

	public static void main(String args[]) {
		System.out.print("The 5th fibonacci number is ");
		nthFib(5);
	}
}
