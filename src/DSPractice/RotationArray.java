package DSPractice;

public class RotationArray {
	public static void main(String[] args){
		int[] array1 = {4,5,6,7,8,9,1};
		int[] array2 = {6,7,1,2,3,4,5};
		int[] array3 = {4,5,6,7,8,2,3};
		
		System.out.println("Rotations: " + rotationCount(array1));
		System.out.println("Rotations: " + rotationCount(array2));
		System.out.println("Rotations: " + rotationCount(array3));
		
		
		
	}
	
	public static int rotationCount(int[] arr) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			if (arr[start] < arr[end]) {
				return end + 1;
			} else {
				int mid = (start + end) / 2;
				if (arr[start] <= arr[mid] && 
						arr[mid + 1] <= arr[end]) {
					return mid + 1;
				} else if (arr[start] <= arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
