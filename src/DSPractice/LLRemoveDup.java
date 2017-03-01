import java.util.*;


public class LLRemoveDup {
	
	public static void main(String[] args){
		ListNode head = new ListNode(0);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next.next = new ListNode(9);
		
		head.print();
		removeDupNoSpace(head);
		head.print();
		
	}
	
	//uses hashmap so extra space
	public static ListNode removeDupSpace(ListNode head){
		if(head == null || head.next == null) return head;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ListNode fakeHead = new ListNode(-1);
		ListNode prev = fakeHead;
		ListNode p = head;
		while(p!=null){
			if(map.containsKey(p.val)){
				prev.next = p.next;
			}else{
				map.put(p.val, 1);
				prev.next = p;
				prev = p;
			}
			p = p.next;
		}
		return fakeHead.next;
	}
	
	//uses hashset a little so slightly less space
	public static ListNode removeDupLessSpace(ListNode head){
		if(head == null || head.next == null) return head;
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode fakeHead = new ListNode(-1);
		ListNode prev = fakeHead, p = head;
		while(p != null){
			if(set.contains(p.val)){
				prev.next = p.next;
			}else{
				set.add(p.val);
				prev = p;
			}
			
			p = p.next;
		}
		return fakeHead.next;
	}
	
	
	//iterate and check prev portion of list
	//if found dup, then remove the one we are sitting on in curr b tying over
	//this has n^2 runtime 
	public static ListNode removeDupNoSpace(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode curr = head.next, runner = head;
		while(curr != null){
			boolean shouldDelete = false;
			while(runner != curr && !shouldDelete){
				if(runner.val == curr.val){//found a match go delete curr
					shouldDelete = true;
					break;
				}
				runner = runner.next;
			}
			
			if(shouldDelete){//move runner to position and perform deletion
				while(runner.next != curr){
					runner = runner.next;
				}
				runner.next = curr.next;
			}
			
			runner = head;
			curr = curr.next;
		}
		
		return head;
	}
}

