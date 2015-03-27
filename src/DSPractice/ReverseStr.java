package DSPractice;

public class ReverseStr {
	// Q: Reverse word order in a string
	// Ex: Dwyane Wade for MVP -> MVP for Wade Dwyane

	public static String reverseStr(String s) {
		char[] letter = s.toCharArray();

		reverse(letter, 0, letter.length); // At this point, string is
											// backwards
		int end = 0;
		for (int start = 0; start < letter.length; start = end + 1) {
			for (end = start; end < letter.length && letter[end] != ' '; end++) {
			}
			reverse(letter, start, end);
		}
		return new String(letter);
	}

	private static void reverse(char[] letter, int start, int end) {
		for (int i = start, j = end - 1; i < j; i++, j--) {
			char temp = letter[i];
			letter[i] = letter[j];
			letter[j] = temp;
		}
	}

	public static void main(String[] args) {
		String test = new String(
				"Dwyane Wade of the Miami Heat is the greatest");
		System.out.println(test);
		String revString = reverseStr(test);
		System.out.println(revString);

		String test2 = "Testing";
		System.out.println(test2);
		revString = reverseStr(test2);
		System.out.println(revString);
	}
}
