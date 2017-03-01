import java.util.*;


public class TreeTwoSum {
	
	
	public static void main(String[] args){
		//       10
		//   5		  20
		// 1  7     15  25
		//     9
		
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(25);
		root.left.right.right = new TreeNode(9);
		
		
		System.out.println(existsPair(root, 24));
		System.out.println(existsPair(root, 40));
	}

	private static boolean existsPair(TreeNode root, int sum) {
		if(root == null) return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode curr = stack.pop();
			int diff = sum - curr.val;
			if(map.containsKey(curr.val)){
				System.out.println("Pair: " + map.get(curr.val) + " and " + curr.val);
				return true;
			}else{
				
				map.put(diff, curr.val);
			}
			
			if(curr.right != null) stack.push(curr.right);
			if(curr.left != null) stack.push(curr.left);
		}
		
		
		return false;
	}
}
