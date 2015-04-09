package DSPractice;

public class ReverseInt {
	// Q:Reverse an integer
	// Look out for edge cases such as negative number or single digit numbers
	//
	public static void main(String[] args){
		int answer = reverse(3954); //pos
		System.out.println(answer);
		
		answer = reverse(-4567);
		System.out.println(answer); //neg
		
		answer = reverse(6);
		System.out.println(answer); //single digit
	}
	
	public static int reverse(int n){
		if(n>-10 && n<10){
	        return n;
	    }  
		
		int newNum = 0;
		boolean isNeg = false;
		if(n < 0){
			isNeg = true;
			n = -n;
		}
			
		while(n != 0){
			newNum = newNum * 10;
			newNum += n%10;
			n = n/10;
		}
		
		if(isNeg){
			newNum = -newNum;
		}
		
		return newNum;
	}
}
