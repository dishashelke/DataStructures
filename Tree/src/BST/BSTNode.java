package BST;

public class BSTNode {
	  private int data;
	  private BSTNode leftChild;
	  private BSTNode rightChild;
	  
	  public BSTNode(int data) {
	    this.data = data;
	    this.leftChild = null;
	    this.rightChild = null;
	  }
	  
	  public int data() {
	    return data;
	  }
	  public BSTNode left() {
	    return leftChild;
	  }
	  public BSTNode right(){
	    return rightChild;
	  }
	  
	  public void setData(int data){
	    this.data = data;
	  }
	  
	  public void left(BSTNode left) {
		  leftChild = left;
	  }
	  
	  public void right(BSTNode right) {
		  rightChild = right;
	  }
	  
	  public void add(int data) {
	    if(data < this.data) {//add to left subtree
	      if(this.leftChild == null) {
	        this.leftChild = new BSTNode(data);
	      }
	      else {
	        this.leftChild.add(data);
	      }
	    }
	    else {//add to rightsubtree
	      if(this.rightChild == null) {
	        this.rightChild = new BSTNode(data);
	      }
	      else{
	        this.rightChild.add(data);
	      }
	    }
	  }
	  
	  public boolean search(int data) {
			if (this.data == data)
				return true;
			else if (((Integer) data < (Integer) this.data) && (leftChild != null))
				return leftChild.search(data);
			else if (((Integer) data > (Integer) this.data) && (rightChild != null))
				return rightChild.search(data);
			else
				return false;
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
