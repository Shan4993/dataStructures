package DSPractice;

import java.util.Stack;

public class QueueUsingStacks {
	//Q: Implement a Queue using Stacks 
	// (enqueue, dequeue, isEmpty, peek)
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	
	public void enqueue(int n){
		s1.push(n);
	}
	
	public int dequeue(){
		if(s1.isEmpty() && s2.isEmpty()){
			return -1;
		} else if(!s2.isEmpty()){
			return s2.pop();
		} else{
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			return s2.pop();
		}
	}
	
	public boolean isEmpty(){
		return (s1.isEmpty() && s2.isEmpty());
	}
	
	
	public static void main(String[] args){
		QueueUsingStacks q = new QueueUsingStacks();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue()); //1
		System.out.println(q.dequeue()); //2
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue()); //3
		System.out.println(q.dequeue()); //4
		System.out.println(q.dequeue()); //5
		System.out.println(q.dequeue()); //6
		
	}
	
}
