
public class StringArrRotationPoint {
	//Q: Return rotation point in an array of Strings
	//Source: Interviewcake.com
	
	public static int findRotationPoint(String[] words) {
	    String firstWord = words[0];
	    int floorInd = 0, ceilingInd = words.length-1;
	    
		while(floorInd<ceilingInd){
			int guessInd = floorInd + ((ceilingInd-floorInd)/2);
			if(words[guessInd].compareTo(firstWord) > 0){
				floorInd = guessInd;
			}else{
				ceilingInd = guessInd;
			}
			
			
			if(floorInd+1 == ceilingInd){
				break;
			}
		
		}
		return ceilingInd;
		
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
		
		System.out.println(findRotationPoint(words));
	}
	
}
