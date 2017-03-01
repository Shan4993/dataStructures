
public class Highest3Product {
	//Q: Find the largest product of 3 numbers in an array
	//Can be done in linear time with no extra space
	//Source: Interview cake
	public static int high3Prod(int[] arr){
		int highest = Math.max(arr[0], arr[1]);
		int lowest = Math.min(arr[0], arr[1]);
		
		//set to first 2
		int highestProd2 = arr[0] * arr[1];
		//set to first 2
		int lowestProd2 = arr[0] * arr[1];
		//temp for now
		int highestProd3 = arr[0] * arr[1] * arr[2];
		
		//start from 2nd because we have to manage Prod2's
		for(int i=2;i<arr.length;i++){
			int curr = arr[i];
			
			highestProd3 = Math.max(Math.max(
					highestProd2 *curr, 
					lowestProd2 *curr),
					highestProd3);
			
			highestProd2 = Math.max(Math.max(
					highest * curr, 
					lowest * curr),
					highestProd2);
			
			lowestProd2 = Math.min(Math.min(
					highest * curr, 
					lowest * curr),
					lowestProd2);
			
			highest = Math.max(highest, curr);
			lowest = Math.min(lowest, curr);
			
		}
		
		return highestProd3;
	}
	
	
	public static void main(String[] args){
		int[] arr = new int[]{5,8,2,-5,-10,3,-10};
		System.out.println(high3Prod(arr));
	}

}
