public class Stock {
	public static void main(String[] args) {
		System.out.println(trade(new int[] { 3, 3, 3, 3, 3 }));
		
		System.out.println(trade(new int[] { 10, 7, 5, 3, 1 }));
		
		System.out.println(trade(new int[] { 10, 7, 5, 8, 11, 9 }));
	}

	public static int trade(int[] arr) {
		if (arr.length < 2)
			throw new IllegalArgumentException("Too short input");

		int lowestPrice = arr[0];
		int maxProfit = arr[1] - arr[0];

		for (int i = 1; i < arr.length; i++) {
			int currPrice = arr[i];

			int potentialMax = currPrice - lowestPrice;
			maxProfit = Math.max(maxProfit, potentialMax);
			lowestPrice = Math.min(lowestPrice, currPrice);
		}
		return maxProfit;
	}
}
