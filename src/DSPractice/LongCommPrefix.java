package DSPractice;

public class LongCommPrefix {
	//Q; Find the longest common prefix in a set of strings
	// Soln:check first letter of each string until there is a mismatch and return that string
	// This method check each string at a certain position before advancing 
	//   position.  Runtime is n^2 due to nested for loops with no extra space
	// Source: LeetCode
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
	    char[] checkAgainstMe = set[0].toCharArray();
	    for(int i=0;i<checkAgainstMe.length;i++){
	        char c = checkAgainstMe[i];
	        for(String word : set){
	            if(c != word.charAt(i)){
	                return new String(checkAgainstMe,0,i);
	            }
	        }
	    }
        return new String(checkAgainstMe);
	}
	
}
