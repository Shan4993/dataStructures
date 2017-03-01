
public class MaxSubArray {
	public static void main(String[] args){
		int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));
		
		int[] arr2 = new int[]{1,-2,4,-3,2,-1};
		System.out.println(maxSubArray(arr2));
	}
	
	public static int maxSubArray(int[] arr){
		int max = arr[0];
		int sum[] = new int[arr.length];
		sum[0] = arr[0];
		for(int i=1; i<arr.length ; i++){
			sum[i] = Math.max(arr[i], arr[i] + sum[i-1]);
			max = Math.max(max, sum[i]);
		}	
		return max;
	}
}


