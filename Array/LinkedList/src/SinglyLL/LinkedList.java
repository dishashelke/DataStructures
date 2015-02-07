package SinglyLL;


public class LinkedList<T> {
	
	private Node<T> head;
	
	public LinkedList()
	{
		head = null;
	}
	public LinkedList(T data)
	{
		Node<T> newNode = new Node<T>(data);
		head = newNode;
	}
	public void insertFisrt(T data)//change,create node in this fn
	{
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(head);
		head = newNode;
	}
	public void insertLast(T data)
	{
		Node<T> current= head;
		for(; current.getNext() != null; current=current.getNext());
		//iter.setLink(newNode);
		current.insertNext(data);
	}
	public void deleteFirst()
	{
		if(head != null)
			head = head.getNext();
		else
			System.out.println("[EXCEPTION]:Empty list");
	}
	public void deleteLast()
	{
		Node<T> current;
		for(current = head; current.getNext().getNext() != null; current=current.getNext());
		current.setNext(null);
	}
	public void printList()
	{
		System.out.print("[LinkedList]:");
		for(Node<T> current = head; current != null; current=current.getNext())
		{
			System.out.print(current.getData()+" ");
		}
		System.out.println();		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> myList = new LinkedList<Integer>(10);
		//insertFirst
		myList.insertFisrt(100);	
		//insertLast
		myList.insertLast(1000);
		myList.printList();
		
		//delete first
		/*myList.deleteFirst();				
		myList.deleteLast();
		myList.printList();
		*/
	}

}
