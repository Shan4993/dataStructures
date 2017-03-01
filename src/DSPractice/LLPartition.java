
public class LLPartition {
	public static void main(String[] args){
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(4);
		h1.next.next = new ListNode(3);
		h1.next.next.next = new ListNode(2);
		h1.next.next.next.next = new ListNode(5);
		h1.next.next.next.next.next = new ListNode(2);
		
		
		h1.print();
		ListNode newList = partition(h1, 3);
		h1.print();
	}
	
	
	public static ListNode partition(ListNode head, int num){
		if(head == null || head.next == null) return head;
		ListNode f1 = new ListNode(-1);
		ListNode f2 = new ListNode(-1);
		ListNode p = head, t1 = f1, t2 = f2;
		//weave through
		while(p != null){
			if(p.val < num){
				t1.next = p;
				t1 = p;
				p = p.next;
			}else{
				t2.next = p;
				t2 = p;
				p = p.next;
			}
		}
		
		//reattach lists
		t1.next = null;
		t2.next = null;
		
		t1.next = f2.next;
		
		return f1.next;
	}
}
