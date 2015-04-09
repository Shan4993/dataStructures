package DSPractice;

public class Intertwine {
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.printList();

		intertwine(head);
		head.printList();
	}

	public static void intertwine(ListNode L) {
		ListNode mid = locateMid(L);
		ListNode firstHalf = L;
		ListNode secondHalf = reverse(mid.next);
		mid.next = null;
		L = stich(firstHalf, secondHalf);
		
	}

	public static ListNode locateMid(ListNode L) { // return head of the second list
		ListNode slow = L;
		ListNode fast = L;
		while (fast.next != null) {
			fast = fast.next;
			while(fast.next != null){
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}

	public static ListNode reverse(ListNode L) { // reverse the second list and returns
											// head
		if (L == null)
			return null;
		if (L.next == null)
			return L;

		ListNode reverseList = reverse(L.next);
		L.next.next = L;
		L.next = null;
		return reverseList;
	}

	public static ListNode stich(ListNode L1, ListNode L2) { // joins the lists together
		ListNode finalList = new ListNode(0);
		ListNode curr = finalList;
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

