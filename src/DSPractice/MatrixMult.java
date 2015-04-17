package DSPractice;

public class MatrixMult {
	//Q: Multiply 2 2D arrays.
	// Takes n^3 time and a space requirement is a new matrix

	public static int[][] multiply(int[][] m1, int[][] m2){
		int m1Row = m1.length;
		int m1Col = m1[0].length;
		int m2Row = m2.length;
		int m2Col = m2[0].length;
		
		if(m1Col != m2Row) return null;
		
		int[][] result = new int[m1Row][m2Col];
		
		for(int i=0;i<m1Row;i++){  
			for(int j=0;j<m2Col;j++){ 
				for(int k=0;k<m1Col;k++){ //can also say m2Row since both are same
					result[i][j] += m1[i][k] * m2[k][j]; 
				}
			}
			
		}
		return result;
	}
	
	public static void print(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			System.out.print("{");
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]+",");
			}
			System.out.println("}");
		}
		System.out.println();
	}
	
	public static void main (String[] args){
		int[][] m1 = new int[][]{{1,2,3},
								 {4,5,6}};
		int[][] m2 = new int[][]{{3,1},
								 {5,8},
								 {2,3}};
		
		int[][] result = multiply(m1,m2);
		print(result);
	}
}
