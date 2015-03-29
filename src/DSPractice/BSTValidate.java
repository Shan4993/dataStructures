package DSPractice;

public class BSTValidate {
	//Q: Verify that a tree is a binary search tree
	public static boolean isValid(Tree node, int min, int max){
		if(node == null){
			return true;
		}
		
		if(node.data > max){
			return false;
		} 
		if(node.data < min){
			return false;
		}
		
		return isValid(node.left,min,node.data) && isValid(node.right,node.data,max);
	}
	
	
	
	public static void main(String[] args){
		//		   20
		//    10         30
		//  5    15   25    35
		Tree root = new Tree(20);
		root.left = new Tree(10);
		root.right = new Tree(30);
		root.left.left = new Tree(5);
		root.left.right = new Tree(15);
		root.right.right = new Tree(35);
		root.right.left = new Tree(25);
		
		//		   20
		//    10         50
		//  5    15   25    35
		Tree second = new Tree(20);
		second.left = new Tree(10);
		second.right = new Tree(50);
		second.left.left = new Tree(5);
		second.left.right = new Tree(15);
		second.right.right = new Tree(35);
		second.right.left = new Tree(25);
		
		
		if(isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
			System.out.println("Valid tree");
		} else {
			System.out.println("Not a valid tree");
		}
		if(isValid(second,Integer.MIN_VALUE,Integer.MAX_VALUE)){
			System.out.println("Valid tree");
		} else {
			System.out.println("Not a valid tree");
		}
	}
	
	
	
}
