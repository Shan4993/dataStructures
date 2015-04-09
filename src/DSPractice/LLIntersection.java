package DSPractice;

public class LLIntersection {
	// Q: Find the intersection of two lists and return that node
	// Source: http://goo.gl/0OgsLX
	// Ex: 10->20->-----
	//                  \
	//                  100->200->300
	//                 /
	// 2->4->6->8->15-

	public static ListNode common(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		else if (l1 == null) return l2;
		else if (l2 == null) return l1;
		else {
			int l1Len = getSize(l1);
			int l2Len = getSize(l2);
			if (l1Len < l2Len) {
				for (int i = 0; i < l2Len - l1Len; i++) {
					l2 = l2.next;
				}
			} else if (l2Len < l1Len) {
				for (int i = 0; i < l1Len - l2Len; i++) {
					l1 = l1.next;
				}
			}
			while (l1 != l2) {
				l1 = l1.next;
				l2 = l2.next;
			}
			return l1;
		}
	}

	private static int getSize(ListNode node) {
		int count = 0;
		ListNode p2 = node;
		while (p2 != null) {
			count++;
			p2 = p2.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode common = new ListNode(100);
		common.next = new ListNode(200);
		common.next.next = new ListNode(300);

		ListNode listOne = new ListNode(10);
		listOne.next = new ListNode(20);
		listOne.next.next = common;

		ListNode listTwo = new ListNode(2);
		listTwo.next = new ListNode(4);
		listTwo.next.next = new ListNode(6);
		listTwo.next.next.next = new ListNode(8);
		listTwo.next.next.next.next = new ListNode(15);
		listTwo.next.next.next.next.next = common;

		ListNode commonNode = common(listOne, listTwo);
		System.out.println("Common node: " + commonNode.data); // prints 100
	}
}
