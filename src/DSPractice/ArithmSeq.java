package DSPractice;

public class ArithmSeq {
	//Q: Find the missing term in a arithmetic sequence
	//Source: HackerRank
	
	public static int findMissing(int[] arr, int size) {
		//Formula: (n/2 * (a_1 + a_2))
		int total = ((size+1)*(arr[0]+arr[arr.length-1]))/2; //Be sure to account for plus 1 value because it is missing

		for(int i=0;i<arr.length;i++){
			System.out.println(total);
			total -= arr[i];
		}
		return total;
	}
	
	
	public static void main(String[] args){
		int[] arr = new int[]{2,4,6,10,12,14};
		int missing = findMissing(arr,arr.length);
		System.out.println("Missing value:" + missing);
	}

}
