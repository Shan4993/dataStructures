public class Factorial{
	
	public static void main(String[] args){
		int first = Integer.parseInt(args[0]);
		int sec = Integer.parseInt(args[1]);
		int third = Integer.parseInt(args[2]);

		System.out.println(first + ", " + sec + ", " + third);
	
		first = factorial(first);
		sec = factorial(sec);
		third = factorial(third);
		
		System.out.println(first + ", " + sec + ", " + third);
		
	}
	
	public static int factorial(int n){
		int res = 1;
		for(int t=n; t>1 ;t--){
			res *= t;
		}
		return res;
	}
	
}