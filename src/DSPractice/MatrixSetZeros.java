
public class MatrixSetZeros {
	//Q: Given a matrix with 1s and 0s, convert a 0 index's entire row and column to 0s
	//Create two arrays to placehold where the 0 occurs and flip them on a second walk through, linear runtime.
	public static void makeZeros(int[][] grid){
		boolean[] row = new boolean[grid.length];
		boolean[] col = new boolean[grid[0].length];
		
		for(int x=0;x<grid.length;x++){
			for(int y=0;y<grid[0].length;y++){
				if(grid[x][y] == 0){
					row[x] = true;
					col[y] = true;
				}
			}
		}
		
		for(int x=0;x<grid.length;x++){
			for(int y=0;y<grid[0].length;y++){
				if(row[x] || col[y]){
					grid[x][y] = 0;
				}
			}
		}
		
		
	}
	
	public static void print(int[][] grid){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				System.out.print(grid[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}

	public static void main (String[] args){
		int[][] grid = new int[][]{
			{1,1,1,1},
			{1,1,1,1},
			{1,0,1,1},
			{1,1,1,1}
		};
		
		print(grid);		
		makeZeros(grid);
		print(grid);
		
	}
}
