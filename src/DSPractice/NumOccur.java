package DSPractice;

public class NumOccur {

	public static void main(String[] args) {
		int[] array = new int[]{2, 3, 3, 4, 4, 4, 7, 10, 12, 13, 15, 17, 19 };
		int answer = findOccur(array, 0, array.length - 1, 4);
		System.out.println("How many \"4\" are there? " + answer);
	}

	public static int findOccur(int[] arr, int start, int end, int k){
	    if(start>end) return 0;
	    if(k<arr[start]) return 0;
	    if(k>arr[end]) return 0;
	    if(arr[start] == k && arr[end] == k) return end-start+1;
	    
	    int mid = (start+end)/2;
	    
	    if(arr[mid] < k){
	        return findOccur(arr,mid+1,end,k);
	    } else if(arr[mid] > k){
	        return findOccur(arr,start,mid-1,k);
	    } else{
	        return 1 + findOccur(arr,start,mid-1,k) + findOccur(arr,mid+1,end,k);
	    }

	}
}
