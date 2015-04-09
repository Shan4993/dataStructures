package DSPractice;

import java.util.ArrayList;

public class Telephone {
	//Q: Show all string combinations given an input of numbers on a telephone pad
	private static final String[] PHONE = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	
	public static ArrayList<String> combinations(String input){
		ArrayList<String> results = new ArrayList<String>();
		combine("",input,0,results);
		return results;
		
	}

	private static void combine(String prefix, String input, int offset,
			ArrayList<String> results) {
		if(offset >= input.length()){
			results.add(prefix);
			return;
		} else{
			String key = PHONE[input.charAt(offset)-'0'];
			for(int i=0;i<key.length();i++){
				combine(prefix+key.charAt(i),input,offset+1,results);
			}
		}
	}

	public static void main(String[] args){
		ArrayList<String> res = combinations("23");
		for(String str : res){
			System.out.println(str);
		}
	}

}
