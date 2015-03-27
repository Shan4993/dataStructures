package DSPractice;

public class SortArrRotated {
	// Q: Given a target value, search an array that was initially
	// sorted but was rotated at a random position. If it doesnt exist return -1
	public static int search(int[] arr, int start, int end, int target) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[start] < arr[mid]) { // first half is sorted
				if (arr[start] <= target && target < arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else { // second half is sorted
				if (arr[mid + 1] < target && target < arr[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{5,6,7,0,1,2,3,4};
		int answer = search(nums,0,nums.length-1,2);
		System.out.println("Index: " + answer);
	}

}
