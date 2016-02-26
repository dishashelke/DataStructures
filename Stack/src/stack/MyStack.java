package stack;
 
public class MyStack<T> {
	
	private T stack[];
	private int size;
	private int top;
	
	public MyStack(int s) {
		// TODO Auto-generated constructor stub
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

	public int prefix(String exp)
	{
		//MyStack<Integer> operands = new MyStack<Integer>(2);
		int op1, op2, result;
		int opcount = 0;
		char operator;
		for(int i=0; i < exp.length(); i++)
		{
			char c = exp.charAt(i);
			push((T)new Character(c));
			if(! ((c == '+') || (c == '-') || (c == '*') || (c == '/')) )
				opcount++;
			if(opcount == 2)
			{
				/*op2 = (Integer)(pop()) - 48;
				op1 = (Integer)(pop()) - 48;*/
				op2 = (Integer) pop();
				op1 = (Integer)pop();
				operator = ((Character)pop()).charValue();
				if(operator == '+')
					result = op1 + op2;
				else if(operator == '-')
					result = op1 - op2;
				else if(operator == '*')
					result = op1 * op2;
				else
					result = op1 / op2;
				push((T)new Character((char) result));
				opcount = 1;
			}			
		}
		return (Integer)getTop();
	}
	public int postfix(String exp)
	{
		for(int i=0; i < exp.length(); i++)
		{
			int op1, op2;
			char c = exp.charAt(i);			
			if((c == '+') || (c == '-') || (c == '*') || (c == '/'))
			{
				System.out.println("c:"+c);
				print();
				op2 = (Integer)(pop());
				op1 = (Integer)(pop());
				if(c == '+')
					push((T) new Integer(op1+op2));
				else if(c == '-')
					push((T) new Integer(op1-op2));
				else if(c == '*')
					push((T) new Integer(op1*op2));
				else
					push((T) new Integer(op1/op2));
			}
			else
			{				
				push((T)new Integer(c-48));
			}
		}
		return (Integer)getTop();
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
		
		/*System.out.println("PREFIX:");
		MyStack<String> prefix_stack = new MyStack<String>(20);
		String infix_exp = "*+93/42";
		System.out.println("Result : "+infix_stack.prefix(infix_exp));*/
		
		System.out.println("POSTFIX:");
		MyStack<Integer> postfix_stack = new MyStack<Integer>(20);
		String postfix_exp = "93+42/11++*";//"93+42/*";
		System.out.println("Result : "+postfix_stack.postfix(postfix_exp));		
	}
}
