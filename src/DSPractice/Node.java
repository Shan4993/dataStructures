package DSPractice;

public class Node {

}



class ListNode {
	int data;
	ListNode next;

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

class DLLNode {
	int data;
	DLLNode next;
	DLLNode prev;
	
	public DLLNode(int data){
		this.data = data;
		this.next = this.prev = null;
	}

	public void print(){
		DLLNode p = this;
		while(p.next!=null){
			System.out.print(p.data+"<->");
			p = p.next;
		}
		System.out.println(p.data);
	}
}


class TreeNode<T> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;

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
