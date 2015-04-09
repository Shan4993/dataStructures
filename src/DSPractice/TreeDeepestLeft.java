package DSPractice;

public class TreeDeepestLeft {
	//Q: Print the deepest left node in a tree
	// This takes lgn time and the space constraint consists of the height of the implicit stack from the recursive calls
	
	private static int deepest = 0;
	private static Tree deepestLeft = null;
	
	public static void deepestNode(Tree node, boolean isLeft, int depth){
		if(depth > deepest && isLeft){
			deepest = depth;
			deepestLeft = node;
		}
		if(node.left != null){
			deepestNode(node.left,true,depth+1);
		}
		if(node.right != null){
			deepestNode(node.right,false,depth+1);
		}
	}
	
	public static void main(String[] args) {
		//        10
		//   4          15
		// 3    7    13    20
        //     6         18
		//    5
		
		Tree root = new Tree(10);
		root.left = new Tree(4);
		root.left.left = new Tree(3);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.left.left = new Tree(5);
		root.right = new Tree(15);
		root.right.right = new Tree(20);
		root.right.right.left = new Tree(18);
		root.right.left = new Tree(13);
		
		deepestNode(root,false,0);
		System.out.print("Deepest left node is " + deepestLeft.data);
	}
}
