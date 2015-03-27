package DSPractice;

public class TreeDiameter {
	// Q: Find the diameter of a tree
	//  Longest path either (1) goes through the root, 
	//  (2) is entirely in the left tree, 
	//  or (3) is entirely in the right tree
	public static void main(String[] args) {
		//         10
		//    5         15
		//  3   7    13    20
		// 1 4 6 8  11 14 16 21

		Tree root = new Tree(10);
		root.left = new Tree(5);
		root.left.left = new Tree(3);
		root.left.right = new Tree(7);
		root.right = new Tree(15);
		root.right.right = new Tree(20);
		root.right.left = new Tree(13);
		root.left.left.left = new Tree(1);
		root.left.left.right = new Tree(4);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(8);
		root.right.right.right = new Tree(21);
		root.right.right.left = new Tree(16);
		root.right.left.left = new Tree(11);
		root.right.left.right = new Tree(14);
		
		int diam = getDiameter(root);
		System.out.println("Diameter is: "+ diam);
	}
	
	public static int getDiameter(Tree root){
		if(root == null) return 0;
		else{
			//sum of height of the left tree + height of the right tree + 1 (for the root)
			int rootDiam = getHeight(root.left)+getHeight(root.right)+1;

			int leftDiam = getDiameter(root.left);
			int rightDiam = getDiameter(root.right);
			
			return Math.max(rootDiam, Math.max(leftDiam,rightDiam));
		}
	}
	
	public static int getHeight(Tree root){
		if(root == null) return 0;
		else{
			return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		}
	}
}
