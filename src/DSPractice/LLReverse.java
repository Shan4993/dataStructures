package DSPractice;

public class LLReverse {
	//Q: Reverse a linked list and return the new head
	public static ListNode reverse(ListNode node){
		
		if(node == null || node.next == null){
			return node;
		}
		
		ListNode remaining = reverse(node.next);

		ListNode p = remaining;
		while(p.next != null){ //have to iterate to the end of remaining
			p = p.next; //this iterates further and further as reverse list grows in size
		}
		
		p.next = node;
		node.next = null;
		return remaining;
	}
	
	private static void print(ListNode head){
		ListNode p = head;
		while(p.next!=null){
			System.out.print(p.data+"->");
			p = p.next;
		}
		System.out.println(p.data);
	}
	
	public static void main(String[] args){
		//1->2->3->4->5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		print(head);
		ListNode newHead = reverse(head);
		print(newHead);
	}
}
