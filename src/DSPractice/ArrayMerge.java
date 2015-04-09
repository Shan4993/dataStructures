package DSPractice;

public class ArrayMerge {
	//Q: Merge a shorter sorted array into a larger sorted array(extra space at end) and return a sorted array
	//Source: Source: http://goo.gl/0OgsLX
	//Completed in linear time, requiring no extra space
	public static void main(String[] args) {
		int[] longArr = {4,5,6,7,8,0,0,0};
		int[] shortArr = {1,2,3};
		int used = 5;
		int[] newArr = mergeSortedArr(longArr, shortArr, used);
		System.out.print("{");
		for(int i: newArr)
			System.out.print(i + ", ");
		System.out.print("}");
	}
	
	public static int[] mergeSortedArr(int[] longArr, int[] shortArr, int longUsed){
		int longTail = longUsed-1;
		int shortTail = shortArr.length-1;
		int insertInd = longArr.length-1;
		
		while(longTail >= 0 && shortTail >= 0){
			if(longArr[longTail]>shortArr[shortTail]){//long is bigger, put it to back
				longArr[insertInd] = longArr[longTail];
				longTail--;
			} else{//short arr value is bigger, put it to back
				longArr[insertInd] = shortArr[shortTail];
				shortTail--;
			}
			insertInd--;
		}
		while(shortTail >= 0){//only need to check small array, because if large isnt empty then we can just return it
			longArr[insertInd--] = shortArr[shortTail--];
		}
		return longArr;
	}
}
