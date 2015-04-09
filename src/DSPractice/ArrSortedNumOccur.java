package DSPractice;

public class ArrSortedNumOccur {
	//Q: Find number of occurances of an element in a sorted array
	//Source: http://goo.gl/0OgsLX	
	
	public static int numOfOccur(int[] arr, int start, int end, int k){
		if(start>end) return 0;
		if(arr[start]>arr[end]) return 0;
		if(k<arr[start]) return 0;
		if(k>arr[end]) return 0;
		if(k == arr[start] && k == arr[end]) return end-start+1;
		
		int mid = (start+end)/2;
		if(k>arr[mid]){ //target is somewhere on the right half
			return numOfOccur(arr,mid+1,end,k);
		} else if(k<arr[mid]){ // target is somewhere on the left half
			return numOfOccur(arr,start,mid-1,k);
		} else{ //found a match, check to the left and right for possible duplicates
			return numOfOccur(arr,start,mid-1,k) + numOfOccur(arr,mid+1,end,k) + 1; // + 1 is for the one just found
		}
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,3,3,4,5,6,7,8,9,9,9,9,9,10,11,12};
		int answer = numOfOccur(arr,0,arr.length-1,9);
		System.out.println(answer);
	}
}
