package DSPractice;

public class PalinSubString {
	// Q: Find the longest palindrome that is a substring in a given string
	// This takes n^2 time given the need to consider each position as a mid and checking outward.
	// Source: http://goo.gl/0OgsLX
	
	public static String findLongPalin(String s){
	    char[] input = s.toCharArray();
	    int longestStart = 0, longestEnd = 0;
	    for(int mid=0;mid<input.length;mid++){
	        int left = mid;
	        int right = mid;
	        while(left >= 0 && right < input.length){
	            if(input[left] == input[right]){
	                if(right - left > longestEnd - longestStart){
	                    longestStart = left;
	                    longestEnd = right;
	                }
	            } else {
	                break;
	            }
	            left--; right++;
	        }
	        left = mid;
	        right = mid+1;
	        while(left >= 0 && right < input.length){
	            if(input[left] == input[right]){
	                if(right - left > longestEnd - longestStart){
	                    longestStart = left;
	                    longestEnd = right;
	                }
	            } else{
	                break;
	            }
	            left--; right++;
	        }
	    }
	    return s.substring(longestStart,longestEnd+1);
	}

	
	public static void main(String[] args) {
		String longest = findLongPalin("ztgkbaabcbaaekggtv");
		System.out.println(longest);
	}
}
