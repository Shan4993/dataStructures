package DSPractice;

public class RemoveDup {

	public static int removeDup(int[] arr){
		if(arr.length < 2) return arr.length;
		int pos = 1;
		for(int i=1;i<arr.length;i++){
			if(arr[i] != arr[i-1]){
				arr[pos++] = arr[i];
			}
		}
		return pos;
		
	}
	
	public static void print(int[] arr){
		for(int num: arr){
			System.out.print(num + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,2,3,4,4,4,5,6,7,7,8};
		print(arr);
		int size = removeDup
				(arr);
		System.out.println("Size: " + size);
		print(arr);
	}
}
