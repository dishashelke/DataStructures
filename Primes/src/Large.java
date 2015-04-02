
public class Large {

	public static void large()
	{
		int base = 10000 + 1;
		int mod, prevRem = 0;
		boolean isPrime = true;
		while(isPrime == true)
		{		
			for(int i = 3; i<base; i=i+2)
			{
				mod = base%i ;
				if((mod == 0))
					isPrime = false;
				prevRem = mod;				
			}
			base = base + 2;
		}
		System.out.print(base);
	}
	public static void main(String[] args) {
		large();

	}

}
