public class MergeSortLL {
    public static void main(String[] args){
    	
    }
	
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int len = getLen(head);
        ListNode p = head, secondHead = null;
        for(int i=1;i<len/2;i++){
            p = p.next;
        }
        secondHead = p.next;
        p.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(secondHead);
        
        return merge(l1,l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(0), p3 = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p3.next = l1;
                l1 = l1.next;
            }else{
                p3.next = l2;
                l2 = l2.next;
            }
            p3 = p3.next;
        }
        if(l1 != null){
            p3.next = l1;
        }
        if(l2 != null){
            p3.next = l2;
        }
        return l3.next;
    }
    
    public int getLen(ListNode l){
        int counter=0;
        ListNode p = l;
        while(p != null){
            counter++;
            p = p.next;
        }
        return counter;
    }

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public void print(){
		ListNode p = this;
		while(p!=null){
			System.out.print(p.val + " ");
			p=p.next;
		}
		System.out.println();
	}
}

