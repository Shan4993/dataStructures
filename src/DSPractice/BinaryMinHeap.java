
public class BinaryMinHeap {
	private Task[] heap;
	private int heapSize; 
	
	public BinaryMinHeap(int size){
		heap = new Task[size];
		heapSize = 0;
	}
	
	public Task getMin(){
		if(isEmpty()){
			System.out.println("The heap is already empty");
			return null;
		} else {
			return heap[0];
		}
	}
	
	public void insert(Task t){
		if(heapSize == heap.length){
			System.out.println("Heap is already full");
		}else{
			heapSize++;
			heap[heapSize-1] = t;
			siftUp(heapSize-1);
		}
	}
	
	public void siftUp(int nodeIndex){
		int parentIndex;
		Task temp;
		if(nodeIndex != 0){
			parentIndex = getParentIndex(nodeIndex);
			if(heap[nodeIndex].priority < heap[parentIndex].priority){
				//swap
				temp = heap[parentIndex];
				heap[parentIndex] = heap[nodeIndex];
				heap[nodeIndex] = temp;
				siftUp(parentIndex);
			}
		}
	}
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Heap is already empty, nothing to delete");
		} else {
			heap[0] = heap[heapSize-1];
			heapSize--;
			if(heapSize > 0){
				siftDown(0);				
			}
		}
	}
	
	public void siftDown(int nodeIndex){
		int leftChildIndex, rightChildIndex, minIndex;
		Task temp;
		leftChildIndex = getLeftChildIndex(nodeIndex);
		rightChildIndex = getRightChildIndex(nodeIndex);
		//find min index from children
		if(rightChildIndex >= heapSize){
			if(leftChildIndex >= heapSize){
				return;
			}else{
				minIndex = leftChildIndex;
			}
		}else{
			if(heap[leftChildIndex].priority <= heap[rightChildIndex].priority){
				minIndex = leftChildIndex;
			}else{
				minIndex = rightChildIndex;
			}
		}
		if(heap[minIndex].priority < heap[nodeIndex].priority){
			temp = heap[minIndex];
			heap[minIndex] = heap[nodeIndex];
			heap[nodeIndex] = temp;
			siftDown(minIndex);
		}
	}
	
	public int getLeftChildIndex(int nodeIndex){
		return 2 * nodeIndex + 1;
	}
	
	public int getRightChildIndex(int nodeIndex){
		return 2 * nodeIndex + 2;
	}
	
	public int getParentIndex(int nodeIndex){
		return (nodeIndex - 1) /2;
	}
	
	public boolean isEmpty(){
		return heapSize == 0;
	}
	
	public void print(){
		for(int i=0;i<heapSize;i++){
			System.out.println(heap[i].toString());
		}
	}
	
	public static void main(String[] args){
		BinaryMinHeap bmh = new BinaryMinHeap(10);
		bmh.insert(new Task("fourth", 4));
		bmh.insert(new Task("first", 1));
		bmh.insert(new Task("fifth", 5));
		bmh.insert(new Task("second", 2));
		bmh.insert(new Task("third", 3));
		bmh.insert(new Task("sixth", 6));
		bmh.insert(new Task("seventh", 7));
		
		bmh.print();
		System.out.println();
		
		bmh.delete();
		bmh.print();
		System.out.println();
		
		bmh.delete();
		bmh.print();
		System.out.println();
		
	}
}

class Task {
	String job;
	int priority;
	
	public Task(String job, int priority){
		this.job = job;
		this.priority = priority;
	}
	
	public String toString(){
		return "Priority: " + priority +", Job: "+job;
	}
}