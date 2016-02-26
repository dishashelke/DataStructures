import java.util.HashMap;
import java.util.Set;


public class MyString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string = "abcAcba";
		System.out.println("Reversed string :"+reverse(string));
		System.out.println("f found at : "+ occurance(string, 'z'));
		System.out.println("Uppercase : "+ uc(string));
		System.out.println("palindrome : "+pali(string));
		System.out.println("After deleting vowels : "+delvow(string));
		System.out.print("\nCompressed String : "+compress("aaabbbbcccccd"));		
		System.out.print("\nWord count: "+wordCount("d g	jhjk 	"));
	}

	public static String reverse(String string)
	{
		String reverse = "";
		for(int i = string.length()-1; i >= 0 ; i--)
			reverse = reverse + string.charAt(i);
		return reverse;
		
		/*Using StringBuilder
		 * StringBuilder reverse = new StringBuilder();
		 * for(int i=0; i<string.length(); i++) {
		 * 	reverse.insert(0, string.charAt[i]);
		 * }
		 * return reverse.toString();		 
		 */
	}
	//public static revrec(String string)
	public static int occurance(String string, char ch)
	{
		for(int i = 0; i< string.length(); i++)
			if(string.charAt(i) == ch)
				return i;
		return -1;
	}
	
	public static String uc(String string)
	{
		String uc = "";
		for(int i=0; i<string.length();i++)
		{	if(string.charAt(i)>= 97 && string.charAt(i) <= 122)
				uc += (char)(string.charAt(i) - 32);
			else
				uc += string.charAt(i);
		}
		return uc;
	}
	public static boolean pali(String string)
	{
		return string.equals(reverse(string));			
	}
	public static String delvow(String string)
	{
		String newStr = "";
		String vowels = "aeiouAEIOU";
		char ch;
		for(int i=0; i < string.length(); i++)
		{
			ch = string.charAt(i);
			if(!vowels.contains(ch+""))
				newStr += string.charAt(i);			
		}
		return newStr;
	}
	public static String compress(String string)
	{
		String newString = "";
		Character prev = string.charAt(0);
		int counter = 1, i;
		Character curr;
		for( i= 1; i<string.length();i++) {
			curr = string.charAt(i);
			if( (Character.toUpperCase(prev)) == Character.toUpperCase(curr))
				counter++;
			else{
				newString += prev + ((counter > 1)?Integer.toString(counter):"");
				counter = 1;
			}
			prev = curr;
		}	
		newString += prev + ((counter > 1)?Integer.toString(counter):"");
		return newString;
	}

	public static int wordCount(String string){
		int count = 0;
		Boolean word = false;
		for(int i =0; i< string.length(); i++){
			if(string.charAt(i) == '\n' || string.charAt(i) == '\t' || string.charAt(i) == ' ')
				word = false;
			else if(!word){
				word = true;
				count++;
			}
		}
		return count;
		//return string.split("\\s+").length;
	}
}
