
public class LLRearrange {
	//Q: Rearrange a LL such that the following: {1,2,3,4} would yield: {1,4,2,3}
	//A: This means split the list in half, then reverse the second half, then sew it back into the first half
	
	public static void rearrange(ListNode l1){
		ListNode[] split = split(l1);
		

		
		split[1] = reverse(split[1]);
		
		sew(split);
		
	}
	
	public static ListNode[] split(ListNode l1){
		ListNode p1 = l1, p2 = l1;
		ListNode[] list = new ListNode[2];
		while(p2 != null && p2.next != null && p2.next.next != null){
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		list[1] = p1.next;
		p1.next = null;
		list[0] = l1;
		
		return list;
	}
	
	
	public static ListNode reverse(ListNode l2){
		ListNode pre = l2, curr = l2.next;
		while(curr != null){
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
		l2.next = null;
		return pre;
	}
	
	public static void sew(ListNode[] list){
		ListNode p1 = list[0], p2 = list[1];
		while(p2 != null){
			ListNode t1 = p1.next, t2 = p2.next;
			
			p1.next = p2;
			p2.next = t1;
			
			p1 = t1;
			p2 = t2;
		}
	}
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);

		n1.print();
 
		rearrange(n1);
 
		n1.print();
	}
}
