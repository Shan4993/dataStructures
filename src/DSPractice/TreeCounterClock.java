package DSPractice;

public class TreeCounterClock {
	public static void main(String[] args) {
		//     10
		//   5       15
		// 3   7   13  20

		BinaryTree root = new BinaryTree(10);
		root.left = new BinaryTree(5);
		root.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(7);
		root.right = new BinaryTree(15);
		root.right.right = new BinaryTree(20);
		root.right.left = new BinaryTree(13);

		root.printCounterClock();
	}
}

class BinaryTree {

	public int data;
	public BinaryTree left;
	public BinaryTree right;

	public BinaryTree(int data) {
		this.data = data;
	}

	public void printCounterClock() {
		preOrderOnly();
		inOrderLeavesOnly();
		postOrderOnly();
	}

	private boolean isLeaf() {
		return (this != null) && 
				(this.left == null) && 
				(this.right == null);
	}

	private void preOrderOnly() {
		if (this != null && !isLeaf())
			System.out.print(data + ">");
		if (this.left != null)
			left.preOrderOnly();
	}

	private void inOrderLeavesOnly() {
		if (this == null)
			return;
		if (this.left != null)
			left.inOrderLeavesOnly();
		if (isLeaf())
			System.out.print(data + ">");
		if (this.right != null)
			right.inOrderLeavesOnly();
	}

	private void postOrderOnly() {
		if (this.right != null)
			right.postOrderOnly();
		if (this != null && !isLeaf())
			System.out.print(data + ">");
	}
}
