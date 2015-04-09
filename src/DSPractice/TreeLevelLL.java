package DSPractice;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeLevelLL {
	// Q: Given a tree, create a linked list for each level, and return all LLs
	
	
	public static ArrayList<LinkedList<Tree>> getLists(Tree root){
		if(root == null) return null;
		int level=0;
		ArrayList<LinkedList<Tree>> results = new ArrayList<LinkedList<Tree>>();
		LinkedList<Tree> list = new LinkedList<Tree>();
		list.add(level, root);
		results.add(list);
		while(true){
			list = new LinkedList<Tree>();
			for(int i=0;i<results.get(level).size();i++){
				Tree node = results.get(level).get(i);
				if(node != null){
					if(node.left != null){
						list.add(node.left);
					}
					if(node.right != null){
						list.add(node.right);
					}
				}
			}
			if(list.size()>0){//no empty
				results.add(level+1,list);
			} else{
				break;
			}	
			level++;
		}
		return results;
	}
	
	public static void main(String[] args) {
		//   10
		//  5   15
		// 3 7 13 20

		Tree root = new Tree(10);
		root.left = new Tree(5);
		root.left.left = new Tree(3);
		root.left.right = new Tree(7);
		root.right = new Tree(15);
		root.right.right = new Tree(20);
		root.right.left = new Tree(13);

		ArrayList<LinkedList<Tree>> results = getLists(root);
		for (LinkedList<Tree> list : results) {
			for (Tree node : list) {
				System.out.print(node.data + "->");
			}
			System.out.println();
		}
	}
}
