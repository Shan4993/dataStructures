
public class SumString {
	
	//Q: Calculate sum of all numbers in a string where chars are not all numbers
	//Example: 11aa22bb33cc44dd = 110. Dont use regex or replace
	
	public static void main(String[] args){
		
		int total = sumStrings("11aa22bb33cc44dd");
		System.out.println("Total: " + total);
		
		total = sumStrings("112");
		System.out.println("Total: " + total);
		
		total = sumStrings("aaa");
		System.out.println("Total: " + total);
		
		total = sumStrings("AFvrst24gskj45");
		System.out.println("Total: " + total);
	}
	
	public static int sumStrings(String s){
		int sum = 0, currNum = 0;
		for(int i=0;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				currNum = currNum*10 + (s.charAt(i) - '0');
			}else{
				sum += currNum;
				currNum = 0;
			}
		}
		return sum + currNum;
	}
}
