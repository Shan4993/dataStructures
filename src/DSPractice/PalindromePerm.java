import java.util.*;


public class PalindromePerm {
	public static boolean hasPalin(String str){
		Set<Character> set = new HashSet<Character>();
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(set.contains(c)){
				set.remove(c);
			}else{//not in the set, add it
				set.add(c);
			}
		}
		return set.size() <= 1;
	}
	
	public static void main(String[] args){
		System.out.println(hasPalin("civic"));
		System.out.println(hasPalin("ivicc"));
		System.out.println(hasPalin("civil"));
		System.out.println(hasPalin("livci"));
	}
}
