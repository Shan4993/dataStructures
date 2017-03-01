import java.util.*;

public class MaxStack {
	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack(){
		stack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}
	
	public int push(int item) {
		stack.push(item);
		if (maxStack.isEmpty() || item >= maxStack.peek()) {
			maxStack.push(item);
		}
		return item;
	}

	public int pop() {
		if (stack.isEmpty()) {
			throw new IllegalArgumentException("error");
		}
		int item = stack.pop();
		if (item == maxStack.peek()) {
			maxStack.pop();
		}
		return item;

	}

	public int getMax() {
		return maxStack.peek();
	}

}



public class Sln(

		//main
		MaxStack ms = new MaxStack();
)