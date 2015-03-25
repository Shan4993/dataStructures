package DSPractice;

public class SearchInsertPos {
	//Given a sorted array find the index of a given element. 
	//That element may not exist, if so return the index where it should be
	//Runtime: lg(n) and in place
    public static void main(String[] args){
    	int[] A1 = new int[]{1,3,5,6};
    	System.out.println(searchInsert(A1,5));
    	System.out.println(searchInsert(A1,2));
    	System.out.println(searchInsert(A1,7));
    	System.out.println(searchInsert(A1,0));
    }
	
	public static int searchInsert(int[] A, int target) {
        //use binary search
        //return its location if it is found
        //otherwise return the location it should be in
        return searchInsert(A,0,A.length-1,target);
    }
    
    public static int searchInsert(int[] A, int start, int end, int target){
        if(start<=end){
            int mid = (start+end)/2;
            if(A[mid] > target){
                return searchInsert(A,start,mid-1,target);
            } else if(A[mid] < target){
                return searchInsert(A,mid+1,end,target);
            } else{
            	return mid;
            }
        } else{
        	return start;
        }
    }
}
