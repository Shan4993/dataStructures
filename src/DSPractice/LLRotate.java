package DSPractice;

public class LLRotate {
	//Q: Rotate a linked list by a given number of rotation
	//  Will show left rotations and right rotations separately
	// This is a linear algorithm done in place
	public static ListNode leftRotate(ListNode head, int r){
		ListNode tail = head, p = head;
		int i=1;
		while(tail.next!=null){
			if(i<r){//p will stop before the new head
				p = p.next;
				i++;
			}
			tail = tail.next;
		}
		tail.next = head;
		head = p.next;
		p.next = null;
		return head;
	}
	
	public static ListNode rightRotate(ListNode head, int rot){
	    if(head == null) return null;
	    ListNode newTail = mthToLast(head, rot);
	    ListNode oldTail = newTail;
	    while(oldTail.next != null){
	        oldTail = oldTail.next;
	    }
	    oldTail.next = head;
	    head = newTail.next;
	    newTail.next = null;
	    return head;
	}

	public static ListNode mthToLast(ListNode head, int m){
	    ListNode p = head, p2 = head;
	    int i=0;
	    while(i<m){
	    	p2 = p2.next;
	        i++;
	    }
	    while(p2.next != null){
	        p = p.next;
	        p2 = p2.next;
	    }
	    return p;
	}
	
	public static void print(ListNode head){
		ListNode p = head;
		while(p!= null){
			System.out.print(p.data+"->");
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
		ListNode newList = rightRotate(head,2);
		print(newList);

		System.out.println();
		//1->2->3->4->5->6
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		
		print(node);
		ListNode newHead = leftRotate(node, 2);
		print(newHead);

	}
}
