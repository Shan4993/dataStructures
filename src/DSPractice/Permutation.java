package DSPractice;

public class Permutation {
	//Q: Print all the permutations of a string. 
	//   Number of permutations is n! where n is length of string
	//   Apply recursion so that we select a value for current position and permute the rest of the string
	//	 When the string reaches the appropriate size, print it and return. Repeat.
	private StringBuilder out = new StringBuilder();
	private boolean[] used;
	private final String in;
	
	Permutation(final String s){
		in = s;
		used = new boolean[s.length()];
	}
	
	public void permute(){
		if(in.length() == out.length()){
			System.out.println(out);
			return;
		} else{
			for(int i=0;i<in.length();i++){
				if(used[i]) continue;
				out.append(in.charAt(i));
				used[i] = true;
				permute();
				used[i] = false;
				out.setLength(out.length()-1);
			}
		}
	}
	
	public static void main(String[] args){
		Permutation p = new Permutation("abcd");
		p.permute();
	}
}
