import java.util.Random;


public class ParkingCars {
	//Q: A row of cars with n spots where parking spot is vacant. 
	//You can only move one car at a time and it must be to the vacant spot.
	//Given a parking order, output the steps taken to reach the resulting order
	
	//This solution is O(n^2) but it does work for brute force 
	
	public static void moveCars(int[] startSet, int[] resultSet){
		int emptyIndexInStartSet = 0, emptyIndexInResultSet = 0;
		
		//locate empty spots for start and end
		for(int i=0;i<startSet.length;i++){
			if(startSet[i] == -1) emptyIndexInStartSet = i;
			if(resultSet[i] == -1) emptyIndexInResultSet = i;
		}
		
		while(true){
			//empty spots are same, check rest of positions: if they match break out, otherwise my empty spot and keep working
			if(emptyIndexInStartSet == emptyIndexInResultSet){
				
				if(parkingSetsMatch(startSet, resultSet)){
					break;
				}
				
				
				Random ran = new Random();
				int swapWithMyIndex = 0;
				while(swapWithMyIndex == emptyIndexInStartSet){
					swapWithMyIndex = ran.nextInt(startSet.length);
				}
				
				swap(startSet, emptyIndexInStartSet, swapWithMyIndex);
				
				emptyIndexInStartSet = swapWithMyIndex;
				
				
			}else{
				int carThatWantsToEndUpInThisIndex = resultSet[emptyIndexInStartSet];
				
				int indexOfCarinStartSetToSwapWith = 0;
				for(indexOfCarinStartSetToSwapWith = 0; indexOfCarinStartSetToSwapWith<startSet.length;
						indexOfCarinStartSetToSwapWith++){
					if(startSet[indexOfCarinStartSetToSwapWith] == carThatWantsToEndUpInThisIndex){
						break;
					}
				}
				
				swap(startSet, emptyIndexInStartSet, indexOfCarinStartSetToSwapWith);
				
				emptyIndexInStartSet = indexOfCarinStartSetToSwapWith;
				
			}
		}
		
		
	}
	
	private static void swap(int[] startSet, int x,
			int y) {
		int temp = startSet[x];
		startSet[x] = startSet[y];
		startSet[y] = temp;
		
		System.out.println("Swap " + startSet[x] + " with " + startSet[y]);
	}

	private static boolean parkingSetsMatch(int[] startSet, int[] resultSet) {
		for(int i=0;i<startSet.length;i++){
			if(startSet[i] != resultSet[i]) return false;
		}
		return true;
	}

	public static void main(String[] args){
		int[] a = new int[]{0,1,-1,2};
		int[] b = new int[]{2,-1,1,0};
		
		int[] c = new int[]{0,-1,1};
		int[] d = new int[]{1,-1,0};
		
		
		moveCars(a,b);
	}
}
