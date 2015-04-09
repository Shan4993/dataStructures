package DSPractice;

public class LLMerge {
	// Q: Merge to sorted linked list and return the new list
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			ListNode newList = new ListNode(0);
			ListNode l3 = newList;

			while (l1 != null && l2 != null) {
				if (l1.data < l2.data) {
					l3.next = l1;
					l1 = l1.next;
				} else {
					l3.next = l2;
					l2 = l2.next;
				}
				l3 = l3.next;
			}
			if(l1 != null){ //means l1 is all that is left
				 l3.next = l1;
			} else{ // means l2 is all that is left 
				l3.next = l2;
			}
			return newList.next;
		}
	}

	private static void print(ListNode mergedList) {
		ListNode p = mergedList;
		while(p != null){ 
			System.out.print(p.data + ", ");
			p = p.next;
		}
	}

	
	public static void main(String[] args) {
		// 7->8->11->15->20 merges with 1->2->10->12
		ListNode listOne = new ListNode(7);
		listOne.next = new ListNode(8);
		listOne.next.next = new ListNode(11);
		listOne.next.next.next = new ListNode(15);
		listOne.next.next.next.next = new ListNode(20);
		
		ListNode listTwo = new ListNode(1);
		listTwo.next = new ListNode(2);
		listTwo.next.next = new ListNode(10);
		listTwo.next.next.next = new ListNode(12);

		ListNode mergedList = merge(listOne, listTwo);
		print(mergedList);
	}

}
