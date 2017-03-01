public class SumStringWithNums{
	//Q: Calculate sum of numbers in a string where each char isn't necessarily a number
	//Example: 11aa22bbbb33cc = 66
	//This requires one walk through with no additional space
	public static int findSum(String str){
		char[] arr = str.toCharArray();
		int sum = 0;
		int currNum = 0;
		for(int i=0;i<arr.length;i++){
			if(Character.isDigit(arr[i])){//build up the number
				currNum = (currNum*10) + (int) (arr[i] - '0');
			}else{//add the number in
				sum += currNum;
				currNum = 0;
			}
		}
		
		if(currNum != 0){
			sum += currNum;
		}
		
		return sum;
	}
	
	
	public static void main(String[] args){
		System.out.println("11aa22bbb33cc = " + findSum("11aa22bbb33cc"));
		System.out.println("abcde = " + findSum("abcde"));
		System.out.println("1123 = " + findSum("1123"));
	}
	
}