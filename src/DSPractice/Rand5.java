import java.util.*;

public class Rand5 {
	//Q: Given a rand7(),write a rand5() method that returns a number 1 through 5 with even distribution
	//Source: interviewcake.com
	
	
	public static int rand7(){//This function is given
		Random rand = new Random();
		return rand.nextInt(7) + 1;
	}
	
	
	public static int rand5(){
		int result = rand7();
		while(result > 5){
			result = rand7();
		}
		return result;
	}
	
}
