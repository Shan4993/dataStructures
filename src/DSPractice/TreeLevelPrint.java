package DSPractice;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelPrint {
	// Q: Print all nodes a certain level of a tree
	// Source: http://goo.gl/0OgsLX
	
	//Using recursion
	public static void printLevel(Tree node, int currLev, int desireLev){
		
		if(currLev == desireLev){
			System.out.print(node.data + " ");
			return;
		} else{
			printLevel(node.left, currLev+1, desireLev);
			printLevel(node.right, currLev+1, desireLev);
		}
	}
	
	//Using a queue
	public static void printLev(Tree node, int desireLevel){
		if(desireLevel < 0) return;
		Queue<Tree> tree = new LinkedList<Tree>();
		Queue<Integer> level = new LinkedList<Integer>();
		tree.add(node);
		level.add(0);
		while(!tree.isEmpty()){
			Tree t = tree.remove(); //poll is like remove but doesnt throw exception, just return null
			int lev = level.remove();
			if(t == null){
				return;
			}
			else if(lev == desireLevel){
				System.out.print(t.data +" ");
			} else{
				tree.add(t.left); 
				level.add(lev+1);
				tree.add(t.right);
				level.add(lev+1);
			}
			
		}
	}
	
	
	public static void main(String[] args){
		//		    20
		//     10           30
		//  5     15     25     35
		// 1 6  13 17  22 27  33 37
		Tree root = new Tree(20);
		root.left = new Tree(10);
		root.right = new Tree(30);
		root.left.left = new Tree(5);
		root.left.left.left = new Tree(1);
		root.left.left.right = new Tree(6);
		root.left.right = new Tree(15);
		root.left.right.left = new Tree(13);
		root.left.right.right = new Tree(17);
		root.right.right = new Tree(35);
		root.right.right.left = new Tree(33);
		root.right.right.right = new Tree(37);
		root.right.left = new Tree(25);
		root.right.left.left = new Tree(22);
		root.right.left.right = new Tree(27);

		printLevel(root,0,5);
	}
}
