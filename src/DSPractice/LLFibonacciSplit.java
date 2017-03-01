
public class LLFibonacciSplit {
	//Given a list, split it into two such that one holds the fibonacci numbers and the other doesnt;
	//Source: Career Cup
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next  = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next = new ListNode(8);
		
		
		ListNode[] split = new ListNode[2];
		split = splitList(head);
		
		split[0].print();
		split[1].print();
		
	}
	
	public static ListNode[] splitList(ListNode head){
		if(head == null) return null;
		ListNode[] list = new ListNode[2];
		list[0] = new ListNode(-1);
		list[1] = new ListNode(-1);
		ListNode f1 = list[0], n1 = list[1];
		while(head != null){
			if(isFib(head.val)){
				f1.next = head;
				f1 = f1.next;
			}else{
				n1.next = head;
				n1 = n1.next;
			}
			head = head.next;
		}
		f1.next = null; n1.next = null; //cut them off
		
		list[0] = list[0].next;
		list[1] = list[1].next;
		return list;
	}
	
	public static boolean isFib(int n){
		if(n<0) return false;
		int prevPrev=0,prev=1,curr=0;
		while(curr<n){
			curr = prevPrev+prev;
			prevPrev = prev;
			prev = curr;
		}
		return curr == n;
	}
}
