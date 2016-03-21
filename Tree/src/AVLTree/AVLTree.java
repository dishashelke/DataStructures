package AVLTree;

import BST.BST;
import BST.BSTNode;

public class AVLTree {

	private AVLNode root;
	
	public AVLTree() {
		root = null;
	}
	public void add(int data){
		if(root == null) {
			root = new AVLNode(data);
			return;
		}
		add(root, data);
	}
	private void add(AVLNode current, int data) {
		if (current == null) {
			current = new AVLNode(data);
		}
		else if(data < current.data()) {
			add(current.left(), data);
			int diff = Math.abs(current.left().-  )
		}
		else {
			add(current.right(), data);
		}
	}

	public static void main(String[] args) {


	}

}
