package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {
	  protected BSTNode root;
	  
	  public BST(){
	    root = null;
	  }
	  
	  public BSTNode getRoot(){
		  return root;
	  }
	  
	  public void add(int data){
	    if(root == null)
	      root = new BSTNode(data);
	    else 
	      root.add(data);
	  }
	  
	  public void addNodes(int[] data) {
			for (int i = 0; i < data.length; i++)
				add(data[i]);
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
	    List<BSTNode> order = new ArrayList<BSTNode>();
	    order.add(root);
	    while(!order.isEmpty()) {
	      BSTNode current = order.remove(0);
	      System.out.print(current.data()+" ");
	      if(current.left() != null)
	        order.add(current.left());
	      if(current.right() != null)
	        order.add(current.right());
	    }
	  }
	  
	  //***********************DFS*****************************
	  public void dfs() {
	    Stack<BSTNode> order = new Stack<BSTNode>();
	    order.push(root);
	    while(!order.isEmpty()) {
	      BSTNode current = order.pop();
	      System.out.print(current.data()+" ");
	      if(current.right() != null) 
	        order.push(current.right());
	      if(current.left() != null)
	        order.push(current.left());      
	    }
	  }
	  
	  public void recursiveDFS() {
	    if(root != null)
	      root.dfs();
	  }
	  
	  //********************inorder*******************
	  public void inorder() {
	    if (root != null)
	      root.inorder();
	  }
	  //*****************print inorder***************
	  public String printInOrder() {
			return (inOrder(root));
		}

		public String inOrder(BSTNode current) {
			if (current != null)
				return inOrder(current.left()) + (current.data())
						+ " " + inOrder(current.right());
			return "";
		}
		//********************print preorder ********************
		public void printPreOrder() {
			preOrder(root);
		}

		public void preOrder(BSTNode node) {
			if (node != null) {
				System.out.print(node.data() + " ");
				preOrder(node.left());
				preOrder(node.right());
			}
		}
	  
	  //***********************Search************************
	  public BSTNode search(int data) {
		 return search(root, data);
	  }
	  private  BSTNode search(BSTNode current, int data) {		  
		  if(current == null)
			  return null;
		  if(current.data() == data)		  
			  return current;
		  if(current.data() < data)
			  return search(current.right(), data);
		  return search(current.left(), data);
	  }
	  
	//****************inorder successor****************
	  public BSTNode getMin(BSTNode current) {
		  if(current == null)
			  return null;
		  while(current.left() != null)
			  current = current.left();
		  return current;
	  }
	  public BSTNode getInorderSuccessor(int data) {
		  return getInorderSuccessor(root, data);
	  }
	  
	  /*
	   * case1 : node has right subtree=>return the leftmost node in right subtree
	   * case 2: node does not have rightsubtree => find the deepest ancestor which has value grater than the current node
	   */
	private BSTNode getInorderSuccessor(BSTNode root, int data) {
		BSTNode current = search(data);
		if (current == null)
			return null;
		if (current.right() != null) {// case1
			return getMin(current.right());
		}
		// case2
		BSTNode successor = null;
		BSTNode ancestor = root;
		while (ancestor != current) {
			if (ancestor.data() > data) {
				successor = ancestor;
				ancestor = ancestor.left();
			} else {
				ancestor = ancestor.right();
			}
		}
		return successor;
	}
//*********************recursive min**************************
	public BSTNode findMinRec() {
		return findMinRec(root);
	}
	public BSTNode findMinRec(BSTNode current) {
		if(current == null)
			return null;
		if(current.left() == null)
			return current;
		return findMinRec(current.left());
	}
	//**********************height of tree*********************
	public int height() {
		return height(root);
	}
	public int height(BSTNode current) {
		if(current == null)
			return -1;
		return Math.max(height(current.left()), height(current.right())) + 1;
	}
	/*
	 * modify tree to make it non-bst. This is used to test isbst function
	 */
	  public void modify() {
	    BSTNode left = root.left();
	    left.setData(-120);
	  }
	  
	  public static void main(String[] args) {
		    BST bst = new BST();
		    bst.add(5);//root created
		    bst.addNodes(new int[] { 2,10,7,3,1,4,-10,8,20,6 });
		    
		    System.out.print("Inorder:");
		    bst.inorder();
		    System.out.print("\nPrint inorder:"+bst.printInOrder());
		    System.out.print("\nPrint preorder:");
		    bst.printPreOrder();
		    
		    System.out.print("\nBFS:");
		    bst.bfs();//5 2 10 1 3 7 20 -10 4 6 8
		    System.out.print("\nDFS:");
		    bst.dfs();//5 2 1 -10 3 4 10 7 6 8 20
		    System.out.print("\nRecursive DFS:");
		    bst.recursiveDFS();//5 2 1 -10 3 4 10 7 6 8 20 
		    
		    System.out.print("\nsearch value 2 in tree:"+bst.search(2).data());
		    
		    System.out.print("\nInorder successor="+bst.getInorderSuccessor(10).data());
		    
		    System.out.print("\nMin element in treer="+bst.findMinRec().data());
		  }
	}

	
