import java.util.Arrays;


public class RotatedArray {
	
	public static void leftRotate(int array[], int k){
		int temp, nextIndex;
		int size = array.length;
		for(int i=0; i < gcd(size, k); i++) {
			temp = array[i];
			int j = i;
			while(true) {
				nextIndex = (j+k) % (size);//imp
				if (nextIndex == i)
					break;				
				array[j] = array[nextIndex]; 
				j = nextIndex;
			}
			array[j] = temp;
		}
	}
	
	public static void rightRotate(int array[], int k){
		int temp, nextIndex;
		int size = array.length;
		for(int i=0; i < gcd(k, size); i++) {
			temp = array[i];
			int j = i;
			while(true) {
				nextIndex = (j-k + size) % (size);//imp
				if (nextIndex == i)
					break;				
				array[j] = array[nextIndex]; 
				j = nextIndex;
			}
			array[j] = temp;
		}
	}
	
	private static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}

	public static void main(String[] args) {

		int []sortedArray = {1, 2, 3, 4, 5, 6};
		leftRotate(sortedArray, 2);
		System.out.println(Arrays.toString(sortedArray));
		
		rightRotate(sortedArray, 2);
		System.out.println(Arrays.toString(sortedArray));
	}

}
