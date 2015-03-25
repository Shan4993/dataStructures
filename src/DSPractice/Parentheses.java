package DSPractice;
import java.util.Stack;


public class Parentheses {
	//Q: Decide if a string is parenthesis balanced
	// Space complexity would require a stack
	private static final char L_PAR = '(';
	private static final char R_PAR = ')';	
	private static final char L_BRACE = '{';
	private static final char R_BRACE = '}';
	private static final char L_BRACKET = '[';
	private static final char R_BRACKET = ']';
	
	public static boolean isValid(String s){
		if(s.length() == 0) return true;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c == L_PAR){
				stack.push(L_PAR);
			} else if(c == L_BRACE){
				stack.push(L_BRACE);
			} else if(c == L_BRACKET){
				stack.push(L_BRACKET);
			} else if(c == R_PAR){
				if(stack.isEmpty()) return false;
				if(stack.pop() != L_PAR) return false;
			} else if(c == R_BRACE){
				if(stack.isEmpty()) return false;
				if(stack.pop() != L_BRACE) return false;
			} else if(c == R_BRACKET){
				if(stack.isEmpty()) return false;
				if(stack.pop() != L_BRACKET) return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args){
		//all valid
		if(isValid("")) System.out.println("Valid");
		if(isValid("()")) System.out.println("Valid");
		if(isValid("(){}[]")) System.out.println("Valid");
		if(isValid("({[]})")) System.out.println("Valid");
		if(isValid("()[{}]")) System.out.println("Valid");
		if(isValid("({[({[()]})]})")) System.out.println("Valid");
		
		//not valid
		if(isValid("({)}")) System.out.println("Valid");
		if(isValid("((}}")) System.out.println("Valid");
		if(isValid("{]")) System.out.println("Valid");
	}
}
