import java.io.*;
import java.util.*;

public class MthToLast {

	public static void main(String[] args) throws IOException {
		List<Integer> head = new List<Integer>(1);
		head.next = new List<Integer>(2);
		head.next.next = new List<Integer>(3);
		head.next.next.next = new List<Integer>(4);
		head.next.next.next.next = new List<Integer>(5);
		head.next.next.next.next.next = new List<Integer>(6);
		head.next.next.next.next.next.next = new List<Integer>(7);
		head.next.next.next.next.next.next.next = new List<Integer>(8);
		head.next.next.next.next.next.next.next.next = new List<Integer>(9);
		head.next.next.next.next.next.next.next.next.next = new List<Integer>(10);
		
		int answer = mthToLast(head, 12);
		System.out.println(answer);
		
	
	}
	
	public static int mthToLast(List head, int m){
		if(m<0) return -1;
		List<Integer> p = head;
		List<Integer> p2 = head;
		for(int i=0;i<m;i++){
			if(p2.next != null){
				p2 = p2.next;				
			} else {
				return -1;
			}
		}
		while(p2.next != null){
			p = p.next;
			p2 = p2.next;
		}
		return p.data;
	}
}

class List<T> {
	T data;
	List next;

	public List(T data) {
		this.data = data;
		this.next = null;
	}

	public void printAll() {
		List<T> curr = this;
		while (curr != null) {
			System.out.println(curr.data + ", ");
			curr = curr.next;
		}
	}
}
