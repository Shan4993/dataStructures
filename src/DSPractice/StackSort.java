public class StackSort {
	// Sort a stack.
	// This will involve a second stack where we pull and item and push it to
	// that new stack.
	// If an item violates the order, then pop back to original stack and insert
	// accordingly
	// Takes O(n^2) time and O(n) space

	public static MyStack<Integer> stackSort(MyStack<Integer> stack) {
		if (stack.isEmpty() || stack.size() == 1)
			return stack;

		MyStack<Integer> sorted = new MyStack<Integer>(stack.size());

		while (!stack.isEmpty()) {
				int topOfStack = stack.pop();
				while (!sorted.isEmpty() && topOfStack > sorted.peek()) {
					stack.push(sorted.pop());
				}
				sorted.push(topOfStack);
		}
		return sorted;

	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>(5);
		stack.push(10);
		stack.push(5);
		stack.push(20);
		stack.push(2);
		stack.push(15);

		MyStack<Integer> sortedStack = stackSort(stack);

		while (!sortedStack.isEmpty()) {
			System.out.println(sortedStack.pop());
		}

	}
}
