import java.util.*;

public class DeleteMe {

	public static  void printTreeCounterClock(TreeNode root){
		preOrderOnly(root);
		inOrderLeaves(root);
		postOrderOnly(root);
	}
	
	private static void postOrderOnly(TreeNode root) {
		if(root == null){
			return;
		}
		postOrderOnly(root.right);
		
		if(!isLeaf(root)){
			System.out.print(root.val + " ");
		}
	}

	private static void inOrderLeaves(TreeNode root) {
		if(isLeaf(root)){
			System.out.print(root.val + " ");
		}
		if(root.left != null){
			inOrderLeaves(root.left);			
		} 
		if(root.right != null){
			inOrderLeaves(root.right);			
		}
	}

	private static void preOrderOnly(TreeNode root) {
		if(root == null){
			return;
		}
		if(!isLeaf(root)){
			System.out.print(root.val + " ");			
		}
		preOrderOnly(root.left);
	}
	
	private static boolean isLeaf(TreeNode root){
		return root.left == null && root.right == null;
	}
	
	private static int closestVal(TreeNode root, int k){
		int answer = minDiff(root, k);
		return answer + k;
	}
	
	private static int minDiff(TreeNode root, int k) {
		if(root == null){
			return Integer.MAX_VALUE;
		}
		
		if(root.val > k){//go left
			return smallDiff(root.val-k, minDiff(root.left, k));
		}else{//go right
			return smallDiff(root.val-k, minDiff(root.right, k));
		}
		
	}

	private static int smallDiff(int a, int b) {
		return Math.abs(a) < Math.abs(b) ? a : b;
	}

	public static void main(String[] args){
		//       100
		//   50		  200
		// 10  70   150  250

		
		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.right = new TreeNode(200);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(70);
		root.right.left = new TreeNode(150);
		root.right.right = new TreeNode(250);
		
		//printTreeCounterClock(root);
		
		System.out.println(closestVal(root, 224));
		
	}
}
