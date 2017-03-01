import java.util.*;

public class TreeSummation {

	ArrayList<ArrayList<Integer>> allPathsThatAddToSum = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> currPath = new ArrayList<Integer>();

	private ArrayList<ArrayList<Integer>> getSums(TreeNode root, int target) {
		if(root == null) return allPathsThatAddToSum;
		
		currPath.add(root.val);
		
		
		if(isLeaf(root)){
			if(target-root.val==0){
				allPathsThatAddToSum.add(new ArrayList<Integer>(currPath));
			}
		}
		
		if(root.left != null){
			getSums(root.left, target-root.val);
		}
		
		if(root.right != null){
			getSums(root.right, target-root.val);
		}
		
		currPath.remove(currPath.size()-1);
		
		return allPathsThatAddToSum;
	}

	public static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		//	   		10
		//	5 				12
		//4  7
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);

		
		TreeSummation ts = new TreeSummation();
		
		ArrayList<ArrayList<Integer>> masterList = ts.getSums(root, 22);
		for (ArrayList<Integer> currList : masterList) {
			for (int value : currList) {
				System.out.print(value + ", ");
			}
			System.out.println();
		}
	}
}
