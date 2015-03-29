package DSPractice;

public class ArrayMerge {
	public static void main(String[] args) {
		int[] longArr = {4,5,6,7,8,0,0,0};
		int[] shortArr = {1,2,3};
		int used = 5;
		int[] newArr = mergeTwoSortArrays(longArr, shortArr, used);
		System.out.print("{");
		for(int i: newArr)
			System.out.print(i + ", ");
		System.out.print("}");
	}
	
	
	public static int[] mergeTwoSortArrays(int[] longArr, int[] shortArr,
			int longUsed) {
		int longTail = longUsed - 1;
		int shortTail = shortArr.length - 1;

		while (longTail >= 0 && shortTail >= 0) {
			if (longArr[longTail] > shortArr[shortTail]) {
				longArr[longTail + shortTail + 1] = longArr[longTail];
				longTail--;
			} else {
				longArr[longTail + shortTail + 1] = shortArr[shortTail];
				shortTail--;
			}
		}
		while (shortTail >= 0) {
			longArr[shortTail] = shortArr[shortTail];
			shortTail--;
		}
		return longArr;
	}

}
