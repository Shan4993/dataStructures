package DSPractice;

public class RangeInt {
	// Q: Given a sorted array of integers, find the starting
	// and ending position of a given target value.

	public static int[] theRange(int[] arr, int target) {
		int index = binarySearch(arr, 0, arr.length - 1, target);
		int[] result = { -1, -1 };
		if (index != -1) { // this means the target exists, we just have to find
							// how many times
			int left = index;
			int right = index;
			result[0] = left; // these two are just incase it only comes up once
			result[1] = right;
			while ((left = binarySearch(arr, 0, left - 1, target)) != -1) {
				result[0] = left;
			}
			while ((right = binarySearch(arr, right + 1, arr.length - 1, target)) != -1) {
				result[1] = right;
			}
		}
		return result;
	}

	public static int binarySearch(int[] arr, int start, int end, int target) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7,
				8, 9, 9 };
		int[] res = theRange(arr, 3);

		System.out.println("Starting index is at index " + res[0]
				+ " and ending index " + res[1]);

	}

}
