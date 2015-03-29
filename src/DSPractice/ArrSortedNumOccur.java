package DSPractice;

public class ArrSortedNumOccur {
	//Q: Find number of occurances of an element in a sorted array
	public static int numOfOccur(int[] arr, int start, int end, int k){
		if(end<start) return 0;
		if(arr[start] > k) return 0;
		if(arr[end] < k) return 0;
		if(arr[start] == k && arr[end] == k) return end-start+1;
		
		int mid = (start+end)/2;
		if(arr[mid] > k){//somewhere in left subarray
			return numOfOccur(arr,start,mid-1,k);
		} else if(arr[mid] < k){//somewhere in right subarray
			return numOfOccur(arr,mid+1,end,k);
		} else{
			return numOfOccur(arr,start,mid-1,k)+numOfOccur(arr,mid+1,end,k)+1;
		}
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,3,3,4,5,6,7,8,9,9,9,9,9,10,11,12};
		int answer = numOfOccur(arr,0,arr.length-1,9);
		System.out.println(answer);
	}
}
