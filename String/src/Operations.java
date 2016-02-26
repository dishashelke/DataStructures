import java.util.Arrays;

public class Operations{
    
    //  www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    public static void permutations(char []string) {
        permute(string, 0);
    }
    private static void permute(char []string, int current) {
        if(current == string.length) {
            System.out.println(string);
            return;
        }
        for(int i=current; i<string.length; i++) {
            swap(string, i, current);
            permute(string, current+1);
            swap(string, i, current);
        }
    }
    public static void swap(char []string, int source, int destination) {
        char temp = string[source];
        string[source] = string[destination];
        string[destination] = temp;
    }

   /* public static void allPermutations(char []string) {
    	for(int i=0; i<string.length; i++) {
    		//permutations(Arrays.copyOfRange(string, 0, i));
    		for(int j=i+1; j<string.length; j++) {
    			permutations(Arrays.copyOfRange(string, i, j));
    		}
    	}
    }*/
      
     public static void main(String []args){
        permutations("abc".toCharArray());
        //allPermutations("abc".toCharArray());        
     }
}
