package DSPractice;

import java.util.HashMap;

public class LongUniqSubStr {
	//find the the length of the longest unique substring
	//This solution takes linear time and requires a HashMap to keep track of unique chars
	public static void main(String[] args){
		int ans = longestUnqSubStr("abcabcdabcdea");
		System.out.println(ans);
	}

	public static int longestUnqSubStr(String s){
		int longestLen = 0;
		int tempLong = 0;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				int last = map.get(c);
				tempLong = Math.max(tempLong,last+1);
			}else{
				longestLen = Math.max(longestLen,i-tempLong+1);
				map.put(c,i);
			}
		}
		return longestLen;
	}
}
