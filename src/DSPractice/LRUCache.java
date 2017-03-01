import java.util.HashMap;


public class LRUCache {
	int capacity;
	HashMap<Integer, DListNode> map = new HashMap<Integer, DListNode>();
	DListNode head=null, tail=null;
	
	public LRUCache(int cap){
		this.capacity = cap;
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			DListNode node = map.get(key);
			remove(node);
			setHead(node);
			return node.val;
		}
		return -1;
	}
	
	public void set(int key, int val){
		if(map.containsKey(key)){
			DListNode old = map.get(key);
			old.val = val;
			remove(old);
			setHead(old);
		}else{
			DListNode created = new DListNode(key, val);
			//is the cache full?
			if(map.size() >= capacity){
				map.remove(tail.key);
				remove(tail);
				setHead(created);
			}else{
				setHead(created);
			}
			map.put(key, created);
		}
	}
	
	
	
	private void setHead(DListNode node) {
		node.next = head;
		node.prev = null;
		
		if(head != null){
			head.prev = node;
		}
		
		head = node;
		
		if(tail == null){
			tail = head;
		}
		
	}

	private void remove(DListNode node) {
		if(node.prev != null){
			node.prev.next = node.next;
		}else{//is head
			head = node.next;
		}
		
		if(node.next != null){
			node.next.prev = node.prev;
		}else{
			tail = node.prev;
		}
	}

	public static void main(String[] args){
		
		LRUCache lru = new LRUCache(3);
		
		lru.set(1, 10);
		lru.set(2, 20);
		lru.set(3, 30);
		
		lru.head.print();
		
		lru.set(4, 40);
		
		lru.head.print();
		
		lru.get(3);

		lru.set(5, 50);
		
		lru.head.print();
		
	}
	
}

class DListNode{
	int key, val;
	DListNode prev, next;
	
	public DListNode(int key, int val){
		this.key = key;
		this.val = val;
		this.prev = null;
		this.next = null;
	}
	
	public void print(){
		DListNode p = this;
		while(p != null){
			System.out.print(p.val);
			if(p.next != null){
				System.out.print("<->");
			}
			p = p.next;
		}
		System.out.println();
	}
	
}