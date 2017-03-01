public class ArrMerge {
	
	public static int[] mergeArrays(int[] firstArr, int[] secArr) {
		int[] mergedArr = new int[firstArr.length + secArr.length];

		int firstArrIndex = 0, secArrIndex = 0;
		for (int index = 0; index < mergedArr.length; index++) {
			boolean isFirstArrExhausted = firstArrIndex >= firstArr.length;
			boolean isSecArrExhausted = secArrIndex >= secArr.length;
			
			
			
			if(!isFirstArrExhausted && (isSecArrExhausted ||
					firstArr[firstArrIndex] < secArr[secArrIndex])){
				
				mergedArr[index] = firstArr[firstArrIndex++];
			
			}else{
				
				mergedArr[index] = secArr[secArrIndex++];
				
			}
		}

		return mergedArr;
	}

	public static void main(String[] args) {
		int[] shorter = new int[]{1,3,4};
		int[] longer = new int[]{2,5,7,9};

		int[] res = mergeArrays(shorter, longer);
		
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+", ");
		}
	}
}
