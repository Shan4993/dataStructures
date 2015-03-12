package DSPractice;

import java.util.Stack;

import LinkedList.TreeNode;

public class TreeMath {

	public static void main(String[] args){
		TreeNode myTree = new TreeNode("+");
		myTree.left = new TreeNode("*");	myTree.right = new TreeNode("*");
		myTree.left.left = new TreeNode("12");	myTree.left.right = new TreeNode("3");
		myTree.right.left = new TreeNode("4");	myTree.right.right = new TreeNode("5");
		
		solve(myTree);
		
		System.out.println("Answer: " + stack.pop());
	}
	
	private static Stack<Integer> stack = new Stack<Integer>();
	
	public static void solve(TreeNode tree){
		if(tree != null){
			solve(tree.left);
			solve(tree.right);
			if(isOperator((String) tree.data)){
				int b = stack.pop();
				int a = stack.pop();
				char op = ((String) tree.data).charAt(0);
				int tempResult = compute(op, a, b);
				stack.push(tempResult);
			} else{
				stack.push(Integer.parseInt((String) tree.data));
			}
		}
		
		
	}
	
	private static int compute(char op, int a, int b) {
		switch(op){
		
			case '+' : return a+b;
			case '-' : return a-b;
			case '*' : return a*b;
			case '/' : return a/b;
		
		}	
		return -1;
	}

	public static boolean isOperator(String op){
		return op.equals("*") || op.equals("/") || 
				op.equals("-") || op.equals("+");
	}
	
	
	
	

}
