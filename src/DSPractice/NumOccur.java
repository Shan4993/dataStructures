package DSPractice;

public class NumOccur {

	public static void main(String[] args) {
		int[] array = new int[]{2, 3, 3, 4, 4, 4, 7, 10, 12, 13, 15, 17, 19 };
		int answer = getOccurrences(3, array, 0, array.length - 1);
		System.out.println("How many \"4\" are there? " + answer);
	}

	public static int getOccurrences(int k, int[] arr, int startIndex,
			int endIndex) {
		if (startIndex > endIndex) return 0;
		if (arr[startIndex] > k) return 0;
		if (arr[endIndex] < k) return 0;
		if (arr[startIndex] == k && arr[endIndex] == k)
			return endIndex - startIndex + 1;

		int midIndex = ((startIndex + endIndex) / 2);
		
		if (arr[midIndex] == k)
			return 1 + getOccurrences(k, arr, startIndex, midIndex - 1)
					+ getOccurrences(k, arr, midIndex +1, endIndex);

		else if (arr[midIndex] < k)
			return getOccurrences(k, arr, midIndex + 1, endIndex);
		else
			return getOccurrences(k, arr, startIndex, midIndex - 1);
	}
}
