package DSPractice;

public class MajorityArr {
	//Q: Find the majority element in array. 
	// Majority element is the one that appears 50% or more
	
	public static int findMajor(int[] arr){
		int major = arr[0];
		int count = 1;
		for(int i=0;i<arr.length;i++){
			if(count == 0){
				major = arr[i];
				count++;
			} else if(arr[i] == major){
				count++;
			} else{
				count--;
			}
		}
		return major;
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,3,5,3,3,4,3,2};
		System.out.println("The majority element was " + findMajor(arr));
	}
}
