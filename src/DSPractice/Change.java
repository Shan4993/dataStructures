
public class Change {
	//Q: How many different ways can you make change with a given set of coin values
	//Answer: Use dynamic programming to create a table of all possible values and return the final value
	//Time complexity is O(n*m) where n is the number of coins and m and is the total amount
	//Source: HackerRank
	
    public static void main(String[] args){
    	int[] arr = new int[]{1,5,10,25};
    	
    	int ans = change(arr,25);
    	System.out.println("Number of ways to make change: " + ans);
    }
	
	public static int change(int[] coin, int total){
        int[][] grid = new int[coin.length+1][total+1];
        for(int i=0;i<coin.length+1;i++){
            grid[i][0] = 1;
        }
        for(int i=1;i<total+1;i++){
            grid[0][i] = 0;
        }
        for(int i=1;i<coin.length+1;i++){
            for(int j=1;j<total+1;j++){
                if(coin[i-1] <= j){
                    grid[i][j] = grid[i-1][j] + grid[i][j-coin[i-1]];
                }else{
                    grid[i][j] = grid[i-1][j];
                }
            }
        }
        
        return grid[coin.length][total];
    }
}
