package DSPractice;

import java.util.Stack;

public class TreeTraversal {
	public static void main(String[] args){
		//      10
		//   5      15
		// 3   7  13  20
		
		Tree root = new Tree(10);
		root.left = new Tree(5);
		root.left.left = new Tree(3);
		root.left.right = new Tree(7);
		root.right = new Tree(15);
		root.right.right = new Tree(20);
		root.right.left = new Tree(13);
		
		
		inOrder(root);
		System.out.println();
		preOrder(root);
	}

	
	public static void inOrder(Tree root) {
		if (root == null)
			return;
		Stack<Tree> stack = new Stack<Tree>();
		Tree curr = root;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				System.out.print(curr.data + ", ");
				curr = curr.right;
			}
		}
	}

	public static void preOrder(Tree root) {
		if (root == null)
			return;
		Stack<Tree> stack = new Stack<Tree>();
		Tree curr = root;
		stack.push(curr);
		while (!stack.isEmpty()) {
			curr = stack.pop();
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
			System.out.print(curr.data + ", ");
		}
	}

}

