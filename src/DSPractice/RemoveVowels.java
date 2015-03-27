package DSPractice;

public class RemoveVowels {
	//Q: Remove vowels in a string
	public static String removeVow(String s){
		char[] letter = s.toCharArray();
		char[] vowel = {'a','e','i','o','u','A','E','I','O','U'};
		boolean[] shouldRemove = new boolean[256];
		for(int i=0;i<vowel.length;i++){
			shouldRemove[vowel[i]] = true;
		}
		int pos=0;
		for(int i=0;i<letter.length;i++){
			if(!shouldRemove[letter[i]]){
				letter[pos++] = letter[i];
			}
		}
		return new String(letter,0,pos);
	}
	
	//Remove one specific value ans return new length of string
	public static int removeElem(int[] arr, int elem){
		int pos = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] != elem){
				arr[pos++] = arr[i]; 
			}
		}
		return pos;
	}
	
	
	public static void main(String[] args){
		String s = "This is the test sentence";
		s = removeVow(s);
		System.out.println(s);
		
		int[] nums = new int[]{0,1,2,3};
		int newLength = removeElem(nums,3);
		System.out.println("New length: " + newLength);
	}
}
