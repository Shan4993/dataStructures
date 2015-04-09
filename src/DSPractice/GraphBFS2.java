package DSPractice;

import java.util.*;


public class GraphBFS2 {
	private static Set<String> visited = new HashSet<String>();

	public static void bfs(HashMap<String,String[]> map, String source){
	    Queue<String> q = new LinkedList<String>();
	    q.add(source);
        visited.add(source);
	    String curr;
	    while(!q.isEmpty()){
	        curr = q.poll();
	        String[] neighbors = map.get(curr);
	        for(String n : neighbors){
	        	if(!visited.contains(n)){
	        		q.add(n);
	        		//System.out.println("Adding" + n);
	        		visited.add(n);
	        	}
	        }
	        //System.out.println("Fully added this node's neighbors: " + curr);
	    }    
	}
	
	public static void main(String[] args){
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		map.put("A", new String[]{"B", "C", "D"});
		map.put("B", new String[]{"A", "E", "F"});
		map.put("C", new String[]{"A", "G", "H"});
		map.put("D", new String[]{"A", "I", "J", "K"});
		map.put("E", new String[]{"B"});
		map.put("F", new String[]{"B","G"});
		map.put("G", new String[]{"F", "C"});
		map.put("H", new String[]{"C", "I"});
		map.put("I", new String[]{"D", "H"});
		map.put("J", new String[]{"D"});
		map.put("K", new String[]{"D"});
		
		bfs(map, "A");
	}
}
