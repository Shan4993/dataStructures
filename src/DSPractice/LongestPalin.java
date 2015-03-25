package DSPractice;

public class LongestPalin {
	//Finding the longest palindrome within a string and returning that substring
	//This is solved in quadratic time (n^2) with space complexity of the strings 
	//    being built as we search for the biggest palindrome
	//Have to check for even and odd length palindromes 
	public static void main(String[] args){
		String answer = longestPalin("123234567898768");
		System.out.println(answer);
	}

	private static String maxStr = null;
	private static int maxLen = 0;
	
	public static String longestPalin(String s){
		char[] letter = s.toCharArray();
		for(int i=0 ; i<letter.length ; i++){
			find(letter,letter.length,i,0);
			find(letter,letter.length,i,1);
		}
		return maxStr;
	}
	
	public static void find(char[] letter,int len, int pos, int shift){
		int left = pos;
		int right = pos+shift; //this way we are looking for both even and odd length palindromes
		while(left >= 0 && right < len && letter[left] == letter[right]){
			left--; right++;
		}
		int tempLen = right-left-1; //left and right get incremented so we must - 1
		if(tempLen > maxLen){
			maxLen = tempLen;
			maxStr = new String(letter, left+1, maxLen);
		}
	}
}
