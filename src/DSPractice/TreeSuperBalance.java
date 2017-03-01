import java.util.*;

public class TreeSuperBalance {

	public boolean isValid(TreeNode root) {
		ArrayList<Integer> depths = new ArrayList<Integer>();
		BinaryTreeNodePair pair = new BinaryTreeNodePair(root, 0);
		java.util.Stack<BinaryTreeNodePair> stack = new java.util.Stack<BinaryTreeNodePair>();
		stack.push(pair);
		while (!stack.empty()) {
			BinaryTreeNodePair curr = stack.pop();
			TreeNode currNode = curr.node;
			int depth = curr.depth;

			if (currNode.left == null && currNode.right == null) {// is leaf lets check it out
				if (!depths.contains(depth)) {// recall only at children here
					depths.add(depth);
					if (depths.size() > 2
							|| (depths.size() == 2 && Math.abs(depths.get(0)
									- depths.get(1)) > 1)) {
						return false;
					}
				}
			} else if (currNode.right != null) {
				stack.push(new BinaryTreeNodePair(currNode.right, depth + 1));
			} else if (currNode.left != null) {
				stack.push(new BinaryTreeNodePair(currNode.left, depth + 1));
			}
		}
		return true;
	}

	
	class BinaryTreeNodePair {
		int depth;
		TreeNode node;

		public BinaryTreeNodePair(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
