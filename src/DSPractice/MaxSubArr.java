package DSPractice;

import java.util.Random;

public class MaxSubArr {
	public static void main(String[] args) {
		int[] arr = new int[15];
		Random r = new Random();
		System.out.print("{");
		for (int i = 0; i < 15; i++) {
			arr[i] = r.nextInt(20) - 10;
			System.out.print(arr[i] + ", ");
		}
		System.out.print("}\n");
		int answer = findMaxSub(arr);
		System.out.println(answer);

	}

	public static int findMaxSub(int[] arr) {
		int tempSum = 0;
		int maxSum = 0;

		int tempSumStartInd = 0, maxStartInd = 0, maxEndInd = 0;
		for (int i = 0; i < arr.length; i++) {
			int futureSum = tempSum + arr[i];
			if (futureSum > 0) {
				tempSum = futureSum;
				if (tempSum > maxSum) {
					maxSum = tempSum;
					maxStartInd = tempSumStartInd;
					maxEndInd = i;
				}
			} else {
				tempSum = 0;
				tempSumStartInd = i;
			}
		}
		return maxSum;
	}

}
