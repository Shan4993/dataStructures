package DSPractice;

public class SwapPairs {
	//Q: Swap pairs in a linked list using no extra space
	//ex: 1->2->3->4  turns into 2->1->4->3
	public static ListNode swapPairs(ListNode head){
		if(head == null || head.next == null){
			return head;
		} else{
			ListNode p = head.next;
			head.next = swapPairs(p.next);
			p.next = head;
			return p;
		}
	}
	
	public static void print(ListNode head){
		ListNode p = head;
		while(p != null){
			System.out.print(p.data + ", ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		//1->2->3->4->5->6 
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		print(head);
		
		ListNode newHead = swapPairs(head);
		print(newHead);
	}
}
