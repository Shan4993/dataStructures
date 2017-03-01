
public class AirthSeq {
	//Q: Find missing value in a sequence
	
	public static void main (String[] args){
		int[] arr = new int[]{2,4,6,10,12};
		int ans = findMissing(arr);
		System.out.println("Missing: " + ans);
	}
	
	public static int findMissing(int[] arr){
		//Formula: (n/2 * (a_1 + a_2))
		int n = arr.length;
		int a1 = arr[0];
		int a2 = arr[n-1];
		int total = ((n+1) * (a1 + a2))/2;
		for(int i=0;i<arr.length;i++){
			total -= arr[i];
		}
		return total;
	}
}
