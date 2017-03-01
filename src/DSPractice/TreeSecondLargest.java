
public class TreeSecondLargest {
	//Q: Find the second largest elemnt in a BST
	//Source interviewcake.com
	public static int findLargest(TreeNode root){
		TreeNode curr = root;
		while(curr.right != null){
			curr = curr.right;
		}
		return curr.val;
	}
	
	public static int findSecLargest(TreeNode root){
		if(root == null || (root.left == null && root.right == null)){
			throw new IllegalArgumentException("Tree is too small");
		}
		
		TreeNode curr = root;
		
		while(true){
			if(curr.right == null && curr.left != null){
				return findLargest(curr.left);
			}
			
			if(curr.right != null && curr.right.right == null 
					&& curr.right.left == null){
				return curr.val;
			}
			
			curr = curr.right;
		}
		
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(30);
		root.right.left = new TreeNode(15);
		
		root.right.right.left = new TreeNode(25);
		root.right.right.right = new TreeNode(40);
		
		root.right.right.right.left = new TreeNode(35);
		root.right.right.right.left.right = new TreeNode(38);
		
		System.out.println(findSecLargest(root));
	}
}
