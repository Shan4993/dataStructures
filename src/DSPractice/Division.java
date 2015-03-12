package DSPractice;

public class Division {

	public static void main(String[] args){
		int ans = divide(100,5);
		System.out.println("The answer is: "+ans);
		
		ans = easyDiv(100,5);
		System.out.println("The answer is: "+ans);

		
	}
	
	private static int easyDiv(int num, int divisor) {
		int count = 0;
		while(num>=divisor){
			num -=divisor;
			count++;
		}
		return count;
	}

	public static int divide(int number, int divisor) {
		int quotient = 0;
		int counter = 1;
		int currDivisor = divisor;

		while (number >= divisor) {
			if (number >= currDivisor) {
				number -= currDivisor;
				quotient += counter;
				counter *= 2;
				currDivisor *= 2;
			} else {
				counter /= 2;
				currDivisor /= 2;
			}
		}
		return quotient;
	}

}
