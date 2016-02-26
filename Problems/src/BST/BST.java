package BST;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BST {
	  private Node root;
	  
	  public BST(){
	    root = null;
	  }
	  
	  public Node getRoot(){
		  return root;
	  }
	  
	  public void add(int data){
	    if(root == null)
	      root = new Node(data);
	    else 
	      root.add(data);
	  }
	  /*
	  Algorithm :
	  1. add root in queue 
	  2. while queue is not empty iterate
	  3. delete node from queue
	  4. print deleted node
	  5. add children of deleted nodes in queue
	  
	  */
	  public void bfs() {
	    List<Node> order = new ArrayList<Node>();
	    order.add(root);
	    while(!order.isEmpty()) {
	      Node current = order.remove(0);
	      System.out.print(current.getData()+" ");
	      if(current.getLeftChild() != null)
	        order.add(current.getLeftChild());
	      if(current.getRightChild() != null)
	        order.add(current.getRightChild());
	    }
	  }
	  
	  public void dfs() {
	    Stack<Node> order = new Stack<Node>();
	    order.push(root);
	    while(!order.isEmpty()) {
	      Node current = order.pop();
	      System.out.print(current.getData()+" ");
	      if(current.getRightChild() != null) 
	        order.push(current.getRightChild());
	      if(current.getLeftChild() != null)
	        order.push(current.getLeftChild());      
	    }
	  }
	  
	  public void recursiveDFS() {
	    if(root != null)
	      root.dfs();
	  }
	  
	  public void inorder() {
	    if (root != null)
	      root.inorder();
	  }
	  
	  //////////////////////////////////////////////////
	  public Node search(int data) {
		 return search(root, data);
	  }
	  private  Node search(Node current, int data) {		  
		  if(current == null)
			  return null;
		  if(current.getData() == data)		  
			  return current;
		  if(current.getData() < data)
			  return search(current.getRightChild(), data);
		  return search(current.getLeftChild(), data);
	  }
	  public Node getMin(Node current) {
		  if(current == null)
			  return null;
		  while(current.getLeftChild() != null)
			  current = current.getLeftChild();
		  return current;
	  }
	  public Node getInorderSuccessor(int data) {
		  return getInorderSuccessor(root, data);
	  }
	  /*
	   * case1 : node has right subtree=>return the leftmost node in right subtree
	   * case 2: node does not have rightsubtree => find the deepest ancestor which has value grater than the current node
	   */
	private Node getInorderSuccessor(Node root, int data) {
		Node current = search(data);
		if (current == null)
			return null;
		if (current.getRightChild() != null) {// case1
			return getMin(current.getRightChild());
		}
		// case2
		Node successor = null;
		Node ancestor = root;
		while (ancestor != current) {
			if (ancestor.getData() > data) {
				successor = ancestor;
				ancestor = ancestor.getLeftChild();
			} else {
				ancestor = ancestor.getRightChild();
			}
		}
		return successor;
	}
/*
 * Find min recurssively
 */
	public Node findMinRec() {
		return findMinRec(root);
	}
	public Node findMinRec(Node current) {
		if(current == null)
			return null;
		if(current.getLeftChild() == null)
			return current;
		return findMinRec(current.getLeftChild());
	}
	/*
	 * modify tree to make it non-bst. This is used to test isbst function
	 */
	  public void modify() {
	    Node left = root.getLeftChild();
	    left.setData(-120);
	  }
	  
	  public static void main(String[] args) {
		    BST bst = new BST();
		    bst.add(5);
		    bst.add(2);
		    bst.add(10);
		    bst.add(7);
		    bst.add(3);
		    bst.add(1);
		    bst.add(4);
		    bst.add(-10);
		    bst.add(8);
		    bst.add(20);
		    bst.add(6);
		   // bst.inorder();
		    bst.bfs();
		    System.out.println();
		    bst.dfs();
		    System.out.println();
		    bst.recursiveDFS();
		    
		    System.out.print(bst.search(2).getData());
		    
		    System.out.println("\nInorder successor="+bst.getInorderSuccessor(10).getData());
		    
		    System.out.println("\nMin element in treer="+bst.findMinRec().getData());
		  }
	}

	
