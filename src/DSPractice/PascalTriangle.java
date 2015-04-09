package DSPractice;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	//Q: Print every row up to n of pascal's triangle
	//Source: LeetCode
	
	public static List<List<Integer>> printTriangle(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return triangle;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for(int j=0;j<i+1;j++){//think of first case, it has to run once to get row 1 -> [1]
				if(j==0 || j ==i){ //outer edge, always one
					row.add(1);
				} else{
					row.add(triangle.get(i-1).get(j-1)+
							triangle.get(i-1).get(j));
				}
			}
			triangle.add(row);
		}
		return triangle;
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = printTriangle(10);
		for(List<Integer> row: triangle){
			System.out.print("{");
			for(int num :row){
				System.out.print(num + " ");
			}
			System.out.println("}");
		}
	}
}
