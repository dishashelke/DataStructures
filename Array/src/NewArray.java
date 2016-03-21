import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class NewArray {

	//private int array[] = {5,3,7,6,1};
	private int array[];
	
	public NewArray() {			
		array = new int[5];
		array[0] = 5;
		array[1] = 3;
		array[2] = 7;
		array[3] = 6;
		array[4] = 1;
	}
	
	public static void main(String[] args) {

		NewArray array = new NewArray();

		System.out.println("Original Array : ");
		array.print();
		System.out.println("Max : " + array.max());
		System.out.println("Min : " + array.min());
		System.out.println("Avg : " + array.avg());
		NewArray revArray = array.rev();
		System.out.println("Rev : ");
		revArray.print();
		System.out.println("Second Largest : " + array.secondLargest());
		System.out.println("Second Smallest : " + array.secondSmallest());
		System.out.println("Primes numbers in array : ");
		array.printPrimes();
		System.out.print("\nAfter removing duplicate elements: ");
		remDuplicates(new int[] { 3, 6, 2, 7, 3, 6, 7 });
		System.out.print("\nCommon elements: ");
		commonElements(new int[] { 3, 7, 23, 6 }, new int[] { 0, 6, 45, 23 });
		System.out.print("\nReversed array :");
		array.reverse();
		array.print();
	}

	public void print() {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public int max() {
		int max = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] > max)
				max = array[i];
		return max;
	}

	public int min() {
		int min = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] < min)
				min = array[i];
		return min;
	}

	public float avg() {
		int sum = 0;
		for (int i = 0; i < array.length; i++)
			sum += array[i];
		return (((float) sum / (array.length)));
	}

	public void indexValue(int index, int value) {
		array[index] = value;
	}

	public NewArray rev() {
		int size = array.length;
		NewArray revArray = new NewArray();
		for (int i = 0; i < size; i++)
			revArray.indexValue((size - (i + 1)), (array[i]));
		return revArray;
	}

	public void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void reverse() {
		for (int i = 0; i < array.length / 2; i++)
			swap(i, array.length - 1 - i);
	}

	public int secondLargest() {
		int largest = array[0], secondLargest = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > largest) {
				secondLargest = largest;
				largest = array[i];
			} else if (array[i] > secondLargest)
				secondLargest = array[i];
		}
		return secondLargest;
	}

	public int secondSmallest() {
		int smallest = array[0], secondSmallest = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < smallest) {
				secondSmallest = smallest;
				smallest = array[i];
			} else if (array[i] < secondSmallest)
				secondSmallest = array[i];
		}
		return secondSmallest;
	}

	public void printPrimes() {
		int j;
		for (int i = 0; i < array.length; i++) {
			for (j = 2; j <= (array[i] / 2); j++)
				if ((array[i] % j) == 0)
					break;
			if (j > array[i] / 2)
				System.out.print(array[i] + " ");
		}
	}

	public static void remDuplicates(int[] array) {
		Set<Integer> set = new HashSet<Integer>();
		for (Integer x : array)
			set.add(x);
		System.out.print(set);
	}

	public static void commonElements(int[] array1, int[] array2) {
		List<Integer> common = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (Integer x : array1)
			set.add(x);
		for (Integer x : array2) {
			if (set.contains(x))
				common.add(x);	
		}
		System.out.print(common);
	}
}
