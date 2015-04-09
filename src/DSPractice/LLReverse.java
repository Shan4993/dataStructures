package DSPractice;

public class LLReverse {
	//Q: Reverse a linked list and return the new head
	// Source: http://goo.gl/0OgsLX
	
	public static ListNode rev(ListNode head){
		ListNode back = null;
		ListNode curr = head.next;
		while(curr != null){
			head.next = back;
			back = head;
			if(curr != null){
				head = curr;
			}
			curr = curr.next;
		}
		head.next = back;
		return head;
	}
	
	public static ListNode reverse(ListNode node){	
		if(node == null || node.next == null){
			return node;
		}

		ListNode remaining = reverse(node.next);
		node.next.next = node;
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
		ListNode newestHead = rev(newHead);
		print(newestHead);
	}
}
