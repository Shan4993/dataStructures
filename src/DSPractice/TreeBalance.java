
public class TreeBalance {
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(6);

		if(isBalanced(root)){
			System.out.println("Tree is Balanced");
		}else{
			System.out.println("Not balanced");
		}
		
	}
	
	
	public static boolean isBalanced(TreeNode root){
		if(root == null) return true;
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1){
			return false;
		}
		
		return isBalanced(root.left) && isBalanced(root.right);
		
	}
	
	public static int getHeight(TreeNode root){
		if(root == null) return 0;
		return 1+Math.max(getHeight(root.left),getHeight(root.right));
	}
}


