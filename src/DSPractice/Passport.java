package DSPractice;

import java.util.HashMap;
import java.util.HashSet;

public class Passport {
	// Q. Given a stack of passports, find out if a given route is possible. 
	// Run time is the height of the implicit stack given the recursive algorithm
	// Space complexitiy requires a hashset that keeps track of already visited airports
	
	public static void main(String[] args) {
		
		// Paths in graph form :
		//       ----- A -----
		//      /      |      \ 
		//     /       |       \
		//    B        C        D
		//   / \      / \      / \
		//  F   E    J   K    M   N

		HashMap<String, String[]> routes = new HashMap<String, String[]>();

		String[] aConnect = { "B", "C", "D" };
		routes.put("A", aConnect);

		String[] bConnect = { "A", "E", "F" };
		routes.put("B", bConnect);

		String[] cConnect = { "A", "J", "K" };
		routes.put("C", cConnect);

		String[] dConnect = { "A", "M", "N" };
		routes.put("D", dConnect);

		String[] fConnect = { "B" };
		routes.put("F", fConnect);

		String[] eConnect = { "B" };
		routes.put("E", eConnect);

		String[] jConnect = { "C" };
		routes.put("J", jConnect);

		String[] kConnect = { "C" };
		routes.put("K", kConnect);

		String[] mConnect = { "D" };
		routes.put("M", mConnect);

		String[] nConnect = { "D" };
		routes.put("N", nConnect);


		if (isValid("A", "N", routes)) {
			System.out.println("Valid connection");
		} else {
			System.out.println("NoT valid connection");
		}

		if (isValid("F", "J", routes)) {
			System.out.println("Valid connection");
		} else {
			System.out.println("Not valid connection");
		}

		if (isValid("A", "Z", routes)) {
			System.out.println("Valid connection");
		} else {
			System.out.println("Not valid connection");
		}

		
		int[][] temp = new int[][]{{1,2,3},
					 			   {4,5,6},
					 			   {7,8,9}};
		System.out.println(temp[1][2]);
	}

	private static HashSet<String> visited = new HashSet<String>();

	public static boolean isValid(String start, String end,
			HashMap<String, String[]> routes) {
		if (start.equals(end)) {
			return true;
		} else {
			String dest[] = routes.get(start);
			visited.add(start);
			for (String airport : dest) {
				if (!visited.contains(airport)) {
					if (isValid(airport, end, routes)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	/*
	 * public static boolean isValid(String start, String end, HashMap<String,
	 * String[]> routes) { if (start.equals(end)) {
	 * System.out.println("WE MADE ITTTTTTTT"); return true; } else { String[]
	 * dest = routes.get(start); visited.add(start); for (int i = 0; i <
	 * dest.length; i++) { if (!visited.contains(dest[i])) {
	 * System.out.println("Checking airport " + dest[i]); if(isValid(dest[i],
	 * end, routes)){ return true; } } } return false; } }
	 */
}
