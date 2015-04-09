package DSPractice;

import java.util.*;

public class IntegerLargest {
	// Q: Given an integer, return an integer so that it rearranges the digits
	// so the number is large as possible
	// EX: 36519 would return 96531
	// Source: CareerCup
	public static int largestIntt(int n){
	    boolean isNeg = false;
	    if(n>-10 && n<10){//single digit number [-9,9]
	        return n;
	    }
	    if(n<0){ //lets work with positive version, and read in accordingly
	        isNeg = true;
	        n = -n;
	    }
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //map from 0-9
	    while(n>0){
	        int ones = n % 10;
	        n = n / 10;   
	        if(map.containsKey(ones)){
	            int currCount = map.get(ones);
	            map.put(ones,currCount+1);
	        }else{
	            map.put(ones,1);
	        }
	    }//By now, map is loaded, check sign and read out to integer value
	    int ans = 0;
	    if(isNeg){
	        for(int i=0;i<10;i++){
	            if(map.containsKey(i)){
	                int quantity = map.get(i);
	                while(quantity != 0){
	                    ans = ans * 10 + i;
	                    quantity--;
	                }
	            }
	        }
	    }else{
	        for(int i=9;i>=0;i--){
	            if(map.containsKey(i)){
	                int quantity = map.get(i);
	                while(quantity != 0){
	                    ans = ans * 10 + i;                
	                    quantity--;
	                }
	            }
	        }
	    } 
	    return ans;
	}

	public static void main(String[] args) {
		int ans = largestIntt(36519);
		System.out.println(36519 + " -> " + ans);
		 ans = largestIntt(-547696);
		 System.out.println(-547696 + " -> " + ans);
		 ans = largestIntt(3);
		 System.out.println(3 + " -> " + ans);
		 ans = largestIntt(-6);
		 System.out.println(-6 + " -> " + ans);
	}
}
