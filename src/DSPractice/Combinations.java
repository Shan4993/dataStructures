package DSPractice;

public class Combinations {
	// Q: Provide all combinations of an input string 
	// Ex: abc and cba are the same thing so order doesnt matter therefore # of results is not n!
	// Source: PIE

	private String in;
	private StringBuilder out = new StringBuilder();
	
	Combinations(final String s){
		in = s;
	}
	
	public void combine(){
		combine(0);
	}

	private void combine(int start) {
		for(int i=start;i<in.length();i++){
			out.append(in.charAt(i));
			System.out.println(out);
			if(i<in.length()){
				combine(i+1);
			}
			out.setLength(out.length()-1);
		}
	}
	
	public static void main (String[] args){
		Combinations c = new Combinations("wxyz");
		c.combine();
	}
}
