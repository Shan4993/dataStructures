package DSPractice;

public class StringPalin {
	public static void main(String[] args){
		if(isRotatePalindrome("level")) 
			System.out.println("It is a palindrome!");
		if(isRotatePalindrome("arracec"))
			System.out.println("It is a palindrome!");

	}
	
	public static boolean isPalindrome(String s){
		char[] letter = s.toCharArray();
		for(int i=0 ; i<letter.length/2 ; i++){
				if(letter[i] != letter[letter.length-1-i])
					return false;
		}
		return true;
	}
	
	public static boolean isRotatePalindrome(String s){
		char[] letter = s.toCharArray();
		
		for(int i=0 ; i<s.length() ; i++){
				String leftStr = s.substring(0,i);
				String rightStr = s.substring(i);
				
				if(isPalindrome(rightStr+leftStr))
					return true;
		}
		return false;
	}
	
}
