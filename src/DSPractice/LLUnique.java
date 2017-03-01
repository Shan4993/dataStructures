
public class LLUnique {
	public static void main(String[] args){
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(2);
		h1.next.next = new ListNode(3);
		h1.next.next.next = new ListNode(3);
		h1.next.next.next.next = new ListNode(3); 
		h1.next.next.next.next.next= new ListNode(4);
		h1.next.next.next.next.next.next = new ListNode(5);
		
		h1.print();
		ListNode newh1 = unique(h1);
		newh1.print();
		
		ListNode h3 = new ListNode(1);
		h3.next = new ListNode(2);
		
		h3.print();
		ListNode newh3 = unique(h3);
		newh3.print();
	}
	
	public static ListNode unique(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode p = fake;
		while(p.next != null && p.next.next != null){
			if(p.next.val == p.next.next.val){
				int dup = p.next.val;
				while(p.next != null && p.next.val==dup){
					p.next = p.next.next;
				}
			}else{
				p = p.next;
			}
		}
		
		
		return fake.next;
	}
	
	
}
