package DSPractice;

public class CoinsCombine {

	public static void main(String[] args){
		System.out.println("input 1: " + getTotalComb(1));
		System.out.println("input 5: " + getTotalComb(5));
		System.out.println("input 10: " + getTotalComb(10));
		System.out.println("input 15: " + getTotalComb(15));
		System.out.println("input 20: " + getTotalComb(20));
		System.out.println("input 25: " + getTotalComb(25));
		System.out.println("input 50: " + getTotalComb(50));
		
	}
	
	public static int getTotalComb(int n){
	    if(n<0) return 0;
	    if (n == 0) return 1;
	    
	    int numOfWays = 0;
	    
	    numOfWays += getTotalComb(n-25) + getTotalComb(n-10) + getTotalComb(n-5) + getTotalComb(n-1); 
	    
	    return numOfWays;
	}
}
