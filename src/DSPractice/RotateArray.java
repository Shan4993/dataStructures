package DSPractice;

public class RotateArray {
	// Q: Rotate an array in place
	// Ex: [1,2,3,4,5,6] rotated at 3 would yield [4,5,6,1,2,3]
	// This takes linear time.  We reverse each half then reverse the entire thing
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6};
		alter(arr, 3);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + ", ");
	}
	
	public static void alter(int[] arr, int pos){
	    if(arr.length < pos) return;
	    reverse(arr, 0, pos-1);
	    reverse(arr,pos,arr.length-1);
	    reverse(arr,0,arr.length-1);
	}

	public static void reverse(int[] arr, int start, int end){
	    while(start<end){
	        int temp = arr[start];
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++; end--;
	    }
	}
	
//
//	public static void rotate(int[] arr, int rotate) {
//		if (arr.length == 0 || arr.length == 1)
//			return;
//		int start = 0;
//		int end = arr.length - 1;
//		int firstHalfEnd = end - rotate;
//		int secondHalfStart = firstHalfEnd + 1;
//
//		reverse(arr, start, firstHalfEnd);
//		reverse(arr, secondHalfStart, end);
//
//		reverse(arr, start, end);
//	}
//
//	public static void reverse(int[] arr, int start, int end) {
//		while (start < end) {
//			int temp = arr[start];
//			arr[start] = arr[end];
//			arr[end] = temp;
//			start++;
//			end--;
//		}
//	}

}
