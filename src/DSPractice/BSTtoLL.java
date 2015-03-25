package DSPractice;

public class BSTtoLL {
	//BST to Doubly Linked List only using the BST nodes (left and right)
	
	private static Tree head;
	private static Tree pre;
	
	public static void main(String[] args){
		//          30  
		//     20        40
		//  10    25  35    50
		
		Tree root = new Tree(30);
		root.left = new Tree(20);
		root.right = new Tree(40);
		root.left.left = new Tree(10);
		root.left.right = new Tree(25);
		root.right.right = new Tree(50);
		root.right.left = new Tree(35);
		
		root = toDLL(root);
		printDLL(root);
	}
	
	private static void printDLL(Tree root) {
		Tree p = root;
		while(p != null){
			System.out.print(p.data + ", ");
				p = p.right;
		}
	}

	public static Tree toDLL(Tree root){
		connect(root);
		return head;
	}

	private static void connect(Tree root) {
		if(root==null)return;
		if(root.left == null && head == null){
			head = root;
		}
		connect(root.left);
		if(pre != null){
			pre.right = root;
			root.left = pre;
		}
		pre = root;
		connect(root.right);
	}
	
	
}
