package DSPractice;

public class RemoveDup {
	//Q: Remove duplicates in a sorted array of int values
	// Takes linear time
	
	public static int[] removeDups(int[] arr){
	    if(arr.length<2) return arr;
	    
	    int pos = 1;
	    for(int i=1;i<arr.length;i++){
	        if(arr[i] != arr[i-1]){
	            arr[pos++] = arr[i];
	        }
	    }
	    int[] result = new int[pos];
	    for(int i=0;i<result.length;i++){
	        result[i] = arr[i];
	    }
	    return result;
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
		
		int[] res = removeDups(arr);
		print(res)	;
	}
}
