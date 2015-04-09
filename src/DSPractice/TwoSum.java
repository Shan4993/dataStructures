package DSPractice;

import java.util.HashMap;

public class TwoSum {
	//Q: Given unsorted array, find two values that sum to a certain value (the pair may not exist)
	
	public static int[] twoSum(int[] arr, int target){
		if(arr.length < 2) return null;
		int[] result = new int[2];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				result[0] = map.get(arr[i]);
				result[1] = i;
				return result;
			} else{
				map.put(target-arr[i], i);
			}
		}
		return null;
	}
	
	
	public static void main(String[] args){
		int[] arr = new int[]{3,8,5,2,9}; //find 10
		int[] index = twoSum(arr,10);
		System.out.println("Index: " +index[0]+ " and " +index[1]);
	}
}
