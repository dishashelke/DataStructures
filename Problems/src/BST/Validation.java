package BST;

public class Validation {
//  isBST(4,3,5)
	/* TREE :   
	              5
	       2               10
	    1     3        7       20
	-10         4   6     8    
	*/
  public static boolean isBST(BST bst) {
	  Node root = bst.getRoot();
    if(root == null)
      return true;
    return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  /*
    1. If left child and right child is null return true
    2. If left is null and right not null
      2.1 if !isBST(right,data,max) then return false
    3. if left is not null and right is null
      3.1 if !isBST(left,min,data) then return false
    4. if both left and right are not null
      4.1 if data < min || data > max then return false
    5. return true
     
  */
  private static boolean isBSTHelper(Node current, int min, int max) {
    if(current.getLeftChild() != null) {
      if(current.getLeftChild().getData() < min || !isBSTHelper(current.getLeftChild(), min, current.getData()))
        return false;
    }
    if(current.getRightChild() != null) {
      if(current.getRightChild().getData() > max || !isBSTHelper(current.getRightChild(), current.getData(), max))
        return false;
    }
    if(current.getData() < min || current.getData() > max)
      return false;    
    return true;
  }
////////////////////////////////////////////////////////////////////////////
  public static boolean isBSTOhterApproach(BST bst) {
	  Node root = bst.getRoot();
    return isBSTHelperOther(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private static boolean isBSTHelperOther(Node current, int min, int max) {
	  if(current == null)
		  return true;
	  int data = current.getData();
	  if(data > min && data < max && isBSTHelperOther(current.getLeftChild(), min, data)  && isBSTHelperOther(current.getRightChild(), data, max))
		  return true;
	  return false;
  }
  ///////////////////////////////////////////////////////////////////////////
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
	    
	    System.out.println(isBST(bst));
	    System.out.println(isBSTOhterApproach(bst));
	    
	    bst.modify();
	    System.out.println(isBST(bst));
	    System.out.println(isBSTOhterApproach(bst));
	}

}
