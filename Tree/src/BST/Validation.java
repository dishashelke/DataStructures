package BST;

import java.util.Stack;

public class Validation {
//  isBST(4,3,5)
	/* TREE :   
	              5
	       2               10
	    1     3        7       20
	-10         4   6     8    
	*/
  public static boolean isBST(BST bst) {
	  BSTNode root = bst.getRoot();
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
  private static boolean isBSTHelper(BSTNode current, int min, int max) {
    if(current.left() != null) {
      if(current.left().data() < min || !isBSTHelper(current.left(), min, current.data()))
        return false;
    }
    if(current.right() != null) {
      if(current.right().data() > max || !isBSTHelper(current.right(), current.data(), max))
        return false;
    }
    if(current.data() < min || current.data() > max)
      return false;    
    return true;
  }
//*********************isBST***************************
  public static boolean isBSTOhterApproach(BST bst) {
	  BSTNode root = bst.getRoot();
    return isBSTHelperOther(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private static boolean isBSTHelperOther(BSTNode current, int min, int max) {
	  if(current == null)
		  return true;
	  int data = current.data();
	  if(data > min && data < max && isBSTHelperOther(current.left(), min, data)  && isBSTHelperOther(current.right(), data, max))
		  return true;
	  return false;
  }
  /*
	 * Given a preorder traversal determine is it is a valid BST
	 * Ex. preorder:1,2,4,3,5 is a valid BST
	 * 		1
	 * 			2
	 * 				4
	 * 			3		4
	 *      preorder: 1,3,4,2 is not a valid BST
	 *      		1
	 *      			3
	 *      				4
	 *      			2 
	 */
	public static boolean isValidPreorder(int[] treeOrder){
		int lowerbound = 0;//assume the tree contains positive integer nodes
		Stack<Integer> hierarchy = new Stack<Integer>();
		
		for(int node: treeOrder){
			if(lowerbound != 0 && node < lowerbound)
				return false;
			while(!hierarchy.isEmpty() && node > hierarchy.peek())
				lowerbound = hierarchy.pop();
			hierarchy.push(node);
		}
		return true;
	}
  //*************************************************************
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
	    
	    int[] validBSTOrder = {1, 2, 4, 3, 5};
		int[] invalidBSTOrder = {1, 3, 4, 2};
		System.out.println("validBSTOrder is valid BST="+isValidPreorder(validBSTOrder));
		System.out.println("invalidBSTOrder is a valid BST="+isValidPreorder(invalidBSTOrder));
	}

}
