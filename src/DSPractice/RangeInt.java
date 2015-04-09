package DSPractice;

public class RangeInt {
	// Q: Given a sorted array of integers, find the starting
	// and ending position of a given target value.

	//Solution 1
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
	
	//Solution 2
	public static int[] getResults(int[] arr, int k){
	    int[] result = new int[2];
	    int start = getStart(arr,0,arr.length-1,k);
	    int end = getEnd(arr,0,arr.length-1,k);
	    result[0] = start;
	    result[1] = end;
	    return result;    
	}

	public static int getStart(int[] arr, int start, int end, int k){
	    if(start>end) return -1;
	    if(k<arr[start]) return -1;
	    if(k>arr[end]) return -1;
	    if(arr[start] == arr[end] && arr[start] == k) return start;
	    
	    int mid = (start+end)/2;
	    if(arr[mid] > k){
	        return getStart(arr,start,mid-1,k);
	    } else if(arr[mid] < k){
	        return getStart(arr,mid+1,end,k);
	    } else{
	        int pos = getStart(arr,start,mid-1,k);
	        return pos == -1 ? mid:pos ;
	    }
	}

	public static int getEnd(int[] arr, int start, int end, int k){
	    if(start>end) return -1;
	    if(k<arr[start]) return -1;
	    if(k>arr[end]) return -1;
	    if(arr[start] == arr[end] && arr[start] == k) return end;
	    
	    int mid = (start+end)/2;
	    if(arr[mid] > k){
	        return getEnd(arr,start,mid-1,k);
	    } else if(arr[mid] < k){
	        return getEnd(arr,mid+1,end,k);
	    } else{
	        int pos = getEnd(arr,mid+1,end,k);
	        return (pos == -1) ? mid:pos;
	    }
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7,
				8, 9, 9 };
		int[] res = getResults(arr, 4);

		System.out.println("Starting index is at index " + res[0]
				+ " and ending index " + res[1]);
	}

}
