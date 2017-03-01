public class TreeNode{
	int val;
	TreeNode left, right;
	
	public TreeNode(int val){
		this.val = val;
		left = right = null;
	}
	
	public void printInOrder(){
		if(this == null) return;
		
		if(this.left != null){
			left.printInOrder();
		}
		
		System.out.print(this.val + ", ");
		
		if(this.right != null){
			right.printInOrder();
		}
	}
}