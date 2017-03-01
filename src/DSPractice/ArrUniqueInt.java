import java.util.*;
public class ArrUniqueInt {
	//Q: Array with 2 of each number except one, find the value of the unique number
	//Source: www.careercake.com
	
	
	//this soln is O(n) on time and constand space O(1)
	public static int findUniqueBetter(int[] droneTracker){
		int xOR = droneTracker[0];
		for(int i=1 ; i<droneTracker.length ; i++){
			int currVal = droneTracker[i];
			
			xOR = xOR ^ currVal;
			
		}
		return xOR;
	}
	
	//this soln is O(n) on time and O(n) on space
	public static int findUnique(int[] droneTracker){
		Integer uniqueValue = -1;
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0 ; i<droneTracker.length ; i++){
			int currID = droneTracker[i];
			if(set.contains(currID)){
				set.remove(currID);
			}else{
				set.add(currID);
			}
		}
		
		Iterator iter = set.iterator();
		
		uniqueValue = (Integer) iter.next();
		
		return uniqueValue;
	}
	
	
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,5,4,3,2,1};
		
		System.out.println(findUnique(arr));
		System.out.println(findUniqueBetter(arr));
		
	}
}
