package BinaryTree;

class Sum {
	public int value;
}

/*
			7
	15          5
9      8    9      7
*/
public class Operations {

	/*
	 * Given a binary tree find a path with maximum path sum. Path may start and end at any node(not necessary to start or end at leaf or root)
	 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	 * For each node there can be four ways that the max path goes through the node:
	 * 1. Node only
	 * 2. Max path through Left Child + Node
	 * 3. Max path through Right Child + Node
	 * 4. Max path through Left Child + Node + Max path through Right Child
	 */
	public static int maxSumOfPath(BinaryTree tree) {
		Sum maxSum = new Sum();
		maxSum.value = Integer.MIN_VALUE;
		BinaryNode root = tree.getRoot();
		maxSumOfPath(root, maxSum);
		return maxSum.value;
	}
	private static int maxSumOfPath(BinaryNode current, Sum maxSum) {
		if(current == null)
			return 0;
		int leftSum = maxSumOfPath(current.getLeftChild(), maxSum);
		int rightSum = maxSumOfPath(current.getRightChild(), maxSum);
		int maxSingle = Math.max(Math.max(leftSum, rightSum) + current.getData(), current.getData());
		int maxTop = Math.max(maxSingle, leftSum + current.getData() + rightSum);
		maxSum.value = Math.max(maxSum.value, maxTop);
		return maxSingle;
	}
	
	/*
	 * find sum of all left leaves
	 */
	public static int sumLeftLeaves(BinaryTree tree) {
		BinaryNode root = tree.getRoot();
		return sumLeftLeaves(root, false);
	}
	private static int sumLeftLeaves(BinaryNode current, boolean leftNode) {
		if(current == null)
			return 0;
		if(current.isLeaf() && leftNode)
			return current.getData();
		return sumLeftLeaves(current.getLeftChild(), true) + sumLeftLeaves(current.getRightChild(), false);
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.createTree();
		
		System.out.println("Max sum of the path:"+maxSumOfPath(tree));
		
		System.out.println("Sum of left leaves:"+sumLeftLeaves(tree));
	}
}