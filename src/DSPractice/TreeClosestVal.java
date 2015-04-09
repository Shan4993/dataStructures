package DSPractice;

public class TreeClosestVal {
	// Q: Find closest value to a given number in a BST
	// Source: http://goo.gl/0OgsLX

	public static int getClosestValue(Tree node, int m) {
		int min = minDiff(node, m);
		return m + min;
	}

	public static int minDiff(Tree node, int m) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if (node.data > m) {
			return smallestDiff(node.data - m, minDiff(node.left, m));
		} else { // if(node.data<m)
			return smallestDiff(node.data - m, minDiff(node.right, m));
		}
	}

	public static int smallestDiff(int a, int b) {
		return (Math.abs(a) < Math.abs(b)) ? a : b;
	}

	public static void main(String[] args) {
		//          20
		//    10         30
		//  5    15   25    35
		// 1 6 13 17 22 27 33 37
		Tree root = new Tree(20);
		root.left = new Tree(10);
		root.right = new Tree(30);
		root.left.left = new Tree(5);
		root.left.left.left = new Tree(1);
		root.left.left.right = new Tree(6);
		root.left.right = new Tree(15);
		root.left.right.left = new Tree(13);
		root.left.right.right = new Tree(17);
		root.right.right = new Tree(35);
		root.right.right.left = new Tree(33);
		root.right.right.right = new Tree(37);
		root.right.left = new Tree(25);
		root.right.left.left = new Tree(22);
		root.right.left.right = new Tree(27);

		int answer = getClosestValue(root, 5);
		System.out.println("Closest node to target: " + answer);
	}

}
