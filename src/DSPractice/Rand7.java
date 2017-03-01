import java.util.Random;


public class Rand7 {
	//Q: Given a rand5(),write a rand7() method that returns a number 1 through 7 with even distribution
	//Source: interviewcake.com
		
	public static int rand5(){//This function is given
		Random rand = new Random();
		return rand.nextInt(5) + 1;
	}

	
	public static int rand7Naive(){ //with extra space
		int[][] grid = new int[][]{
				{1,2,3,4,5},
				{6,7,1,2,3},
				{4,5,6,7,1},
				{2,3,4,5,6},
				{7,0,0,0,0}	
		};
		
		int potential = 0;
		
		while(potential == 0){
			
			int row = rand5()-1;
			int col = rand5()-1;
			
			potential = grid[row][col];
		}
		
		return potential;
		
	}
	
	
	public static int rand7(){ //no extra space
		while(true){
			int roll1 = rand5();
			int roll2 = rand5();
			
			int possibleOutcome = (roll1-1) * 5 + (roll2-1) + 1;
			
			if(possibleOutcome > 21) continue;
			
			return possibleOutcome % 7 + 1;
		}
	}
	
	public static void main(String args[]){
		for(int i=0;i<20;i++){
			System.out.println(rand7());
		}
	}
}
