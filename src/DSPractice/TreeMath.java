package DSPractice;

import java.util.Stack;

public class TreeMath {

	public static void main(String[] args){
		TreeNode<String> myTree = new TreeNode<String>("+");
		myTree.left = new TreeNode<String>("*");  myTree.right = new TreeNode<String>("*");
		myTree.left.left = new TreeNode<String>("12");	myTree.left.right = new TreeNode<String>("3");
		myTree.right.left = new TreeNode<String>("4");	myTree.right.right = new TreeNode<String>("5");
		
		solve(myTree);
		
		System.out.println("Answer: " + stack.pop());
	}
	
	private static Stack<Integer> stack = new Stack<Integer>();
	
	public static void solve(TreeNode<String> tree){
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
