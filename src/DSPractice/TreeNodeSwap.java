
public class TreeNodeSwap {
	//find parents and swap their references 
	public static TreeNode swap(TreeNode root, TreeNode a, TreeNode b){
		TreeNode parentOfA = findParent(root,a);
		TreeNode parentOfB = findParent(root,b);
		
		
		if(parentOfA.left == a){ //node to swap is left child
			parentOfA.left = b;
		}else{ //node to swap is right child
			parentOfA.right = b;
		}
		
		if(parentOfB.left == b){ //node to swap is left child
			parentOfB.left = a;
		}else{//node to swap is right child
			parentOfB.right = a;
		}
		
		
		return root;
	}
	
	private static TreeNode findParent(TreeNode root, TreeNode target) {
		TreeNode parent = root;
		while(true){
			if(parent.val > target.val && parent.left != target){//go left
				parent = parent.left;
			}else if(parent.val <= target.val && parent.right != target){
				parent = parent.right;
			}else{
				return parent;
			}
		}
	}

	public static void main(String[] args){
		//       10
		//   5		  20
		// 1  7     15  25
		//     9
		
		//        10
		//   5	 	   9
		// 1   7     
		//      20
		//     15 25
		
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(25);
		root.left.right.right = new TreeNode(9);
		root.printInOrder();
		
		swap(root, root.left.right.right, root.right);
		
		System.out.println();
		
		root.printInOrder();
	}
}
