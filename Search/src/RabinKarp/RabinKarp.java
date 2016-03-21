package RabinKarp;

public class RabinKarp {
	
	private static int hash(String string) {
		int hash = 0;
		for (int i = 0; i < string.length(); i++)
			hash += string.charAt(i);
		return hash;
	}

	private static int rolledHash(char newChar, char oldChar, int oldHash) {
		return (oldHash - oldChar + newChar);
	}
	
	public static int substring(String text, String pattern){
		int hPattern = hash(pattern);
		int hText = hash(text.substring(0, pattern.length()));
		for(int i = 0 ; i < (text.length() - pattern.length() + 1) ; i++){
			if(hPattern == hText){//check if strings match
				if(pattern.equals(text.substring(i, i+pattern.length())))
					return i;
			}
			hText = rolledHash(text.charAt(i+pattern.length()), text.charAt(i), hText);
		}
		return -1;
	}

	public static void main(String[] args) {
		String text = "However, there are two";
		String pattern = "However";
		System.out.print(substring(text, pattern));
	}

}
