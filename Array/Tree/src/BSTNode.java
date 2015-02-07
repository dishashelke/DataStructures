/**
 * @author Disha
 *
 *This class is 
 * @param <T>
 */
public class BSTNode<T> {
	private T data;
	private BSTNode<T> leftChild;
	private BSTNode<T> rightChild;

	BSTNode(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public T getData() {
		return this.data;
	}

	public BSTNode<T> getLeftChild() {
		return this.leftChild;
	}

	public BSTNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * compares
	 * @param data
	 */
	public void add(T data) {
		if ((Integer) data < (Integer) this.data)
			if (leftChild == null)
				leftChild = new BSTNode<T>(data);
			else
				leftChild.add(data);
		else if (rightChild == null)
			rightChild = new BSTNode<T>(data);
		else
			rightChild.add(data);
	}

	public boolean search(T data) {
		if (this.data == data)
			return true;
		else if (((Integer) data < (Integer) this.data) && (leftChild != null))
			return leftChild.search(data);
		else if (((Integer) data > (Integer) this.data) && (rightChild != null))
			return rightChild.search(data);
		else
			return false;
	}

	public void postOrder() {
		if (leftChild != null)
			leftChild.postOrder();
		if (rightChild != null)
			rightChild.postOrder();
		System.out.print(this.getData() + " ");
	}
}
