package DSPractice;

public class TreeCommonBSTAnces {
	// Q: Given two nodes, find their common ancestor
	// This can be done in lgn time with no extra space requirement 
	// Source: PIE

	public static Tree findCommon(Tree root, Tree n1, Tree n2) {
		if (root.data > n1.data && root.data > n2.data) {
			return findCommon(root.left, n1, n2);
		} else if (root.data < n1.data && root.data < n2.data) {
			return findCommon(root.right, n1, n2);
		} else {
			return root;
		}
	}

	public static void main(String[] args) {
		// 20
		// 8 22
		// 4 12
		// 10 14

		Tree root = new Tree(20);
		root.left = new Tree(8);
		root.left.left = new Tree(4);
		root.left.right = new Tree(12);
		root.right = new Tree(22);
		root.left.right.left = new Tree(10);
		root.left.right.right = new Tree(14);
		
		Tree common = findCommon(root, root.left.left,root.left.right.right);
		System.out.println("Common node: " + common.data);

	}
}
