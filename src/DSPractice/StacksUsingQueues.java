package DSPractice;

import java.util.LinkedList;
import java.util.Queue;

public class StacksUsingQueues {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int n) {
		q1.add(n);
	}

	public int pop() {
		if(q1.isEmpty()){
			return -1;
		}
		if (q2.isEmpty()) {
			while (q1.size() != 1) {
				q2.add(q1.remove());
			}
			int popMe = q1.remove();
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
			return popMe;
		}
		return -1;
	}

	public boolean isEmpty() {
		return (q1.isEmpty() && q2.isEmpty());
	}

	public static void main(String[] args) {
		StacksUsingQueues s = new StacksUsingQueues();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop()); // 3
		s.push(4);
		s.push(5);
		System.out.println(s.pop()); // 5
		System.out.println(s.pop()); // 4
		System.out.println(s.pop()); // 2
		s.push(6);
		System.out.println(s.pop()); // 6
		System.out.println(s.pop()); // 1
		System.out.println(s.pop()); // -1

	}
}
