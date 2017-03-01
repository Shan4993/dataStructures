import java.util.*;

public class SetOfStacks {
	private int capacity;
	private ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	
	public SetOfStacks(int c){
		this.capacity = c;
		stacks.add(new Stack<Integer>()); //without this, our first push would error because we need a stack in our stack list
	}
	
	public void push(int item){
		Stack<Integer> stack = getLastStack();
		if(!atCapacity(stack)){
			stack.push(item);
		}else{//create new
			java.util.Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(item);
			stacks.add(newStack);
		}
	}
	
	public Stack<Integer> getLastStack(){
		return stacks.get(stacks.size()-1);
	}
	
	private boolean atCapacity(Stack<Integer> stack) {
		return stack.size() == capacity;
	}

	public int pop(){
		Stack<Integer> stack = getLastStack();
		int val = stack.pop();
		if(stack.isEmpty()){
			stacks.remove(stacks.size()-1);
		}
		
		return val;
	}
	
	public int currActiveStackCount(){
		return stacks.size();
	}
	
	
	public static void main(String[] args){
		SetOfStacks stack = new SetOfStacks(2);
		stack.push(1);
		stack.push(2);
		
		System.out.println(stack.currActiveStackCount());
		
		stack.push(3);
		
		System.out.println(stack.currActiveStackCount());
		
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.currActiveStackCount());
		
		int lastPop = stack.pop();
		
		System.out.println("Last value popped: " + lastPop + ". Curr number of active stacks: " +
				stack.currActiveStackCount());
		
	}
	
}