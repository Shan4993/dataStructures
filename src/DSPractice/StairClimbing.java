package DSPractice;

public class StairClimbing {
	//Q: You can climb a set of stairs using 1,2,or 3 steps. 
	//   How many different ways can you clim N steps?
	// Source: http://goo.gl/0OgsLX
	
	public static int lessOptWay(int n){
		if(n==0) return 0;
 		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		return lessOptWay(n-1)+lessOptWay(n-2)+lessOptWay(n-3);
	}
	
	public static int ways(int n){
		//if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		
		int[] prev = new int[]{1,2,4}; //also considered the bottom in this bottom-up technique
		int curr = 3;
		while(curr<n){
			int prevTotal = prev[0]+prev[1]+prev[2];
			prev[0]= prev[1];
			prev[1]= prev[2];
			prev[2]= prevTotal;
			n--;
		}
		return prev[2];
	}
	
	public static void main(String[] args){
		System.out.println("Number of ways to climb " +7+ " stairs is " +lessOptWay(7));		
		System.out.println("Number of ways to climb " +7+ " stairs is " +ways(7));
	}
}
