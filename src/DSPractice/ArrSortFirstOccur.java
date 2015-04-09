package DSPractice;

public class ArrSortFirstOccur {
	// Q: Find first occurance of an element in a sorted array that allows duplicatea
	// Requires binary search so time complexity is lgn
	// By using recursion, the extra space is the height of the implicit recursive stack
	
	
	public static int firstIndex(int[] arr, int start, int end, int k) {
		if(start>end) return -1;
		if(k < arr[start]) return -1;
		if(k > arr[end]) return -1;
		if(arr[start] == k) return start;
		
		int mid = (start+end)/2;
		if(k > arr[mid]){ //value is in the right half
			return firstIndex(arr,mid+1,end,k);
		} else if(k < arr[mid]){ //value is on the left side
			return firstIndex(arr,start,mid-1,k);
		} else{ //found it, check before it for a duplicate which may be the true start point
			int possible = firstIndex(arr,start,mid-1,k); 
			return (possible == -1 ? mid : possible);
		}
	}

	

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,2,3,3,3,4,4,5,6,6,7};
		int ans = firstIndex(arr,0,arr.length-1,6);
		System.out.println("First index: " + ans);
	}
}
