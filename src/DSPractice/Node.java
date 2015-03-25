package DSPractice;

public class Node {

}

class ListNode {
	int data;
	ListNode next;
	
	public ListNode(){
	}

	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}

	public void printList() {
		if (this != null) {
			ListNode curr = this;
			while (curr != null) {
				System.out.print(curr.data + "->");
				curr = curr.next;
			}
			System.out.println("TAIL");
		}
	}
}


class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
		left = right = null;
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
