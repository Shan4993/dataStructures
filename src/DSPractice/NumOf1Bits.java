package DSPractice;

public class NumOf1Bits {
	public static void main(String[] args){
		System.out.println(hammingWeight(5));
		System.out.println(hammingWeight(7));
		System.out.println(hammingWeight(11));
		System.out.println(hammingWeight(15));
	}
	
	
		
	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >>> 1;
		}
		return count;
	}
}
