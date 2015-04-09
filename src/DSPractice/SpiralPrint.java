package DSPractice;

public class SpiralPrint {
	// Q: Print array in spiral order
	// Reviewed on GeeksForGeeks
	public static void spiralPrint(int[][] arr) {
		int rowStartInd = 0;
		int rowEndInd = arr.length;
		int colStartInd = 0;
		int colEndInd = arr[0].length;
		int i = 0;

		while (rowStartInd < rowEndInd && colStartInd < colEndInd) {

			// Prints first row of remaining rows
			for (i = colStartInd; i < colEndInd; i++) {
				System.out.print(arr[rowStartInd][i] + " ");
			}
			rowStartInd++;

			// Prints last column of remaining columns
			for (i = rowStartInd; i < rowEndInd; i++) {
				System.out.print(arr[i][colEndInd - 1] + " ");
			}
			colEndInd--;

			// Print last row of remaining rows
			if (rowStartInd < rowEndInd) {
				for (i = colEndInd - 1; i >= colStartInd; i--) { // huh
					System.out.print(arr[rowEndInd - 1][i] + " ");
				}
				rowEndInd--;
			}

			// Print first column of remaining colums
			if (colStartInd < colEndInd) {
				for (i = rowEndInd - 1; i >= rowStartInd; i--) {
					System.out.print(arr[i][colStartInd] + " ");
				}
				colStartInd++;
			}
		}
	}

	public static void main(String[] args) {
		int[][] nxnMatrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		spiralPrint(nxnMatrix);

		System.out.println();

		int[][] mxnMatrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
		spiralPrint(mxnMatrix);
	}
}
