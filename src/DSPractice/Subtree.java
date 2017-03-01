
public class Subtree {
	//Q: Figure out if t2 is a subtree of t1
	public static boolean isSubTree(TreeNode t1, TreeNode t2){
		if(t2 == null) return true;
		return isSub(t1,t2);
	}

	public static boolean isSub(TreeNode t1, TreeNode t2){
		if(t1 == null ) return false;
		if(t1.val == t2.val){
			if(isMatch(t1,t2)) return true;
		}
		return isSub(t1.left,t2) || isSub(t1.right,t2);
	}
	
	public static boolean isMatch(TreeNode a, TreeNode b){
		if(a == null && b == null) return true;
		if(a == null || b == null) return false;
		if(a.val != b.val) return false;
		return isMatch(a.left,b.left) && isMatch(a.right,b.right);
	}
}
