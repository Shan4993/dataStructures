package DSPractice;

public class RobotPathPrint {
	//Q: Print every path from the top left to the bottom right
	//   a robot can take
	int[][] array;
	int rowCount;
	int colCount;
	
	public RobotPathPrint(int[][] array){
		this.array = array;
		rowCount = array.length;
		colCount = array[0].length;
	}
	
	public void printPath(int currX, int currY, String path){
		if(currX == rowCount-1){
			for(int j=currY;j<colCount;j++){
				path += array[currX][j];
			}
			System.out.println("Path: " + path);
			return;
		}
		if(currY == colCount-1){
			for(int i=currX;i<rowCount;i++){
				path += array[i][currY];
			}
			System.out.println("Path: " + path);
			return;
		}
		path += array[currX][currY];
		printPath(currX+1,currY,path);
		printPath(currX,currY+1,path);
	}
	
	public static void main(String[] args){
		int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		RobotPathPrint rpp = new RobotPathPrint(arr);
		rpp.printPath(0, 0, "");
	}
}
