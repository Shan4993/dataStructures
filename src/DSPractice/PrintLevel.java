package DSPractice;

public class PrintLevel {
	public static void main(String[] args) {
		// 5
		// 3 7
		// 1 4 6 8
		TreeNode head = new TreeNode(5);
		head.left = new TreeNode(3);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(4);
		head.right = new TreeNode(7);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(8);

		printTreeLevel(head, 0, 2);
	}

	public static void printTreeLevel(TreeNode n, int currLevel, int desireLevel) {
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

