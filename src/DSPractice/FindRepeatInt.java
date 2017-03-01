
public class FindRepeatInt {

	public static int findRepeat(int[] arr){
		
		
		int needleFloor = 1;
		int needleCeiling = arr.length-1;
		
		while(needleFloor < needleCeiling){
			int midPoint = needleFloor + ((needleCeiling-needleFloor)/2);
			int lowerRangeFloor = needleFloor;
			int lowerRangeCeiling = midPoint;
			int upperRangeFloor = midPoint+1;
			int upperRangeCeiling = needleCeiling;
			
			//count number of items in lower range
			int numOfItemsInLowerRange = 0;
			for(int item : arr){
				if(item>=lowerRangeFloor && item<=lowerRangeCeiling){
					numOfItemsInLowerRange++;
				}
			}
			
			
			
			int numOfDistinctItemsInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;
			
			System.out.println(numOfItemsInLowerRange + " " + numOfDistinctItemsInLowerRange);
			
			if(numOfItemsInLowerRange > numOfDistinctItemsInLowerRange){ //dup is in the lower range
				needleFloor = lowerRangeFloor;
				needleCeiling = lowerRangeCeiling;
				
			}else{
				needleFloor = upperRangeFloor;
				needleCeiling = upperRangeCeiling;
			}
		}
		return needleFloor;
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,7,7,8,9,10};
		
		int[] arr2 = new int[]{1,1,2};
		System.out.println(findRepeat(arr2));
	}
}
