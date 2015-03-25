package DSPractice;

public class ClosestVal {
	public static void main(String[] args){
		
		//        100
		//   50         150
		//25    75  125     200
		TreeNode<Integer> head = new TreeNode<Integer>(100);
		head.left = new TreeNode<Integer>(50);
		head.left.left = new TreeNode<Integer>(25);
		head.left.right = new TreeNode<Integer>(75);
		head.right = new TreeNode<Integer>(150);
		head.right.left = new TreeNode<Integer>(125);
		head.right.right = new TreeNode<Integer>(200);
		
		int result = closestAns(head, 151);
		System.out.println("The result is: " + result);
		
	}
	
	public static int closestAns(TreeNode<Integer> n, int val) {
		int ans = minDiff(n, val);
		return ans + val;
	}

	private static int minDiff(TreeNode<Integer> t, int val) {
		if (t == null)
			return Integer.MAX_VALUE;
		if (t.data < val)
			return smallerDiff(t.data - val, minDiff(t.right, val));
		else
			return smallerDiff(t.data - val, minDiff(t.left, val));
	}

	public static int smallerDiff(int a, int b) {
		if (Math.abs(a) > Math.abs(b))
			return b;
		else
			return a;
	}

}

