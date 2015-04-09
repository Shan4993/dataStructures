package DSPractice;

public class Hill {
	// Q: How to find the minimum positive number K 
	//	  for an array to make the array in strictly ascending order
	// Ex: {12,5,2} would yield K=6 since 12-6,5+2,2+6 results in 6,7,8 (array in ascending order)
	// Ex: {10,2,20} would yield K=5 since 10-5,2+5,20-0 result sin 5,7,20 (array in ascending order)
	public static void main(String[] args){
		int[] arr = new int[]{12,5,2,8};
		int ans = solve(arr);
		System.out.println(ans);
	}
	
	public static int solve(int[] arr){
		int k = 0; //assume no change required first;
		int last = arr[0];
		for(int i=1;i<arr.length;i++){
			int possibleMax = arr[i]+k;
			if(last >= possibleMax){ //is the last value truly larger than the possible max of the current value
				int adjust = (last-possibleMax)/2 + 1; //can show this with size 2 array examples
				k += adjust;
				last -= adjust;
				last++;
			}else{
				int possibleMin = arr[i]-k;
				if(last < possibleMin){//is the last value truly smaller then the possible min of the current value
					last = possibleMin;
				}else{
					last++;
				}
			}
		}
		return k;
	}

}
