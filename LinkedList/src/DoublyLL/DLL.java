package DoublyLL;

public class DLL<T> {
	private Node<T> head;
	public DLL()
	{
		head = null;
	}
	public DLL(T data)
	{
		Node<T> newNode = new Node<T>(data);
		head = newNode;
	}
	public void insertFirst(T data)
	{
		Node<T> newNode = new Node<T>(data,head,null);	
		if(head != null)
			head.setPrev(newNode);
		head = newNode;	
	}
	public void insertLast(T data)
	{
		Node<T> newNode = new Node<T>(data);
		Node<T> current = head;
		if(current!=null)
		{
			for(;current.getNext() != null; current=current.getNext());
			newNode.setPrev(current);
			current.setNext(newNode);
		}			
		else
			head = newNode;
	}
	public T deleteFirst()
	{//heandle this case: if list has only 1 element
		Node<T> node = head;
		head = head.getNext();
		if(!isEmpty())
			head.setPrev(null);
		return node.getData();
	}
	public void deleteLast()
	{
		Node<T> current = head;
		if(current.getNext()!= null)
		{
			for(; current.getNext().getNext() != null; current=current.getNext());		
			current.setNext(null);
		}
		else
			head = null;
	}
	public boolean isEmpty()
	{
		return (head==null);
	}
	public void print()
	{
		Node<T> current = head;
		System.out.print("\n[List]: ");
		for(; current != null; current = current.getNext())
		{
			System.out.print(current.getData()+" ");			
		}		
	}
	public static void main(String[] args) {
		DLL<Integer> list = new DLL<Integer>();
		/*list.insertFirst(10);
		list.insertFirst(20);
		list.insertFirst(30);
		list.print();
		*/
		//list.deleteFirst();
		System.out.print("\nIs Empty list:"+list.isEmpty());
		list.insertLast(40);		
		list.insertLast(50);
		list.print();
		list.deleteLast();
		list.print();
	}

}
