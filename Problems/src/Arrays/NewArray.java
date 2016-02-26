package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class NewArray {
/*
 * 1. quickselect
 * 2. randomized quicksort-time complexity?
 */
	
	/*
	 * Given sorted array and a number, find if sum of any two elements in array is equal to that number 
	 */
	public static void hasSum(int [] sortedArray, int desiredSum) {
		boolean pairFound = false;
		int low,hi;
		low = 0;
		hi = sortedArray.length - 1;
		while(low < hi) {
			int sum = sortedArray[low] + sortedArray[hi];
			if(sum == desiredSum) {
				System.out.println("Elements are:"+sortedArray[low]+", "+sortedArray[hi]);
				pairFound = true;
			}
			if(sum > desiredSum)
				hi--;
			else
				low++;
		}
		if(low==hi && !pairFound)
		System.out.println("No such elements are present in an array");
	}
	/*
	 * find k smallest elements, if k=3, then return 3smallest elemets , Ex 4,6,1,9 and k=2 print 4, 1
	 */
	public static void printElements(int []array) {
		for(int each: array)
			System.out.print(each+", ");
	}
	public static void swap(int []array, int source, int destination) {
		int temp = array[source];
		array[source] = array[destination];
		array[destination] = temp;
	}
	public static int partition(int []array, int low, int hi) {
		int pivote = array[low];
		int storeIndex = low;
		swap(array, low, hi);
		while(low < hi-1) {
			if(array[low] < pivote) {
				swap(array, storeIndex, low);
				storeIndex++;
				low++;
			}
		}
		swap(array, storeIndex, hi);
		return storeIndex;
	}
	public int kSelect(int []array, int low, int hi, int k) {
		if(low == hi)
			return array[low];
		int pivoteIndex = partition(array, low, hi);
		if(pivoteIndex == k){
			return array[pivoteIndex];
		}
		else if (pivoteIndex > k)
			return kSelect(array, low, pivoteIndex-1, k);
		else
			return kSelect(array, pivoteIndex+1, hi, k);		
	}
	/////////////////////////////////////////////
	
	public static void main(String[] args) {		
		int[] sortedArray = {-10, -5, -4, -3, 0, 3, 7, 8, 12};
		hasSum(sortedArray, 8);
		hasSum(sortedArray, 18);
	}

}
