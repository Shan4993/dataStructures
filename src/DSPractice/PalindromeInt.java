package DSPractice;

public class PalindromeInt {
	//check if a number is a palindrome
	public static void main(String[] args){
		if(isPal(35853)) System.out.println("Is a palindrome");
		else System.out.println("Not a palindrome");
	}
	
	
	public static boolean isPal(int n){
		if(n<0 || (n!=0 && n%10==0)) return false;
		return (n == reverse(n));
	}
	
	public static int reverse(int n){
		int rev = 0;
		while(n != 0){
			rev = (rev*10 + (n%10));
			n = n / 10;
		}
		return rev;
	}
}
