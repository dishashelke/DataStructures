package stack;
 
public class MyStack<T> {
	
	private T stack[];
	private int size;
	private int top;
	
	public MyStack(int s) {
		stack = (T[])new Object[s];
		size = s;
		top = -1;
	}
	public void push(T element)
	{
		if(!isFull())
			stack[++top] = element;		
		else 
			throw new IndexOutOfBoundsException("Stack is full cannot push more!!");
	}
	public T pop()
	{		
		if(isEmpty())
			throw new IndexOutOfBoundsException("Stack is empty cannot pop!!");
		else
			return stack[top--];
	}
	public T getTop()
	{
		return stack[top];
	}
	public boolean isEmpty()
	{
		return (top == -1);		
	}
	public boolean isFull()
	{
		return (top == (size - 1));
	}
	public void print()
	{
		System.out.println("Stack : ");
		for(int i = 0; i <= top ; i++)
			System.out.print(stack[i]+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		/*MyStack stack = new MyStack(5);
		stack.push(23);
		stack.push(2300);
		stack.push(10);
		stack.push(300);
		stack.push(1300);
	//	stack.push(30);
		stack.print();
		System.out.println("top :"+stack.top());
		System.out.println("after poping 2 elems");
		stack.pop();stack.pop();
		stack.print();
		System.out.println("top :"+stack.top());
		/*
		/*MyStack empty_stack = new MyStack(5);
		System.out.println(empty_stack.isEmpty());
		
		MyStack full_stack = new MyStack(5);
		//System.out.println(stack.length);
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			full_stack.push(2223);
			System.out.println(i);
		}
		System.out.println(full_stack.isFull());
		*/			
		
	}
}
