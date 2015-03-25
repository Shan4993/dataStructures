package DSPractice;

public class Palindrome {
	//check if a number is a palindrome
	public static void main(String[] args){
		if(isPalin(35453)) System.out.println("Is a palindrome");
		else System.out.println("Not a palindrome");
	}
	
	public static boolean isPalin(int num){
		if(num < 0 ||(num != 0 && num%10==0)){ //neg numbers and 10,20,30,etc
			return false;
		}
		int rev = 0;
		while(num > rev){
			rev = rev*10 + num%10; 
			num = num / 10;
		}
		return (num == rev || num == rev/10); //second checks cases where there are odd digits
	}
}
