package queue;
import DoublyLL.DLL;

public class MyQueue<T> {

	DLL<T> queue;
	public MyQueue()
	{
		queue = new DLL<T>();
	}
	
	public void enqueue(T data)
	{
		queue.insertLast(data);
	}
	public T dequeue()
	{
		return queue.deleteFirst();
	}
	public void print()
	{
		queue.print();
	}
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.print();
		
		queue.dequeue();
		queue.print();
		System.out.print("\ndequeue:"+queue.dequeue());
		queue.print();
	}

}
