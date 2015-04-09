package DSPractice;

public class ArrBalPoint {
	//Q: Find the point where the left subarray and right subarray are equal
	//Ex: {2,3,7,10,-5} balance point is 7 because 10 is total on each side
	// This would require O(3n) or just O(n) for 3 passes through the array.  Requires additional space of two arrays.
	// Source: http://goo.gl/0OgsLX

	public static int findBal(int[] arr){
		int[] leftSums = new int[arr.length];
		int[] rightSums = new int[arr.length];
		int i=0;
		leftSums[0] = arr[0];
		for(i=1;i<arr.length;i++){//add up values from left side
			leftSums[i] = arr[i] + leftSums[i-1]; 
		}
		rightSums[arr.length-1] = arr[arr.length-1];
		for(i=arr.length-2;i>=0;i--){//add up values from right side
			rightSums[i] += arr[i] + rightSums[i+1];
		}
		
		for(i=0;i<arr.length;i++){//where they match is the balance point
			if(leftSums[i] == rightSums[i]){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,100,10,5};
		int ans = findBal(arr);
		System.out.println("Balance point is at index: " +ans);
	}

}


