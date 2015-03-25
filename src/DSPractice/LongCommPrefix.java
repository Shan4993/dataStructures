package DSPractice;

public class LongCommPrefix {
	//Q; Find the longest common prefix in a set of strings
	// Soln:check first letter of each string until there is a mismatch and return that string
	// This method check each string at a certain position before advancing 
	//   position.  Runtime is n^2 due to nested for loops with no extra space
	public static void main(String[] args){
		String[] word = new String[]{"disappear", "disagree", "disarm, " +
				"disconnect", "dishonest", "dislike"};
		String prefix = findLongest(word);
		System.out.println(prefix);
		
		word[word.length-1] = "off";
		
		prefix = findLongest(word);
		System.out.println(prefix);
		
	}
	
	public static String findLongest(String[] set){
		if(set.length == 0 || set == null) return null;

		//go to first string, check first letter
		//go to second string, check first letter
		//go to nth string, check first letter
		for(int i=0 ; i<set[0].length() ; i++){
			char c = set[0].charAt(i);
			for(int j=1 ; j<set.length ; j++){
				if(i == set[j].length() || set[j].charAt(i) != c){ 
					 return set[0].substring(0, i);
				}
			}
		}
		return set[0];
	}
}
