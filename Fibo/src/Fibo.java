import java.util.Scanner;


public class Fibo {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);

		Fibo fibo = new Fibo();
		System.out.println("Enter n: ");
		int n = in.nextInt(); 
		fibo.loop(n);
		
		System.out.print("\nRecurrsive : ");
		for(int i = 0; i <= n; i++)
			System.out.print(fibo.rec(i)+" ");
	}

	public void loop(int n)
	{
		int term0 = 0, term1 = 1, term2;
		if(n >= 0)
			System.out.print(term0+" ");
		if(n >= 1)			
			System.out.print(term1+" ");
		for(int i=2; i <= n; i++)
		{
			term2 = term0 + term1;
			term0 = term1;
			term1 = term2;
			System.out.print(term2+" ");			
		}	
	}
	public int rec(int n)
	{		
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
		{			
			return (rec(n-1) + rec(n-2));		
		}
	}
}
