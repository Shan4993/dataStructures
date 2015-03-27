package DSPractice;

public class Subsets {
	// Q: Find all subsets of a set
	// Ex: The set {1,2,3} has subsets {1,2},{1,3},{2,3},{1},{2},{3},{1,2,3}
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };

		printSubset(arr);

		System.out.println("\nSubsets of size 3:");

		printSubsetSizeK(arr, 3);
	}

	public static void printSubsetSizeK(int[] arr, int k) {
		boolean[] ifPrint = new boolean[arr.length];
		printSubset(arr, ifPrint, 0, k);
	}

	public static void printSubset(int[] arr) {
		// Figure out size of all possible subsets and print them in order
		for (int i = 0; i <= arr.length; i++) {
			boolean[] ifPrint = new boolean[arr.length];
			printSubset(arr, ifPrint, 0, i); // addresses each size so single
												// subsets then up from there
		}
	}

	private static void printSubset(int[] arr, boolean[] ifPrint, int start,
			int remain) {
		if (remain == 0) {
			System.out.print("{");
			for (int i = 0; i < ifPrint.length; i++) {
				if (ifPrint[i]) {
					System.out.print(arr[i] + ",");
				}
			}
			System.out.println("}");
		} else {
			for (int i = start; i < arr.length; i++) {
				if (!ifPrint[i]) {
					ifPrint[i] = true;
					printSubset(arr, ifPrint, i + 1, remain - 1);
					ifPrint[i] = false;
				}
			}
		}

	}
}
