package DSPractice;

public class ArrBalPoint {
	//Q: Find the point where the left subarray and right subarray are equal
	//Ex: {2,3,7,10,-5} balance point is 7 because 10 is total on each side


	public static int findBal(int[] arr){
		int[] leftSums = new int[arr.length];
		int[] rightSums = new int[arr.length];
		
		leftSums[0] = arr[0];
		for(int i=1;i<arr.length;i++){
			leftSums[i] = leftSums[i-1]+arr[i];
		}
		rightSums[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--){
			rightSums[i] = rightSums[i+1] + arr[i];
		}
		
		for(int i=0;i<arr.length;i++){
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


