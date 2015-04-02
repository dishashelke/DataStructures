package SinglyLL;

public class Node<T> {

	private T data;
	private Node<T> next;
	
	public Node()
	{
		next = null;
	//	this((T)new Integer(0),null);
	}
	public Node(T data)
	{
		this(data,null);
	}
	public Node(T data, Node<T> link)
	{
		this.data = data;
		this.next = link;
	}
	
	public T getData()
	{
		return data;
	}
	public Node<T> getNext()
	{
		return next;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	public void setNext(Node<T> link)
	{
		this.next = link;
	}
	public void insertNext(T data)
	{
		Node<T> newNode = new Node<T>(data,next);
		next = newNode;
	}
	/*public boolean hasNext(){
		return
	}*/
}
