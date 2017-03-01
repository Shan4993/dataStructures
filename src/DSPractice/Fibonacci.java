import java.util.*;


public class Fibonacci { 
	
	public static int nthFib(int n){
		if(n<0) throw new IllegalArgumentException("error");
		if(n == 0 || n == 1) return n;
		int prevPrev = 0;
		int prev = 1;
		int curr = 0;
		
		for(int i=1;i<n;i++){
			curr = prevPrev + prev;
			prevPrev = prev;
			prev = curr;
		}
		return curr;
	}

	public static void main(String[] args){
		System.out.println(nthFib(1)); //1
		System.out.println(nthFib(2)); //1
		System.out.println(nthFib(3)); //2
		System.out.println(nthFib(4)); //3
	}
	
}
