import java.util.*;

public class Permutation {

	public static Set<String> getPermutations(String inputString) {

		if (inputString.length() <= 1) {
			Set<String> set = new HashSet<String>();
			set.add(inputString);
			return set;
		}

		String allCharsExceptLast = inputString.substring(0,
				inputString.length() - 1);
		char lastChar = inputString.charAt(inputString.length() - 1);

		Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

		Set<String> permutations = new HashSet<String>();
		for (String permOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
			for (int pos = 0; pos <= allCharsExceptLast.length(); pos++) {
				String res = permOfAllCharsExceptLast.substring(0,pos) + lastChar + permOfAllCharsExceptLast.substring(pos);
				permutations.add(res);
			}

		}
		return permutations;

	}

	public static void main(String[] args) {
		Set<String> set = getPermutations("abc");
		for (String word : set) {
			System.out.println(word);
		}
	}
}
