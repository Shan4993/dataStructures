import java.util.*;

public class MyQueue {
	java.util.Stack<Integer> s1 = new java.util.Stack<Integer>();
	java.util.Stack<Integer> s2 = new java.util.Stack<Integer>();

	public int dequeue() {
		if(s1.isEmpty() && s2.isEmpty()){
			throw new IllegalArgumentException("blah");
		}else if(!s2.isEmpty()){
			return s2.pop();
		}else{
			while(s1.size() != 1){
				s2.push(s1.pop());
			}
			return s1.pop();
		}
	}

	public void enqueue(int item) {
		s1.push(item);
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue()); // 1
		System.out.println(q.dequeue()); // 2
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue()); // 3
		System.out.println(q.dequeue()); // 4
		System.out.println(q.dequeue()); // 5
		System.out.println(q.dequeue()); // 6

	}
}
