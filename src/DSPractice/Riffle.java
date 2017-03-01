import java.util.*;

public class Riffle {

	
	public static boolean isRiffleShuffle(int[] shuffledDeck, int[] half1, int[] half2){
		int h1Index = 0, h1Max = half1.length-1;
		int h2Index = 0, h2Max = half2.length-1;
		
		for(int i=0 ; i<shuffledDeck.length ; i++){
			int topCard = shuffledDeck[i];
			
			if(h1Index <= h1Max && topCard == half1[h1Index]){
				h1Index++;
			}else if(h2Index <= h2Max && topCard == half2[h2Index]){
				h2Index++;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isRiffle(int[] shuffledDeck, int[] half1, int[] half2){
		
		int half1Index = 0, half2Index = 0;
		
		for(int i=0;i<shuffledDeck.length;i++){
			boolean half1Depleted = half1Index >= half1.length; 
			boolean half2Depleted = half2Index >= half2.length;
			
			if(half1Index == half1.length){
				half1Depleted = true;
			}
			
			if(half2Index == half2.length){
				half2Depleted = true;
			}
			
			int cardOnTopShuffledDeck = shuffledDeck[i];
			
			Integer cardOnTopHalf1 = null; 
			Integer cardOnTopHalf2 = null; 
			
			if(!half1Depleted) cardOnTopHalf1 = half1[half1Index];
			if(!half2Depleted) cardOnTopHalf2 = half2[half2Index];
			
			
			if(!half1Depleted && cardOnTopShuffledDeck == cardOnTopHalf1){
				half1Index++;
			}else if(!half2Depleted && cardOnTopShuffledDeck == cardOnTopHalf2){
				half2Index++;
			} else{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		int[] half1 = new int[]{1,3,5,7,9};
		int[] half2 = new int[]{2,4,6,8,10};
		int[] result = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(isRiffleShuffle(result,half1,half2));
	}
}
