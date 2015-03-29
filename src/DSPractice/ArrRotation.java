package DSPractice;

public class ArrRotation {
	//Q: Figure out how many times an array has been rotated 
	//Ex: {4,5,1,2,3} would return 2
	
	public static int findRotation(int[] arr){
		int start = 0;
		int end = arr.length-1;
		while(start<end){
			if(arr[start]<arr[end]){//fully sorted array
				return end+1;
			} else{
				int mid = (start+end)/2;
				if(arr[start]<arr[mid] && arr[mid+1]<arr[end]){
					return mid+1;
				} else if(arr[start]<arr[mid]){//left side is sorted, move to right
					start = mid+1;
				}else{
					end = mid-1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{4,5,1,2,3};
		int ans = findRotation(arr);
		System.out.println("Rotation occured at: " +ans);
	}
}
