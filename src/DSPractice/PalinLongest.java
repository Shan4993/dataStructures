
public class PalinLongest {
	public static void main(String[] args){
		String answer = longestPalin("123234567898768");
		System.out.println(answer);
	}
	
	public static String longestPalin(String str){
		char[] word = str.toCharArray();
		int longestStart=0,longestEnd=0;
		for(int mid = 0;mid<word.length;mid++){
			int left = mid, right = mid;
			
			while(left >= 0 && right < word.length){
				if(word[left] == word[right]){
					if(right-left > longestEnd - longestStart){
						longestStart = left;
						longestEnd = right;
					}
				}else break;
				left--; 
				right++;
			}
			
			left = mid; 
			right = mid+1;
			
			while(left >= 0 && right < word.length){
				if(word[left] == word[right]){
					if(right-left > longestEnd - longestStart){
						longestStart = left;
						longestEnd = right;
					}
				}else break;
				left--; 
				right++;
			}
			
		}
		return str.substring(longestStart,longestEnd+1);
		
	}
}
