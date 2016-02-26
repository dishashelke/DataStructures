package BST;

class Node {
	  private int data;
	  private Node leftChild;
	  private Node rightChild;
	  
	  public Node(int data) {
	    this.data = data;
	    this.leftChild = null;
	    this.rightChild = null;
	  }
	  
	  public int getData() {
	    return data;
	  }
	  public Node getLeftChild() {
	    return leftChild;
	  }
	  public Node getRightChild(){
	    return rightChild;
	  }
	  
	  public void setData(int data){
	    this.data = data;
	  }
	  
	  public void add(int data) {
	    if(data < this.data) {//add to left subtree
	      if(this.leftChild == null) {
	        this.leftChild = new Node(data);
	      }
	      else {
	        this.leftChild.add(data);
	      }
	    }
	    else {//add to rightsubtree
	      if(this.rightChild == null) {
	        this.rightChild = new Node(data);
	      }
	      else{
	        this.rightChild.add(data);
	      }
	    }
	  }
	  
	  public void inorder() {
	    if(this.leftChild != null)
	      leftChild.inorder();
	    System.out.print(this.data+" ");
	    if(this.rightChild != null)
	      rightChild.inorder();
	  }
	  
	  public void dfs(){
	    System.out.print(this.data+" ");    
	    if(this.leftChild != null)
	      this.leftChild.dfs();
	    if(this.rightChild != null)
	      this.rightChild.dfs();
	  }
	}
