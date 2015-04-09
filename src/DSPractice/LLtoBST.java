package DSPractice;

public class LLtoBST {
	// Q: Take a sorted doubly linked list and convert it to a bst in place
	public static DLLNode convert(DLLNode node) {
		if (node == null)
			return null;
		DLLNode mid = findMid(node);
		mid.prev.next = null;
		mid.prev = findMid(node);
		mid.next = findMid(mid.next);
		return mid;
	}

	public static DLLNode findMid(DLLNode node) {
		DLLNode p = node;
		while (p.next != null) {
			p = p.next;
			if (p.next != null) {
				p=p.next;
				node = node.next;
			}
		}
		return node;
	}

	// Q: Take a sorted singly linked list and convert it to a bst in place
	private static ListNode head;

	public static Tree convert(ListNode node) {
		if (node == null)
			return null;
		head = node;
		int len = getLength(node);
		return convert(0, len - 1);
	}

	public static Tree convert(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;

		Tree leftTree = convert(start, mid - 1);
		Tree root = new Tree(head.data);
		head = head.next;
		Tree rightTree = convert(mid + 1, end);
		root.left = leftTree;
		root.right = rightTree;

		return root;
	}

	public static int getLength(ListNode node) {
		ListNode p = node;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		return count;
	}

	public static void main(String[] args) {
		// First testing the DLL conversion to BST
		DLLNode root = new DLLNode(1);
		root.next = new DLLNode(5);
		root.next.next = new DLLNode(10);
		root.next.next.next = new DLLNode(15);
		root.next.next.next.next = new DLLNode(20);
		root.next.next.next.next.next = new DLLNode(25);
		root.next.next.next.next.next.next = new DLLNode(30);
		root.next.next.next.next.next.next.prev = root.next.next.next.next.next;
		root.next.next.next.next.next.prev = root.next.next.next.next;
		root.next.next.next.next.prev = root.next.next.next;
		root.next.next.next.prev = root.next.next;
		root.next.next.prev = root.next;
		root.next.prev = root;
		root.print();

		DLLNode treeRoot = convert(root);
		System.out.println(treeRoot.data);
		System.out.println(treeRoot.prev.data);
		System.out.println(treeRoot.next.data);
		// ..tree prints if continued

		// Second testing the SLL conversion to BST
		head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(10);
		head.next.next.next = new ListNode(15);
		head.next.next.next.next = new ListNode(20);
		head.next.next.next.next.next = new ListNode(25);
		head.next.next.next.next.next.next = new ListNode(30);
		head.printList();

		Tree tree = convert(head);
		tree.inOrderPrint();
	}
}
