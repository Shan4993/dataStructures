package DSPractice;

public class TreeUnival {
	// Q: Decide if a tree is unival tree (all nodes are the same value)
	// This takes lgn time and is in place

	public static boolean isUnival(Tree root, int val) {
		if (root == null) {
			return true;
		} else if (root.data != val) {
			return false;
		} else {
			return isUnival(root.left, val)
					&& isUnival(root.right, val);
		}
	}

	public static int countUnivalSubtrees(Tree root, Tree parent) {
		if (root == null)
			return 0;

		if (parent != null && root.left != null && root.right != null
				&& root.data != parent.data
				&& root.data == root.left.data
				&& root.data == root.right.data)
			return 1 + countUnivalSubtrees(root.left, root)
					+ countUnivalSubtrees(root.right, root);
		else
			return countUnivalSubtrees(root.left, root)
					+ countUnivalSubtrees(root.right, root);
	}

	public static void main(String[] args) {
		//      10
		//   10   10
		// 10 10 10 10

		Tree root = new Tree(10);
		root.left = new Tree(10);
		root.left.left = new Tree(10);
		root.left.right = new Tree(10);
		root.right = new Tree(10);
		root.right.right = new Tree(10);
		root.right.left = new Tree(10);

		if (isUnival(root, root.data)) {
			System.out.println("Is unival tree");
		}
		
		//         --  1  --
		//        /         \
		//       2           3
		//      / \        /   \
		//    2    2      3     3
		//   / \         / \   / \ 
		//  5   5       3   3 3   3
		
		Tree secondTree = new Tree(1);
		secondTree.left = new Tree(2);
		secondTree.right = new Tree(3);
		secondTree.left.left = new Tree(2);
		secondTree.left.right =  new Tree(2);
		secondTree.right.right = new Tree(3);
		secondTree.right.left =new Tree(3);
		secondTree.left.left.left =new Tree(5);
		secondTree.left.left.right =new Tree(5);
		secondTree.right.left.left =new Tree(3);
		secondTree.right.left.right =new Tree(3);
		secondTree.right.right.left = new Tree(3);
		secondTree.right.right.right = new Tree(3);
		
		
		int answer = countUnivalSubtrees(secondTree,null);    
		System.out.println("Number of unival subtrees: " + answer);
		
	}
}
