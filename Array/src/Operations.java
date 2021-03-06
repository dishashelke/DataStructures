import java.util.HashMap;
import java.util.Map;

public class Operations {
	
	// array of n elements contains elements from 0 to n-1, with any of these numbers appearing any number of times.
	//Find these repeating numbers in O(n) and using only O(1) memory space.
	public static void printRepeated(int... array) {
		for(int i = 0; i < array.length; i++) {
			if(array[Math.abs(array[i])] >= 0) {
				array[Math.abs(array[i])] =  -array[Math.abs(array[i])];
			}
			else {
				System.out.print(Math.abs(array[i])+" ");
			}
		}
	}
	
	/*	 Print the pair in an array having same sum6 */
	public static void equalSumPair(int... array) {
		Map<Integer, int[]> mapping = new HashMap<Integer, int[]>();
		for(int i = 0; i < array.length; i++) {
			for(int j=i+1; j < array.length; j++) {
				int sum = array[i] + array[j];
				if(mapping.containsKey(sum)) {
					int pair[] = mapping.get(sum);
					System.out.println("\n["+pair[0]+","+ pair[1]+"] = ["+array[i]+","+array[j]+"]");
					return;
				}
				else {
					mapping.put(sum,new int[]{ array[i], array[j]});
				}
			}
		}
	}
	
	public static void symmetricPair(int array[][]) {
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		
		for(int row=0; row < array.length; row++) {
			int key = array[row][0];
			int value = array[row][1];
			if(pairs.containsKey(value) && pairs.get(value) == key) {
				System.out.println("symmetric pair:"+value+", "+key);
			}
			else {
				pairs.put(key, value);
			}
		}
	}
	
	/*the element before which all the elements are smaller than it, and after which all are greater*/
	public static int minMax(int array[]){
		int leftMax[] = new int[array.length];
		int[] rightMin = new int[array.length];
		leftMax[0] = array[0];
		for(int i=1; i<array.length; i++) {
			leftMax[i] = Math.max(leftMax[i-1], array[i]);
		}

		rightMin[array.length - 1] = array[array.length-1];
		for(int i = array.length-2; i > -1; i--){
			rightMin[i] = Math.min(rightMin[i+1], array[i]);
		}
		
		for (int i=0; i<array.length; i++) {			
			if(leftMax[i] ==  rightMin[i]) {
				return leftMax[i];
			}
		}
		return -1;
	}
	
	public static void printSpiral(int [][]matrix) {
		int rows = matrix.length - 1;
		int columns = matrix[0].length - 1;
		int topRow = 0, bottomRow = rows;
		int leftColumn = 0, rightColumn = columns;
		while(topRow <= bottomRow && leftColumn <= rightColumn) {
			//print topmost row
			for(int i = leftColumn; i <= rightColumn; i++)
				System.out.print(matrix[topRow][i]+", ");
			topRow++;
			//print rightmost column
			for(int i = topRow; i <= bottomRow; i++)
				System.out.print(matrix[i][rightColumn]+", ");
			rightColumn--;
			//print bottom row
			if(topRow <= bottomRow){
				for(int i=rightColumn; i >= leftColumn; i--)
					System.out.print(matrix[bottomRow][i]+", ");
				bottomRow--;
			}
			//print leftmost column
			if(leftColumn <= rightColumn) {
				for(int i=bottomRow; i >=topRow; i--)
					System.out.print(matrix[i][leftColumn]+", ");
				leftColumn++;
			}
		}
	}

	public static void main (String args[]) {
		printRepeated(new int[]{2, 6, 3, 1, 6, 1,3});
		
		equalSumPair(new int[]{3, 4, 7, 1, 2, 9, 8});
		
		symmetricPair(new int[][]{{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}});
		
		System.out.println("element before which all the elements are smaller than it, and after which all are greater: "+minMax(new int[]{5, 1, 4, 3, 6, 8, 10, 7, 9}));		
		
		int [][]matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9, 10,11,12}};
		printSpiral(matrix);//1,2,3,4,8,12,11,10,9,5,6,7
	}
}
