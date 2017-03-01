
public class ArrRotationWord {
	
	public static int rotationPoint(String[] words){
		int start = 0;
		int end = words.length-1;
		
		String firstWord = words[0];
		
		while(start<end){
			int mid = start + ((end-start)/2);
			
			if(words[mid].compareTo(firstWord) > 0){
				start = mid;
			}else{
				end = mid;
			}
			
			if(start+1 == end){
				break;
			}
		}
		return end;
		
	}
	
	
	public static void main(String[] args){
		String[] words = new String[]{
			    "ptolemaic",
			    "retrograde",
			    "supplant",
			    "undulate",
			    "xenoepist",
			    "asymptote", // <-- rotates here!
			    "babka",
			    "banoffee",
			    "engender",
			    "karpatka",
			    "othellolagkage",
			};
		
		System.out.println(rotationPoint(words));
	}
}
