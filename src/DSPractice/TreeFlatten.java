package DSPractice;

public class TreeFlatten {
	// Q: Given a tree, flatten it so that all the nodes are one side
	// Worst case run time would be linear (all nodes are left aligned)
	public static void flatten(Tree root) {
		Tree node = root;
		while(node != null){
			if(node.left != null){
				Tree pred = getPred(node.left);
				pred.right = node.right;
				node.right = node.left;
				node.left = null;
			}
			node = node.right;
		}
	}

	public static Tree getPred(Tree node) {
		Tree p = node;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}

	public static void main(String[] args) {
		//    10
		//  5   15
		// 3 7 13 20

		Tree root = new Tree(10);
		root.left = new Tree(5);
		root.left.left = new Tree(3);
		root.left.right = new Tree(7);
		root.right = new Tree(15);
		root.right.right = new Tree(20);
		root.right.left = new Tree(13);
		
		flatten(root);
		Tree p = root;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.right;
		}

	}

}
