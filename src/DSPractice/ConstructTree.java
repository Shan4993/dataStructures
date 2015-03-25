package DSPractice;

public class ConstructTree {

	public static void main(String[] args) {

		int[] preOrder = { 5,2,1,3,4,7,6,8,9 };
		int[] inOrder = { 1,2,3,4,5,6,7,8,9 };

		Tree root = createTree(preOrder, 0, preOrder.length - 1, inOrder, 0,
				inOrder.length - 1);

		System.out.print("InOrder: ");
		root.inOrderPrint();
		System.out.print("\nPreOrder: ");
		root.preOrderPrint();
		System.out.println();
		
		Tree temp = findDeepestLeft(root, false, 0);
		System.out.println("Value is: " + temp.data);
		
		flatten(root);
		Tree p = root;
		while(p != null){
			System.out.print(p.data + " ! ");
			p = p.right;
		}
			
		
	}
	
	public static void flatten(Tree root) {
	    Tree node = root;
	    while (node != null) {
	        if (node.left != null) {
	            Tree temp = node.left;
	            while (temp.right != null)
	                temp = temp.right;
	            temp.right = node.right;
	            node.right = node.left;
	            node.left = null;
	        }
	        node = node.right;
	    }
	}

	// pre array first value is the root
	// after finding this value in the in array
	// create left tree with everything left of the in array
	// create right tree with everything right of the in array

	public static Tree createTree(int[] pre, int preStart, int preEnd,
			int[] in, int inStart, int inEnd) {
		if (preStart > preEnd)
			return null;
		if (preStart == preEnd)
			return new Tree(pre[preStart]);

		int inOrderRootInd = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (pre[preStart] == in[i]) {
				inOrderRootInd = i;
				break;
			}
		}
		int leftTreeSize = inOrderRootInd - inStart; // 4-0=4
		//int rightTreeSize = inEnd - inOrderRootInd; // 11-4=7

		Tree root = new Tree(pre[preStart]);
		root.left = createTree(pre, preStart + 1, preStart + leftTreeSize, in,
				inStart, inStart + inOrderRootInd - 1);
		root.right = createTree(pre, preStart + leftTreeSize + 1, preEnd, in,
				inStart + leftTreeSize + 1, inEnd);

		return root;
	}

	static int deepestDepth = 0;
	static Tree deepestNode = null;

	public static Tree findDeepestLeft(Tree root, boolean isLeft, 
			int depth) {
		if (depth > deepestDepth) {
			deepestNode = root;
			deepestDepth = depth;
		}
		if (root.left != null) {
			findDeepestLeft(root.left, true, depth + 1);
		}
		if (root.right != null) {
			findDeepestLeft(root.right, false, depth + 1);
		}
		return deepestNode;
	}

}

class Tree {
	int data;
	Tree left;
	Tree right;

	public Tree(int data) {
		this.data = data;
		// left = right = null;
	}

	public void inOrderPrint() {
		if (this != null) {
			if (left != null)
				left.inOrderPrint();
			System.out.print(data + ", ");
			if (right != null)
				right.inOrderPrint();
		}
	}

	public void preOrderPrint() {
		if (this != null) {
			System.out.print(data + ", ");
			if (left != null)
				left.preOrderPrint();
			if (right != null)
				right.preOrderPrint();
		}
	}
}
