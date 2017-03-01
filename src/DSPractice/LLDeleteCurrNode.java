
public class LLDeleteCurrNode {
	//Q: Delete node of interest in the list, only reference available is the node of interest
	//Source: interviewcake.com
	
	public static void deleteNode(ListNode deleteMe){
		ListNode nextNode = deleteMe.next;
		
		if(nextNode != null){//deleteMe node is not the last one, nextNode could be but doesn't matter for execution purposes
			deleteMe.val = nextNode.val;
			deleteMe.next = nextNode.next;
		}else{//trying to delete last node
			throw new IllegalArgumentException("unable to delete last node with this method");
		}
	}
	
	
	
	public static void main (String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode delete = head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next  = new ListNode(6);
		ListNode end = head.next.next.next.next.next.next   = new ListNode(7);

		head.print();
		
		deleteNode(delete);
		
		head.print();
		
		deleteNode(end); //will error out
	}
	
	
}
