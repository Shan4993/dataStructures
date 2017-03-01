
public class LLAdd {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		
		
		ListNode secHead = new ListNode(9);
		secHead.next = new ListNode(9);
		secHead.next.next = new ListNode(9);
		
		ListNode resultList = add(head, secHead);
		head.print();
		secHead.print();
		resultList.print();
		
		
	}
	
	public static ListNode add(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null) return null;
		int value = 0;
		ListNode l3 = new ListNode(-1);
		ListNode p1 = l1, p2 = l2, p3 = l3;
		while(p1 != null || p2 != null){
			if(p1 != null){
				value += p1.val;
				p1 = p1.next;
			}
			
			if(p2 != null){
				value += p2.val;
				p2 = p2.next;
			}
			
			p3.next = new ListNode(value%10);
			
			value = value/10;
			
			p3 = p3.next;
		}
		if(value == 1){
			p3.next = new ListNode(value);
		}
		return l3.next;
		
		
	}
}
