package DSPractice;

import java.util.ArrayList;
import java.util.List;

public class Robot {
	// Q:Count the number of paths a robot can in the top left corner(0,0)
	// can take to get to the bottom right corner(mxn)

	public static int numOfPaths(int m, int n) {
		
		int[][] grid = new int[m][n];
		
		print(grid);
		
		int row, col;
		for (row = 0; row < m; row++) { //initialize first col (first value of each row) to 1 because only one path to get to any of these positions from the start
			grid[row][0] = 1;
		}
		for (col = 0; col < n; col++) { //same reasoning but now applied to the first row
			grid[0][col] = 1;
		}
		for (row = 1; row < m; row++) { //add the value above and to the left to get the number of paths that can get the robot to current position
			for (col = 1; col < n; col++) {
				grid[row][col] = grid[row][col-1] + grid[row-1][col];
			}
		}

		print(grid);
		
		return grid[m-1][n-1]; //this is the las       t value in the grid and represents the number of paths possible to get here
	}

	public static void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static List<String> robotPaths(int m, int n){
		List<String> pathList = new ArrayList<String>();
		getPaths(m,n,1,1,"",pathList);
		return pathList;
	}
	
	public static void getPaths(int m, int n, int row, int col, String path, List<String> pathList){
		path += "(" + row + "," + col + ")"; 
		if(row == m && col == n){
			pathList.add(path);
		} else if(row>m || col>n){ //going off the grid, stop it
			return;
		} else{
			getPaths(m,n,row+1,col,path,pathList);
			getPaths(m,n,row,col+1,path,pathList);
		}
	}
	

	public static void main(String[] args) {
		int ans = numOfPaths(10,5);
		System.out.println();
		System.out.println(ans);
		
		List<String> allPaths = robotPaths(3,3);
		for(String path: allPaths){
			System.out.println(path);
		}
	}
}
