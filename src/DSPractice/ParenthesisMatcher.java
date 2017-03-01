import java.util.*;

public class ParenthesisMatcher {

	public static int findCloserIndex(String str, int openerIndex) {
		int counter = 1;
		for (int i = openerIndex + 1; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				counter++;
			} else if (c == ')') {
				counter--;
				if (counter == 0) {
					return i;
				}
			}
		}
		throw new IllegalArgumentException("error");
	}

	public static boolean validator(char[] phrase) {
		Map<Character, Character> openersToClosers = new HashMap<Character, Character>();
		openersToClosers.put('(', ')');
		openersToClosers.put('[', ']');
		openersToClosers.put('{', '}');

		Set<Character> openers = openersToClosers.keySet();
		Set<Character> closers = new HashSet<Character>(
				openersToClosers.values());

		Stack<Character> openerStack = new Stack<Character>();

		for (char c : phrase) {
			if (openers.contains(c)) {
				openerStack.push(c);
			} else if (closers.contains(c)) {
				if (openerStack.isEmpty()) {
					return false;
				} else {
					char opener = openerStack.pop();
					if (openersToClosers.get(opener) != c) {
						return false;
					}
				}
			}
		}
		return openerStack.empty();
	}

	public static int[] sortScores(int[] scores, int highestScores) {
		int[] arrayOfScores = new int[highestScores + 1];
		for (int score : scores) {
			arrayOfScores[score]++;
		}

		int[] sortedScores = new int[scores.length];

		int curr = 0;
		for (int score = 0; score <= highestScores; score++) {
			while (arrayOfScores[score] > 0) {
				sortedScores[curr++] = score;
				arrayOfScores[score]--;
			}
		}
		return sortedScores;
	}

	public static void main(String[] args) {
		System.out
				.println(findCloserIndex(
						"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.",
						10));
		
		
		int[] unsortedScores = {37, 89, 41, 65, 91, 53};
		final int HIGHEST_POSSIBLE_SCORE = 100;

		int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
		for(int i=0;i<sortedScores.length;i++){
			System.out.print(sortedScores[i] + " ");
		}
		
		// sortedScores: [37, 41, 53, 65, 89, 91]
	}
}
