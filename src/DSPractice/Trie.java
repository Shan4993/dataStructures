import java.util.*;

public class Trie {
	
	private TrieNode root;
	private final char END_OF_WORD_MARKER = '\0';
	
	public boolean checkPresentAndAdd(String str){
		TrieNode curr = root;
		boolean isNewWord = false;
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			
			if(!curr.hasChildNode(c)){
				isNewWord = true;
				curr.makeChildNode(c);
			}
			
			curr.getChildNode(c);
		}
		
		if(!curr.hasChildNode(END_OF_WORD_MARKER)){
			isNewWord = true;
			curr.makeChildNode(END_OF_WORD_MARKER);
		}
		
		return isNewWord;
	}
}

class TrieNode{
	private Map<Character,TrieNode> nodeChildren;
	
	public TrieNode(){
		nodeChildren = new HashMap<Character,TrieNode>();
	}
	
	public boolean hasChildNode(char c){
		return nodeChildren.containsKey(c);
	}
	
	public void makeChildNode(char c){
		nodeChildren.put(c, new TrieNode());
	}
	
	public TrieNode getChildNode(char c){
		return nodeChildren.get(c);
	}
	
}
