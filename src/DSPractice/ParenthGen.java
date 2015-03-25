package DSPractice;

public class ParenthGen {
	//Q: Given a number of parenthesis pairs, generate all combinations
	public static void main (String[] args){
		generate(3,3,"");
	}
	
	public static void generate(int leftRemain, int rightRemain, String currentStr){
		if(rightRemain == 0){
			System.out.println(currentStr);
			return;
		} else{
			if(leftRemain > 0){ //still left paren available
				//option 1: print another left paren
				generate(leftRemain-1,rightRemain,currentStr+"(");
				//option 2: if valid, print a right paren
				if(leftRemain<rightRemain){ // this means more left parens have been used
					generate(leftRemain,rightRemain-1,currentStr+")");
				}
			} else{ //only right parens left
				generate(leftRemain,rightRemain-1,currentStr+")");
			}
		}
	}	
}
