
public class LLOddEven {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5); 
		
		head.print();
		
		ListNode newList = oddEvenList(head);
		
		newList.print();
	}
	
	public static ListNode oddEvenList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode p1 = head, p2 = head.next;
		ListNode evenHead = p2;
		while(p1 != null && p2 != null){
			ListNode t = p2.next;
			
			p1.next = p2.next;
			p1 = p1.next;
			
			p2.next = p1.next;
			p2 = p2.next;
		}
		p1.next = evenHead;
		return head;
	}
	
}
