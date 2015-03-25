package DSPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
	//Return list of 3-value-sets where their sum is 0
	//Example: {1,2,-3,4,5,-7,-2} all values that add to 0 
	//	include {1,2,-3},{-3,5,-2},{2,5,-7}
	//Soln takes n^2 time
	
	public static void main(String[] args){
		int[] arr = new int[]{1,2,-3,4,5,-7,-2};

		List<List<Integer>> r = threeSum(arr);
		print(r);
	}
	
	public static List<List<Integer>> threeSum(int[] arr){
		if(arr.length < 3) return null;
		Arrays.sort(arr);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for(int i=0;i<arr.length-2;i++){
			int j = i+1;
			int k = arr.length-1;
			while(j<k){
				int temp = arr[i] + arr[j] + arr[k];
				if(temp == 0){
					results.add(Arrays.asList(arr[i], arr[j], arr[k]));
					j++;k--;
				} else if(temp > 0){
					k--;
				} else{
					j++;
				}
			}
		}
		return results;		
	}
	
	public static void print(List<List<Integer>> result){
		for(int i=0 ; i<result.size() ; i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j).toString() + ", ");
			}
			System.out.println();
		}
	}	
}
