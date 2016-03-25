package AVLTree;

import BST.BST;
import BST.BSTNode;

public class AVLTree extends BST{
//public class AVLTree {

	private static BSTNode root;

	public AVLTree() {
		root = null;
	}

	/*public int height(AVLNode current) {
		if(current == null)
			return 0;
		return current.height();
	}*/
	
	public void insert(int data) {
		if (root == null) {
			root = new BSTNode(data);
			return;
		}
		root = insert(root, data);
	}

	private BSTNode insert(BSTNode current, int data) {
		if(current == null) {
			return new BSTNode(data);
		}
		else if(current.data() < data) {
			BSTNode  newNode = insert(current.right(), data);
			current.right(newNode);
		}
		else {
			BSTNode newNode = insert(current.left(), data);
			current.left(newNode);
		}

		/*int height = Math.max(height(current.left()), height(current.right())) + 1;
		current.height(height);*/
		int balance = height(current.left()) - height(current.right());

		// left left caes
		if (balance > 1 && data < current.left().data()) {
			 current = rightRotate(current);
		}
		// left right case
		if (balance > 1 && data > current.left().data()) {
			current.left(leftRotate(current.left()));
			 current = rightRotate(current);
		}
		// right right case
		if (balance < -1 && data > current.right().data()) {
			 current = leftRotate(current);
		}
		// right left case
		if (balance < -1 && data < current.right().data()) {
			current.right(rightRotate(current.right()));
			current = leftRotate(current);
		}
		return current;
	}

	private BSTNode rightRotate(BSTNode y) {
		BSTNode x = y.left();
		BSTNode t2 = x.right();

		// rotate
		x.right(y);
		y.left(t2);

		// modify heights
		/*int xHeight = Math.max(height(x.left()), height(x.right())) + 1;
		int yHeight = Math.max(height(y.left()), height(y.right())) + 1;
		x.height(xHeight);
		y.height(yHeight);*/
		return x;
	}

	private BSTNode leftRotate(BSTNode x) {
		BSTNode y = x.right();
		BSTNode t2 = y.left();

		// rotate
		y.left(x);
		x.right(t2);

		// modify heights
		/*int xHeight = Math.max(height(x.left()), height(x.right())) + 1;
		int yHeight = Math.max(height(y.left()), height(y.right())) + 1;
		x.height(xHeight);
		y.height(yHeight);*/
		return y;
	}

	public void inorder() {
		root.inorder();
	}

	/*
	 *     30
           /  \
         20   40
        /  \     \
       10  25    50
	 */
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		
		tree.insert(10);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(50);
		tree.insert(25);

		tree.inorder();
	}

}
