import java.util.*;


public class TreePrintLevels {
	public static void main(String[] args){
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		node.left.left.left = new TreeNode(8);
		
		node.left.left.right = new TreeNode(9);
		node.left.left.right.left = new TreeNode(80);
		node.left.left.right.right = new TreeNode(90);
		
		node.left.right.left = new TreeNode(10);
		node.left.right.right = new TreeNode(11);
		node.right.left.left = new TreeNode(12);
		
		node.right.left.right = new TreeNode(13);
		node.right.left.right.left = new TreeNode(100);
		node.right.left.right.right = new TreeNode(200);
		
		node.right.right.left = new TreeNode(14);
		node.right.right.right = new TreeNode(15);
		
		printLevelsNaive(node);

		System.out.println("\n");

		printLevels(node);

		System.out.println("\n");

		printZigZag(node);

	}
	
	/*
	 * This will print in one line.
	 * */
	public static void printLevelsNaive(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode curr = q.poll();
			System.out.print(curr.val + " ");
			if(curr.left!=null) q.add(curr.left);
			if(curr.right!=null) q.add(curr.right);
		}
	}
	
	/*
	 * Level print split by line
	 * */
	public static void printLevels(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int size = 0;
		while(!q.isEmpty()){
			size = q.size();
			while(size > 0){
				TreeNode node = q.poll();
				System.out.print(node.val + " ");
				if(node.left != null) q.add(node.left);
				if(node.right != null) q.add(node.right);
				size--;
			}
			System.out.println();
		}
		
	}
	
	
	/*
	 * This will print zig zag on one line
	 */
	public static void printZigZag(TreeNode root){
		if(root == null) return;
		LinkedList<TreeNodePairing> list = new LinkedList<TreeNodePairing>();
		list.add(new TreeNodePairing(root,0));
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!list.isEmpty()){
			int currSizeOfList = list.size();

			while(currSizeOfList > 0){
				TreeNodePairing pair = list.remove();
				TreeNode node = pair.node;
				int level = pair.level;
				if(level%2==0){//right to left
					stack.push(node);
				}else{//left to right
					System.out.print(node.val + ", ");
				}	
				
				if(node.left != null) list.add(new TreeNodePairing(node.left, level+1));
				if(node.right != null) list.add(new TreeNodePairing(node.right, level+1));
			
				currSizeOfList--;
			}
			
			while(!stack.isEmpty()){
				System.out.print(stack.pop().val + ", ");
			}
		}
		
	}
	
	private static class TreeNodePairing{
		int level;
		TreeNode node;
		
		public TreeNodePairing(TreeNode node, int level){
			this.node = node;
			this.level = level;
		}
	}
}
