package DSPractice;

public class AddLL {
	//adding two numbers represented as LL in reverse and returning result in new list
	//ex: 3->6->8 
	//  + 9->9->2 
	//  = 2->6->1->1 since
	public static void main(String[] args){
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(8);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(2);
		
		ListNode l3 = add(l1,l2);
		ListNode t = l3;
		while(t != null){
			System.out.print(t.data+", ");
			t = t.next;
		}
	}
	
	public static ListNode add(ListNode l1, ListNode l2){
		int val = 0;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode l3 = new ListNode(0);
		ListNode p3 = l3;
		while(p1 != null || p2 != null){
			if(p1 != null){
				val += p1.data;
				p1 = p1.next;
			}
			if(p2 != null){
				val += p2.data;
				p2 = p2.next;				
			}
			p3.next = new ListNode(val%10);
			p3 = p3.next;
			val = val/10;
		}
		if(val==1){
			System.out.println(val);
		}
		return l3.next;
	}
	
}
