package DSPractice;

public class Circular {

	public static void main(String[] args) {
		CircularList head = null;
		head = insert(head, 10);
		head.printCircular(); // 10->HEAD
		head.next = new CircularList(20);
		head.next.next = new CircularList(30);
		head.next.next.next = head;
		head.printCircular(); // 10->20->30->HEAD
		head = insert(head, 15); // 10->15->20->30->HEAD
		head.printCircular();
		head = insert(head, 5); // 5->10->15->20->30->HEAD
		head.printCircular();
		head = insert(head, 50); // 5->10->15->20->30->50->HEAD
		head.printCircular();
	}
	
	public static CircularList insert(CircularList head, int val) {
		if (head == null) // no nodes in the list
			return new CircularList(val);
		else if (head.next == head) { // one node in the list 
			head.next = new CircularList(val);
			head.next.next = head;
			return head.data < head.next.data ? head : head.next;
		} else if (val < head.data) { // insert into the beginning 
			CircularList curr = head;
			while (curr.next != head) {
				curr = curr.next;
			}
			curr.next = new CircularList(val);
			curr.next.next = head;
			return curr.next;
		} else { //insert somewhere in list, possibly the end
			CircularList curr = head;
			while (curr.next.data < val && curr.next != head) {
				curr = curr.next;
			}
			CircularList newNode = new CircularList(val);
			newNode.next = curr.next;
			curr.next = newNode;
			return head;
		}
	}
}

class CircularList {
	int data;
	CircularList next;

	public CircularList(int data) {
		this.data = data;
		this.next = this;
	}

	public void printCircular() {
		if (this == null)
			return;
		CircularList curr = this;
		while (curr.next != this) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println(curr.data + "->HEAD..");
		return;
	}
}
