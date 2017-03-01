import java.util.*;


public class MedianRunning {
	
	PriorityQueue<Integer> upperQ; //will hold values greater than median
	PriorityQueue<Integer> lowerQ;
	
	public MedianRunning(){
		lowerQ = new PriorityQueue<Integer>(20, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				return -o1.compareTo(o2);
			}
		});

		upperQ = new PriorityQueue<Integer>();

		upperQ.add(Integer.MAX_VALUE);
		lowerQ.add(Integer.MIN_VALUE);
	}
	
	public double getMedian(int addMe){
		if(addMe >= upperQ.peek()){
			upperQ.add(addMe);
		}else{
			lowerQ.add(addMe);
		}
		
		if(upperQ.size()-lowerQ.size() == 2){
			lowerQ.add(upperQ.poll());
		}else if(lowerQ.size() - upperQ.size() == 2){
			upperQ.add(lowerQ.poll());
		}
		
		//return median 
		if(upperQ.size() == lowerQ.size()){
			double first = (double) lowerQ.peek();
			double second = (double) upperQ.peek();
			return (first+second)/2;
			
		}else if(upperQ.size() > lowerQ.size()){
			return upperQ.peek();
		}else{
			return lowerQ.peek();
		}
	}
	
	
	//3, 2, 1,       5, 6, 7 
	public static void main(String[] args){
		MedianRunning mr = new MedianRunning();
		for(int i=1;i<10;i++){
			System.out.println("adding: " + i + ". median: " + mr.getMedian(i));
		}
	}
}
