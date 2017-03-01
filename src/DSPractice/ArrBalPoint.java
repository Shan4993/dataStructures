public class ArrBalPoint {
	// Q: Find the point where the left subarray and right subarray are equal
	// Ex: {2,3,7,10,-5} balance point is 7 because 10 is total on each side
	// This would require O(3n) or just O(n) for 3 passes through the array.
	// Requires additional space of two arrays.
	// Source: http://goo.gl/0OgsLX
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {2, 2, 3, 7, 10, -5 ,2};
		int index = findBalIndex(arr);
		if (index == -1) {
			System.out.println("No balance");
		}
		System.out.println("Index: " + index);
		System.out.println("Value: " + arr[index]);
	}

	
	public static int findBalIndex(int[] arr) {
		// create leftArr then rightArr
		// who ever is higher adds the next one towards the middle
		// if either hits goes over, no balance
		int[] leftArr = new int[arr.length];
		int[] rightArr = new int[arr.length];

		leftArr[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			leftArr[i] = arr[i] + leftArr[i - 1];
		}
		rightArr[arr.length - 1] = arr[arr.length - 1];

		for (int j = arr.length - 2; j >= 0; j--) {
			rightArr[j] = arr[j] + rightArr[j + 1];

		}
		for (int k = 0; k < arr.length; k++) {
			if (leftArr[k] == rightArr[k]) {
				return k;
			}
		}

		return -1;
	}
}
