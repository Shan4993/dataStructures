
public class LLReverse {

	
	public static ListNode reverseOutPlace(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode curr = head;
		ListNode newCurr = null, newPrev = null;
		
		while(curr != null){
			newCurr = new ListNode(curr.val);
			newCurr.next = newPrev;
			newPrev = newCurr;
			curr = curr.next;
		}
		return newCurr;
	}
	
	public static ListNode reverseInPlace(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode prevNode = null, curr = head, nextNode = null;
		while(curr != null){
			nextNode = curr.next;
			curr.next = prevNode;
			prevNode = curr;
			curr = nextNode;
		}
		
		return prevNode;
	}
	
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next  = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		
		head.print();
		
		head = reverseInPlace(head);
		
		head.print();
		
		ListNode newList = reverseOutPlace(head);
		
		newList.print();
	}
}
