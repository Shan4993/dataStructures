package DSPractice;

public class RotateArray {
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6};
		rotate(arr, 3);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + ", ");
	}

	public static void rotate(int[] arr, int rotate) {
		if (arr.length == 0 || arr.length == 1)
			return;
		int start = 0;
		int end = arr.length - 1;
		int firstHalfEnd = end - rotate;
		int secondHalfStart = firstHalfEnd + 1;

		reverse(arr, start, firstHalfEnd);
		reverse(arr, secondHalfStart, end);

		reverse(arr, start, end);
	}

	public static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

}
