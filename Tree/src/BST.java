import java.util.Stack;

public class BST<T> {

	private BSTNode<T> root;

	BST() {
		root = null;
	}

	BST(T data) {
		root = new BSTNode<T>(data);
	}

	public void addNode(T data) {
		if (root == null)
			root = new BSTNode<T>(data);
		else {
			root.add(data);
		}
	}

	public void addNodes(T[] data) {
		for (int i = 0; i < data.length; i++)
			addNode(data[i]);
	}

	public String printInOrder() {
		return (inOrder(root));
	}

	public String inOrder(BSTNode<T> node) {
		if (node != null)
			return inOrder(node.getLeftChild()) + (node.getData()).toString()
					+ " " + inOrder(node.getRightChild());
		return "";
	}

	public void printPreOrder() {
		preOrder(root);
	}

	public void preOrder(BSTNode<T> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}

	public void postOrder() {
		if (root != null)
			root.postOrder();
	}

	public boolean search(T data) {
		if (root == null)
			return false;
		else
			return root.search(data);
	}
	
	public static boolean isValidBST(int[] preOrder){
		Stack<Integer> stack = new Stack<Integer>();
	    int parent = Integer.MIN_VALUE;
	    for (Integer each: preOrder){
	        if (parent != -1 && parent > each){
	            return false;
	        }
	        while (!stack.isEmpty()){
	            int top = (Integer) stack.pop();
	            if(top < each)
	                parent = top;
	            }
	        stack.push(each);
	    }
	    return true;
	}

	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
		tree.addNodes(new Integer[] { 20, 2, 0, 10, -6, 8 });
		System.out.print("\n[INORDER] : " + tree.printInOrder());
		System.out.print("\n[PREORDER] : ");
		tree.printPreOrder();
		System.out.print("\n[POSTORDER] : ");
		tree.postOrder();
		System.out.print("\nElement found: " + tree.search(8));
		System.out.print("\nElement found: " + tree.search(-8));
		
		int preOrder[] = {3,2,5,4,1,6};
		System.out.print("\nIs valid BST: " + (isValidBST(preOrder)==true ? "True" : "False"));
	}

}