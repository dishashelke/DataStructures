package DoublyLL;


public class Node<T> {

	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	public Node()
	{
		next = null;
		prev = null;
	//	this((T)new Integer(0),null);
	}
	public Node(T data)
	{
		this(data,null,null);
	}
	public Node(T data, Node<T> next, Node<T> prev)
	{
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public T getData()
	{
		return data;
	}
	public Node<T> getNext()
	{
		return next;
	}
	public Node<T> getPrev()
	{
		return prev;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	public void setPrev(Node<T> prev)
	{
		this.prev = prev;
	}
	public void insertNext(T data)
	{
		Node<T> newNode = new Node<T>(data,next,this);
		next = newNode;
	}
	//insertPrev??
}
