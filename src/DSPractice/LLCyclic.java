
public class LLCyclic { 
	
	public static ListNode returnHeadOfCycle(ListNode head){
		ListNode slow=head, fast= head, temp=head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				while(temp != slow){
					temp = temp.next;
					slow = slow.next;
				}
				break;
			}
		}
		return temp;
	}
	
	
	public static boolean isCyclic(ListNode head){
		ListNode slow = head, fast = head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				return true;
			}
		}
		return false;
		
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		
		ListNode secHead = new ListNode(0);
		secHead.next = new ListNode(1);
		secHead.next.next = new ListNode(2);
		secHead.next.next.next = new ListNode(3);
		ListNode thisNode = secHead.next.next.next.next = new ListNode(4);
		secHead.next.next.next.next.next = new ListNode(5);
		secHead.next.next.next.next.next.next = new ListNode(6);
		secHead.next.next.next.next.next.next.next = thisNode;
		
		if(!isCyclic(head)){
			System.out.println("First list is NOT cyclic");
		}
		
		if(isCyclic(secHead)){
			System.out.println("Second list IS cyclic");
		}
		
		
		System.out.println(returnHeadOfCycle(secHead).val);
	}
	
}
