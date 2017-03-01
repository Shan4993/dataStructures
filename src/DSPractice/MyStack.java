
public class MyStack<E> {
	//q: Implement a stack using an array
	
	
	private E[] arr = null;
	private int CAP;
	private int top = -1;
	private int size = 0;//always one index ahead of top 
	
	
	public MyStack(int cap) {
		this.CAP = cap;
		arr = (E[]) new Object[cap];
	}
	
	//pop, push, isFull, toString
	
	public E pop(){
		if(size == 0) return null;
		
		size--;
		E result = arr[top];
		arr[top] = null; //memory leak prevention
		top--;
		
		return result;
	}
	
	public boolean push(E e){
		if(isFull()) return false;
		
		size++;
		arr[++top] = e;
		
		return true;
	}
	
	public int size(){
		return size;
	}
	
	public E peek(){
		if(this.isEmpty()) return null;
		return arr[top];
	}
	
	public boolean isFull(){
		return size == CAP;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public String toString(){
		if(size == 0) return null;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<size;i++){
			sb.append(arr[i] + ", ");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		 
		MyStack<String> stack = new MyStack<String>(11);
		stack.push("hello");
		stack.push("world");
 
		System.out.println(stack);
 
		stack.pop();
		System.out.println(stack);
 
		stack.pop();
		System.out.println(stack);
	}
	
	
}
