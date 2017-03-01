
public class ArrToBST {
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		TreeNode root = arrToBST(arr, 0, arr.length-1);
		root.printInOrder();
	}
	
	public static TreeNode arrToBST(int[] arr, int start, int end){
		if(start>end) return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = arrToBST(arr,start,mid-1);
		root.right = arrToBST(arr,mid+1,end);
		return root;
	}
}
