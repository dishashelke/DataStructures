package AVLTree;

import BST.BSTNode;

public class AVLNode extends BSTNode{

	private int height;
	
	public AVLNode(int data) {
		super(data);
		height = 0;
	}	

	public int height() {
		return height;
	}
	
	public void height(int height) {
		this.height = height;
	}
	
	
}
