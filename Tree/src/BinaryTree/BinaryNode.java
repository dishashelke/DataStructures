package BinaryTree;

//import BinaryNode;

class BinaryNode {
	  private int data;
	  private BinaryNode leftChild;
	  private BinaryNode rightChild;
	  
	  public BinaryNode(int data) {
	    this.data = data;
	    this.leftChild = null;
	    this.rightChild = null;
	  }
	  
	  public int getData() {
	    return data;
	  }
	  public BinaryNode getLeftChild() {
	    return leftChild;
	  }
	  public BinaryNode getRightChild(){
	    return rightChild;
	  }
	  
	  public void setData(int data){
	    this.data = data;
	  }
	  public void invertChildren() {
		  BinaryNode temp = this.leftChild;
	    this.leftChild = this.rightChild;
	    this.rightChild = temp;
	  }
	  
	  public void addLeftChild(int data) {
		  BinaryNode newNode = new BinaryNode(data);
	    this.leftChild = newNode;
	  }
	  
	  public void addRightChild(int data) {
		  BinaryNode newNode = new BinaryNode(data);
	    this.rightChild = newNode;
	  }
	  
	  public void inorder() {
	    if(this.leftChild != null)
	      leftChild.inorder();
	    System.out.print(this.data+" ");
	    if(this.rightChild != null)
	      rightChild.inorder();
	  }
	  public void preorder() {
	    System.out.print(this.data+" ");
	    if(this.leftChild != null)
	      leftChild.preorder();
	    if(this.rightChild != null)
	      rightChild.preorder();    
	  }
	  public void postorder(){
	    if(leftChild != null)
	      leftChild.postorder();
	    if(rightChild != null)
	      rightChild.postorder();
	    System.out.println(data+" ");
	  }
	  
	  public void dfs(){
	    System.out.print(this.data+" ");    
	    if(this.leftChild != null)
	      this.leftChild.dfs();
	    if(this.rightChild != null)
	      this.rightChild.dfs();
	  }
	  
	  public boolean isLeaf() {
		  return (this.getLeftChild() == null && this.getRightChild() == null);
	  }
	}
