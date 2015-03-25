package DSPractice;

public class AtoI {
	//Convert string to integer and then integer to string
	public static void main(String[] args){
		int intAnswer = strToInt("305");
		System.out.println(intAnswer);
		
		intAnswer = strToInt("-123");
		System.out.println(intAnswer);
		
		intAnswer = strToInt("0");
		System.out.println(intAnswer);
		
		
		String strAnswer = intToStr(100);
		System.out.println(strAnswer);
		
		strAnswer = intToStr(-987);
		System.out.println(strAnswer);
		
		strAnswer = intToStr(0);
		System.out.println(strAnswer);
	}
	
	public static int strToInt(String s){
		int i=0;
		boolean isNeg = false;
		int num = 0;
		if(s.charAt(0) == '-'){
			isNeg = true;
			i++;
		}
		
		while(i<s.length()){
			char c = s.charAt(i);
			num = num * 10;
			num += c - '0';
			i++;
		}
		
		if(isNeg){
			num= -num;
		}
		
		return num;
	}
	
	public static String intToStr(int num){
		if(num == 0){
			return new String("0");
		}
		
		boolean isNeg = false;
		if(num < 0){
			isNeg = true;
			num = -num;
		}
		StringBuffer sb = new StringBuffer();
		char[] temp = new char[11];
		int i=0;
		while(num != 0){
			char c = (char) (num%10 + '0');
			temp[i++] = c;
			num = num/10;
		}
		if(isNeg){
			sb.append('-');
		}
		while(i > 0){
			sb.append(temp[--i]);
		}
		return sb.toString();
	}
}
