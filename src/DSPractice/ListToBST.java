package DSPractice;

public class ListToBST {
	private static ListNode h;

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.printList();
		Tree root = sortedListToBST(head);

		
		root.inOrderPrint();
		System.out.println();

		root.preOrderPrint();
		System.out.println();
	}
	
	
	public static Tree sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len-1);
	}

	// get list length
	public static int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		System.out.println("len is " + len);
		return len;
	}

	// build tree bottom-up
	public static Tree sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// mid
		int mid = (start + end) / 2;

		Tree left = sortedListToBST(start, mid - 1);
		Tree root = new Tree(h.data);
		h = h.next;
		Tree right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}
}
