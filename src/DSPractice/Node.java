package DSPractice;

public class Node {

}


class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
		left = right = null;
	}

	public TreeNode(String string) {
		// TODO Auto-generated constructor stub
	}

	public void prePrint() {
		if (this != null) {
			System.out.print(data + ",");
			if (left != null) {
				left.prePrint();
			}
			if (right != null) {
				right.prePrint();
			}
		}
	}

	public void inPrint() {
		if (this != null) {
			
			if (left != null) {
				left.inPrint();
			}
			System.out.print(data + ",");

			if (right != null) {
				right.inPrint();
			}
		}

	}

}
