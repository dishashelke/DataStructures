package AVLTree;

/*
 * Another approach: create a AVLNode having height as data member  and then no need to extend the BST to implement AVLTree
 */

public class AVLNode {
	private int data;
	private int height;
	private AVLNode left;
	private AVLNode right;
	
	public AVLNode(int data) {
		this.data = data;
		height = 1;
		left = null;
		right = null;
	}

	public int data() {
		return data;
	}

	public void data(int data) {
		this.data = data;
	}

	public int height() {
		return height;
	}

	public void height(int height) {
		this.height = height;
	}

	public AVLNode left() {
		return left;
	}

	public void left(AVLNode left) {
		this.left = left;
	}

	public AVLNode right() {
		return right;
	}

	public void right(AVLNode right) {
		this.right = right;
	}

	public void inorder() {
		if(left != null)
			left.inorder();
		System.out.print(data + ", ");
		if(right != null)
			right.inorder();
	}

}
