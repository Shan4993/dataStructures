package DSPractice;

public class PrintLevel {
	public static void main(String[] args) {
		// 5
		// 3 7
		// 1 4 6 8
		TreeNode<Integer> head = new TreeNode<Integer>(5);
		head.left = new TreeNode<Integer>(3);
		head.left.left = new TreeNode<Integer>(1);
		head.left.right = new TreeNode<Integer>(4);
		head.right = new TreeNode<Integer>(7);
		head.right.left = new TreeNode<Integer>(6);
		head.right.right = new TreeNode<Integer>(8);

		printTreeLevel(head, 0, 2);
	}

	public static void printTreeLevel(TreeNode<Integer> n, int currLevel, int desireLevel) {
		if (n == null || currLevel > desireLevel)
			return;
		if (currLevel == desireLevel)
			System.out.print(n.data + " ");
		else {
			printTreeLevel(n.left, currLevel + 1, desireLevel);
			printTreeLevel(n.right, currLevel + 1, desireLevel);
		}
	}
}

