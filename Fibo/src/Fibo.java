import java.util.Scanner;

public class Fibo {
//1 2 3 4 5 6  7
//	1 1 2 3 5 8 13

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Scanner in = new Scanner(System.in);

		Fibo fibo = new Fibo();
		System.out.println("Enter n: ");
		int n = in.nextInt();
		fibo.iterative(n);

		System.out.print("\nRecurrsive : ");
		for (int i = 0; i <= n; i++)
			System.out.print(fibo.recursive(i) + " ");*/
		
		System.out.println(getNth(7));
	}

	/* print first n fibo nos */
	public void iterative(int n) {
		int term0 = 0, term1 = 1, term2;
		if (n >= 0)
			System.out.print(term0 + " ");
		if (n >= 1)
			System.out.print(term1 + " ");
		for (int i = 2; i <= n; i++) {
			term2 = term0 + term1;
			term0 = term1;
			term1 = term2;
			System.out.print(term2 + " ");
		}
	}
	
	public static int getNth(int n){
		if(n < 1)
			return -1;
		if(n == 1 || n == 2)
			return 1;
		int term1 = 1;
		int term2 = 1;
		int currentTerm = 0;
		int terms = 2;
		while(terms < n) {
			currentTerm = term1 + term2;
			term1 = term2;
			term2 = currentTerm;
			terms++;
		}
		return currentTerm;
	}

	public int recursive(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return (recursive(n - 1) + recursive(n - 2));

	}
}
