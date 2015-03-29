package DSPractice;

public class TwoSumPairs {
	//Q: Print all pairs of values in sorted array that sum to m
	// This alg takes linear time and is done in place
	public static void printPairs(int[] arr, int m){
		if(arr.length == 0 || arr.length == 1) return;
		int start = 0;
		int end = arr.length-1;
		while(start<end){
			int total = arr[start]+arr[end];
			if(m > total){
				start++;
			} else if(m < total){
				end--;
			} else{
				System.out.println(start + "--" + end);
				start++;end--;
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
		printPairs(arr,10);
	}
}
