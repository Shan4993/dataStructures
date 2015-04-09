package DSPractice;

public class TreeConstruct {
	//Q: Create a tree given its inorder and preorder traversal
	//Source: http://goo.gl/0OgsLX
	public static void main(String[] args) {

		int[] inOrder = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] preOrder = { 5, 2, 1, 3, 4, 7, 6, 8, 9 };

		Tree root = createTree(preOrder, 0, preOrder.length - 1, inOrder, 0,
				inOrder.length - 1);

		
		System.out.print("InOrder: ");
		root.inOrderPrint();
		System.out.print("\nPreOrder: ");
		root.preOrderPrint();
		System.out.println();

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
			if (in[i] == pre[preStart]) {
				inOrderRootInd = i;
				break;
			}
		}
		int leftTreeSize = inOrderRootInd - inStart; // 4-0=4
		// int rightTreeSize = inEnd - inOrderRootInd; // 11-4=7

		Tree root = new Tree(pre[preStart]);
		root.left = createTree(pre, preStart + 1, preStart + leftTreeSize, in,
				inStart, inStart + leftTreeSize - 1);
		root.right = createTree(pre, preStart + leftTreeSize + 1, preEnd, in,
				inStart + leftTreeSize + 1, inEnd);

		return root;
	}

}

class Tree {
	int data;
	Tree left;
	Tree right;

	public Tree(int data) {
		this.data = data;
		left = right = null;
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
