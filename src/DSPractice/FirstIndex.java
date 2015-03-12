package DSPractice;

public class FirstIndex {
	public static void main (String[] args){
		int[] array = new int[]{2, 3, 3, 4, 4, 4, 7, 7, 7, 13, 15, 17, 19 };
		int index = findFirstInd(4, array, 0, array.length-1);
		System.out.println("Index of the first 4: " + index);
	}
	
	public static int findFirstInd(int k, int[] arr, 
			int startInd, int endInd){
		if(endInd < startInd) return -1;
		if(arr[endInd] < k) return -1;
		if(arr[startInd] > k) return -1;
		
		if(arr[startInd] == k) return startInd;
		
		int midInd = (startInd+endInd)/2;
		if(arr[midInd] == k){
			int currInd = findFirstInd(k, arr, startInd, midInd-1);
			return ((currInd == -1)?midInd:currInd);
			
		} else if(arr[midInd] > k)
			return findFirstInd(k, arr, startInd, midInd-1);
		else
			return findFirstInd(k, arr, midInd+1, endInd);
	}
}
