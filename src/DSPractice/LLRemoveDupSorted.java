
public class LLRemoveDupSorted {
	public static void main(String[] args){
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(2);
		h1.next.next = new ListNode(3);
		h1.next.next.next = new ListNode(3);
		h1.next.next.next.next = new ListNode(3); 
		h1.next.next.next.next.next= new ListNode(4);
		h1.next.next.next.next.next.next = new ListNode(5);
		
		h1.print();
		
		ListNode newh1 = removeDups(h1);
		
		newh1.print();
		
		
		ListNode h2 = new ListNode(1);
		h2.next = new ListNode(1);
		h2.next.next = new ListNode(1);
		h2.next.next.next = new ListNode(1);
		h2.next.next.next.next = new ListNode(1); 
		h2.next.next.next.next.next= new ListNode(1);
		h2.next.next.next.next.next.next = new ListNode(1);
		
		h2.print();
		ListNode newh2 = removeDups(h2);
		newh2.print();
		
		ListNode h3 = new ListNode(1);
		h3.next = new ListNode(2);
		
		h3.print();
		ListNode newh3 = removeDups(h3);
		newh3.print();
		
	}
	
	public static ListNode removeDups(ListNode head){
		if(head == null || head.next == null) return null;
		
		ListNode p1 = head, p2 = head.next;
		
		while(p1 != null && p2 != null){
			if(p1.val == p2.val){
				p1.next = p2.next;
				p2 = p1.next;
			}else{
				p1 = p2;
				p2 = p2.next;
			}
		}
		
		
		return head;
	}
}
