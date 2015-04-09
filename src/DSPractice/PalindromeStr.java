package DSPractice;

public class PalindromeStr {
	//Q: Verify if a string is a rotated palindrome or not
	//Ex: "racecar" <-> "racecar" is true but "motor"<->"rotom" is not
	

	public static boolean isRotatedPalin(String s){
		for(int i=0;i<s.length();i++){
			String s1 = s.substring(0,i);
			String s2 = s.substring(i,s.length());
			if(isPalin(s2+s1)) return true;
		}
		return false;
	}
	
	public static boolean isPalin(String s){
		if(s.length() == 0 || s.length() == 1){ //base case
			return true;
		} else if(s.charAt(0) != s.charAt(s.length()-1)){
			return false;
		} else{
			return isPalin(s.substring(1,s.length()-1));
		}
	}
	
	
	public static void main(String[] args){
		if(isRotatedPalin("carrace"))
			System.out.println("Is a rotated palindrome");
		else
			System.out.println("Not a rotated palindrome");
		if(isRotatedPalin("motor"))
			System.out.println("Is a rotated palindrome");
		else 
			System.out.println("Not a rotated palindrome");
	}
	
	
}
