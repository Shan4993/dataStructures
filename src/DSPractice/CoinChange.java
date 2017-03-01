
public class CoinChange {
	public static int numOfWaysNCents(int[] coins, int amount){
		int[] numOfWays = new int[amount+1];
		numOfWays[0] = 1;
		
		for(int coin : coins){
			for(int higherAmt = coin ; higherAmt < numOfWays.length ; higherAmt++){
				int remainingAmt = numOfWays[higherAmt-coin];
				numOfWays[higherAmt] += remainingAmt;
			}
		}
		
		return numOfWays[amount];
	}
	
	public static void main(String[] args){
		int[] coinArr = new int[]{1,2,3};
		int ans = numOfWaysNCents(coinArr, 5);
		System.out.println(ans);
	}
}
