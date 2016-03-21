import java.util.Arrays;

import heap.MaxHeap;

public class NearlySortedArray {

	/*Time complexity=O(nlogk), logk=ht of heap
	 * Algorithm:
	 * form max heap of last k elements of given array
	 * for n-k:
	 * 	get the root of heap as it is a max element in heap of size k
	 * 	replace the root of heap with next element in unsorted array
	 * 	heapify this new heap
	 * till heap is not empty:
	 * 	remove the root of root and assign it as next max element 	 
	 */
	public static void sort(int []kSortedArray, int k) {		
		int size = kSortedArray.length;
		int []lastK = Arrays.copyOfRange(kSortedArray, size-k, size);
		MaxHeap.buildMaxHeap(lastK);
		for(int i = size-k-1; i >= 0; i--) {
			kSortedArray[i+k] = lastK[0];
			lastK[0] = kSortedArray[i];
			MaxHeap.maxHeapify(lastK, 0, lastK.length);
		}
		for(int i=k-1; i>0; i--) {
			kSortedArray[i] = lastK[0];
			MaxHeap.swap(lastK, 0, i);
			MaxHeap.maxHeapify(lastK, 0, i);
		}
	}

	public static void main(String[] args) {
		int []kSortedArray = {2, 6, 3, 12, 56, 8};
		int k = 3;
		sort(kSortedArray, k);
		System.out.println(Arrays.toString(kSortedArray));
	}

}
