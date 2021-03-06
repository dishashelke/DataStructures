package SinglyLL;

public class LinkedList<T> {

	private Node<T> head;

	public LinkedList() {
		head = null;
	}

	public LinkedList(T data) {
		Node<T> newNode = new Node<T>(data);
		head = newNode;
	}

	public void insertFisrt(T data)// change,create node in this fn
	{
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(head);
		head = newNode;
	}

	public void insertLast(T data) {
		if(head == null) {
			head = new Node<T>(data);
			return;
		}
		Node<T> current = head;
		for (; current.getNext() != null; current = current.getNext());		
		current.insertNext(data);
	}

	public void deleteFirst() {
		if (head != null)
			head = head.getNext();
		else
			System.out.println("[EXCEPTION]:Empty list");
	}

	public void deleteLast() {
		if(!head.hasNext()) {
			head = null;
			return;
		}
		Node<T> current;
		for (current = head; current.getNext().getNext() != null; current = current
				.getNext())
			;
		current.setNext(null);
	}

	public void iterativeReverse() {
		Node<T> current = head;
		Node<T> previous = null;
		Node<T> next;
		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		head = previous;
	}

	/*
	 * Algorithm: Base case: Reached at tail node=> make tailnode as head
	 * Recurssive step: get the next node reverse the sublist starting from next
	 * node make the current node as single node(make next of current
	 * null)//else infinite list append current node to the revered list.
	 */
	public void recursiveReverse() {
		if (head == null)
			return;
		recursiveReverse(head);
	}

	public void recursiveReverse(Node<T> current) {
		if (current.getNext() == null) {// base case=> reached at tail
			head = current;
			return;
		}
		Node<T> next = current.getNext();
		recursiveReverse(next);
		next.setNext(current);
		current.setNext(null);// important
	}

	public void printList() {
		System.out.print("[LinkedList]:");
		for (Node<T> current = head; current != null; current = current
				.getNext()) {
			System.out.print(current.getData() + " ");
		}
		System.out.println();
	}

	public void recursivePrint() {
		System.out.print("RecursivePrint:");
		recursivePrint(head);
		System.out.println();
	}

	private void recursivePrint(Node<T> current) {
		if (current == null)// base condition
			return;
		System.out.print(current.getData() + ", ");
		recursivePrint(current.getNext());
	}

	public void recursiveReversePrint() {
		System.out.print("Recursive Reverse Print: ");
		recursiveReversePrint(head);
		System.out.println();
	}

	private void recursiveReversePrint(Node<T> current) {
		if (current == null)// base condition
			return;
		recursiveReversePrint(current.getNext());
		System.out.print(current.getData() + ", ");
	}

	public static void main(String[] args) {
		LinkedList<Integer> myList = new LinkedList<Integer>(10);
		myList.insertFisrt(100);
		myList.insertLast(1000);
		myList.printList();

		// delete first
		/*
		 * myList.deleteFirst(); myList.deleteLast(); myList.printList();
		 */

		// reverse list
		myList.iterativeReverse();
		myList.recursivePrint();
		LinkedList<Integer> emptyList = new LinkedList<Integer>();
		emptyList.iterativeReverse();
		emptyList.printList();

		myList.recursiveReverse();
		myList.printList();

		// print reverse list
		myList.recursiveReversePrint();
	}

}
