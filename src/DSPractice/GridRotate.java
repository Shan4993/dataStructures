
public class GridRotate {
	public static void main(String[] args){
		int[][] matrix = new int[5][5];
		load(matrix);
		print(matrix);
		rotateClockwise(matrix, 5);
		print(matrix);
	}
	
	
	public static void rotateClockwise(int[][] grid, int n){
		for(int layer=0 ; layer<n/2 ; layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first ; i<last ; i++){
				int offset = i-first;
				
				//save top
				int top = grid[first][i];
				
				//left to top
				grid[first][i] = grid[last-offset][first];
				//bottom to left
				grid[last-offset][first] = grid[last][last-offset];
				//right to bottom
				grid[last][last-offset] = grid[i][last];
				//top to right
				grid[i][last] = top;
			}
		}
	}
	
	public static void load(int[][] grid){
		int counter = 1;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				grid[i][j] = counter++;
			}
		}
	}
	
	public static void print(int[][] grid){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				System.out.print(grid[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();
	}
}
