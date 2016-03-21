

import java.util.Arrays;
import java.util.Collections;

public class KSmallest {
/*
 * 1. quickselect
 * 2. randomized quicksort-time complexity?
 */
	
	
	/* Time complexity=O(n)
	 * find k smallest elements, if k=3, then return 3smallest elemets , Ex 4,6,1,9 and k=2 print 4, 1
	 */
	
	public static void swap(int []array, int source, int destination) {
		int temp = array[source];
		array[source] = array[destination];
		array[destination] = temp;
	}
	public static int partition(int []array, int low, int hi) {
		int pivote = array[low];
		int storeIndex = low;
		swap(array, low, hi);
		while(low < hi) {
			if(array[low] < pivote) {
				swap(array, storeIndex, low);
				storeIndex++;				
			}
			low++;
		}
		swap(array, storeIndex, hi);
		return storeIndex;
	}
	
	public static int[] kSelect(int[] array, int key) {
		if(array.length == 0 || key ==  0)
			return new int[]{};
		return kSelect(array, 0, array.length-1, key);
	}
	public static int[] kSelect(int[] array, int low, int hi, int k) {
		if(low == hi)						
			return Arrays.copyOfRange(array, 0, low+1);
		int pivoteIndex = partition(array, low, hi);
		if(pivoteIndex == k){
			return Arrays.copyOfRange(array, 0, pivoteIndex);
		}
		else if (pivoteIndex > k)
			return kSelect(array, low, pivoteIndex-1, k);
		else
			return kSelect(array, pivoteIndex+1, hi, k);		
	}
	
	public static void main(String[] args) {		
		int []array = {10, 5, 9, -8, 56, -4};
		System.out.println("first k smallest elements:"+Arrays.toString(kSelect(array, 0)));
		System.out.println("first k smallest elements:"+Arrays.toString(kSelect(array, 1)));
		System.out.println("first k smallest elements:"+Arrays.toString(kSelect(array, 4)));
		System.out.println("first k smallest elements:"+Arrays.toString(kSelect(array, 7)));
	}

}
