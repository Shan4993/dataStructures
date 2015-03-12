package DSPractice;

public class Intertwine {
	public static void main(String[] args){
		List head = new List(1);
		head.next = new List(2);
		head.next.next = new List(3);
		head.next.next.next = new List(4);
		head.next.next.next.next = new List(5);
		head.printList();

		intertwine(head);
		head.printList();
	}

	public static void intertwine(List L) {
		List mid = locateMid(L);
		List firstHalf = L;
		List secondHalf = reverse(mid.next);
		mid.next = null;
		L = stich(firstHalf, secondHalf);
		
	}

	public static List locateMid(List L) { // return head of the second list
		List slow = L;
		List fast = L;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static List reverse(List L) { // reverse the second list and returns
											// head
		if (L == null)
			return null;
		if (L.next == null)
			return L;

		List reverseList = reverse(L.next);
		L.next.next = L;
		L.next = null;
		return reverseList;
	}

	public static List stich(List L1, List L2) { // joins the lists together
		List finalList = new List(0);
		List curr = finalList;
		int turn = 1;
		while (L1 != null && L2 != null) {
			if (turn == 1) {
				curr.next = L1;
				L1 = L1.next;
				turn = 2;
			} else {
				curr.next = L2;
				L2 = L2.next;
				turn = 1;
			}
			curr = curr.next;
		}

		if (L1 != null) {
			curr.next = L1;
		}

		return finalList.next;
	}
}

class List {
	int data;
	List next;

	public List(int data) {
		this.data = data;
		this.next = null;
	}

	public void printList() {
		if (this != null) {
			List curr = this;
			while (curr != null) {
				System.out.print(curr.data + "->");
				curr = curr.next;
			}
			System.out.println("TAIL");
		}
	}
}
