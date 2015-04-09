package DSPractice;

import java.util.Random;

public class MaxSubArr {
	//Q: Find max value subarray. 
	// This can be done in linear time
	public static void main(String[] args) {
		int[] arr = new int[15];
		Random r = new Random();
		System.out.print("{");
		for (int i = 0; i < 15; i++) {
			arr[i] = r.nextInt(20) - 10;
			System.out.print(arr[i] + ", ");
		}
		System.out.print("}\n");
		int answer = findMax(arr);
		System.out.println(answer);

	}
	
	public static int findMax(int[] arr){ //Kadane's Algorithm
	    int maxEndingHere = 0, maxSoFar = 0;
	    for(int i=0;i<arr.length;i++){
	        maxEndingHere += arr[i];
	        if(maxEndingHere < 0){
	            maxEndingHere = 0;
	        } 
	        if(maxSoFar<maxEndingHere){
	            maxSoFar = maxEndingHere;
	        }
	    }
	    return maxSoFar;
	}

}
