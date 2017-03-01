import java.util.Random;


public class CoinFlip {
	public static int rand2(){
		Random rand = new Random();
		return rand.nextInt(2) + 1; 
	}
	
	
	public static int rand6(){
		while(true){
			int flip1 = rand2()-1;//1
			int flip2 = rand2()-1;//0
			int flip3 = rand2()-1;//1
			
			int result = 0;
			
			result = result | flip1;
			
			flip2 = flip2 << 1;
			
			result = result | flip2;
			
			flip3 = flip3 << 2;
			
			result = result | flip3;
			
			if(result > 6 || result == 0){
				continue;
			}
			return result;
		}
	}
	
	
	public static void main(String[] args){
		int i=0;
		while(i<10){
			System.out.println(rand6());
			i++;
		}
	}
}
