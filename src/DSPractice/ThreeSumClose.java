package DSPractice;

import java.util.Arrays;

public class ThreeSumClose {
	//Q: Find total of 3 numbers in an array that are closest to a target
	//   (May assume only one soln)
	// Takes n^2 time 
	public static void main(String[] args){
		int[] arr = new int[]{1,2,5,8,15,17,19,-5};
		int answer = closestSum(arr, 16);
		System.out.println(answer);
	}
	
	public static int closestSum(int[] arr, int target){
		if(arr.length < 3) return 0;
		Arrays.sort(arr);
		int closest = Integer.MAX_VALUE;
		for(int i=0 ; i<arr.length ; i++){
			int j = i+1;
			int k = arr.length - 1;
			while(j<k){
				int sum = arr[i]+arr[j]+arr[k];

				if(Math.abs(target-closest) > Math.abs(target-sum)){  //20-10000000000 > 20-10
					closest = sum;
					k--;
				}else{
					j++;
				}
	
			}
		}
		return closest;
	}
}
