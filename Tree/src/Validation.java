import java.util.Stack;


public class Validation {
	
	/*
	 * Given a preorder traversal determine is it is a valid BST
	 * Ex. preorder:1,2,4,3,5 is a valid BST
	 *      preorder: 1,3,4,2 is not a valid BST 
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
	
	public static void main(String[] args) {
		int[] validBSTOrder = {1, 2, 4, 3, 5};
		int[] invalidBSTOrder = {1, 3, 4, 2};
		System.out.println("validBSTOrder is valid BST="+isValidPreorder(validBSTOrder));
		System.out.println("invalidBSTOrder is a valid BST="+isValidPreorder(invalidBSTOrder));
	}

}