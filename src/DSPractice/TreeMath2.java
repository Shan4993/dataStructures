
public class TreeMath2 {
	/*You are given a binary tree in which each node contains a value. Design an algo-
	rithm to print all paths which sum to a given value. The path does not need to start
	or end at the root or a leaf. Source: CTCI*/
	
	public static void findSum(TreeNode root, int sum){
		int size = depth(root);
		int[] path = new int[size];
		findSum(root,sum,path,0);
	}

	public static void findSum(TreeNode root, int sum, int[] path, int level){
		if(root == null) return;
		
		//insert node into path
		path[level] = root.val; 
		
		//from this point go up, checking to see if u hit total at which point print
		int total = 0;
		for(int i=level;i>=0;i--){
			total += path[i];
			if(total == sum){
				print(path,i,level);
			}
		}
		
		//keep traversing down the list adding values to the path array
		findSum(root.left,sum,path,level+1);
		findSum(root.right,sum,path,level+1);
	}
	
	public static void print(int[] path, int start, int end){
		System.out.print("{");
		for(int i=start;i<=end;i++){
			System.out.print(path[i]+", ");
		}
		System.out.println("}");
	}
	
	public static int depth(TreeNode root){
		if(root == null) return 0;
		return 1+ Math.max(depth(root.left), depth(root.right));
	}
	
	public static void main(String[] args){
		
		//       10
		//   5		  20
		// 1  6     15  25
		//     9
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(25);
		root.left.right.right = new TreeNode(9);
		
		findSum(root, 30);
	}
}
