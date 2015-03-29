package DSPractice;

public class ArrSortFirstOccur {
	// Q: Find first occurance of an element in a sorted array that allows
	// duplicated
	public static int firstIndex(int[] arr, int start, int end, int k) {
		if(end<start){
			return -1;
		}
		if (arr[start] > arr[end]) {
			return -1;
		}
		if (arr[start] > k) {
			return -1;
		}
		if (arr[end] < k) {
			return -1;
		}
		if (start == end && arr[start] != k) {
			return -1;
		}
		if(arr[start] == k){
			return start;
		}
		int mid = (start+end)/2;
		if(arr[mid] < k){
			return firstIndex(arr,mid+1,end,k);
		} else if(arr[mid]>k){
			return firstIndex(arr,start,mid-1,k);
		} else{
			int possible = firstIndex(arr,start,mid-1,k);
			return (possible == -1 ? mid:possible);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,2,3,3,3,4,4,5,6,6,7};
		int ans = firstIndex(arr,0,arr.length-1,6);
		System.out.println("First index: " + ans);
	}
}
