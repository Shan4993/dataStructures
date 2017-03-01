public class PostOrderVerifyTree {
	// Q: Given an array in post-order, verify that it is a valid BST
	// {5, 7, 6, 9, 11, 10, 8} should return true

	public static void main(String[] args) {
		int[] postOrder = new int[] { 5, 7, 6, 9, 11, 10, 8 };
		System.out.println(isBalancedBSTConvertedToPostOrder(postOrder));
		
		postOrder = new int[]{0,2,1,7,9,8,5,12,17,15,25,40,30,20,10};
		System.out.println(isBSTConvertedToPostOrder(postOrder));
		
		
		postOrder = new int[]{2,1,7,8,5,12,15,25,40,30,20,10};
		System.out.println(isBSTConvertedToPostOrder(postOrder));
		
	}

	private static boolean isBalancedBSTConvertedToPostOrder(int[] arr) {

		return isc(arr, 0, arr.length - 2, arr[arr.length - 1]);
	}
	
	private static boolean isBSTConvertedToPostOrder(int[] arr) {

		return isc2(arr, 0, arr.length - 2, arr[arr.length - 1]);
	}

	private static boolean isc(int[] arr, int startInd, int endInd, int rootValue) {
		int mid = (startInd+endInd)/2;
		int endFirstHalf = mid;
		int beginSecHalf = mid+1;
		
		if(startInd >= endInd){
			return true;
		}
		
		int i=startInd, j = beginSecHalf;
		while(i<=endFirstHalf && beginSecHalf<=endInd){
			if(arr[i]< rootValue && arr[j] >= rootValue){
				i++;
				j++;
			}else{
				return false;
			}
		}
		
		return isc(arr,startInd,endFirstHalf-1,arr[endFirstHalf]) && isc(arr,beginSecHalf,endInd-1,arr[endInd]);
	}
	
	private static boolean isc2(int[] arr, int startInd, int endInd, int rootValue) {
		int i=startInd;
		
		if(startInd >= endInd){
			return true;
		}
		
		while(i<=endInd){
			if(arr[i] < rootValue){
				i++;
			}else{
				break;
			}
		}
		
		int j=i;
		
		while(j<=endInd){
			if(arr[j] >= rootValue){
				j++;
			}else{
				return false;
			}
		}
		
		//i is at endind
		
		return isc2(arr,startInd,i-2,arr[i-1]) && isc2(arr,i,endInd-2,arr[endInd]);
		
	}
		

}
