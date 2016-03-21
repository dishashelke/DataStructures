package heap;
import java.util.Arrays;

//also implement minHeap

public class MaxHeap {

	public final static void swap(int[] array, int src, int dest) {
		int temp = array[src];
		array[src] = array[dest];
		array[dest] = temp;
	}

	public static int left(int i){
		return 2*i+1;
	}
	public static int right(int i){
		return 2*i+2;
	}
	public static void maxHeapify(int array[], int i, int size){
		int left = left(i);
		int right = right(i);
		int largest = i;// largest store the index of largest element amongst the parent and its 2 children
		if((left < size) && (array[left] > array[largest]))
			largest = left;
		if((right < size) && (array[right] > array[largest]))
			largest = right;
		if(largest != i){
			swap(array, i, largest);
			maxHeapify(array, largest, size);
		}
	}
	public static void buildMaxHeap(int array[]){
		for(int i = array.length/2+1 ; i > -1 ; i--){
			maxHeapify(array, i, array.length);
		}
	}

	public static void heapSort(int array[]){
		buildMaxHeap(array);
		for(int i =  array.length - 1; i > -1 ; i--){
			swap(array, 0 , i);
			maxHeapify(array, 0, i);// last element is max so reduce array size by 1
		}
	}

	public static int parent(int i) {
		return (i - 1)/2;
	}
	/*
	 * valid heap: 10,			   10
	 * 								8				6
	 */
	public static boolean isMaxHeap(int []heap) {
		if(heap.length == 0)
			return true;
		return isMaxHeap(heap, 0);
	}
	public static boolean isMaxHeap(int []heap, int currentIndex) {
		int parentIndex = parent(currentIndex);
		int leftIndex = left(currentIndex);
		int rightIndex = right(currentIndex);
		if(parentIndex < 0 || currentIndex > heap.length-1)//if root or node not in heap
			return true;
		if(heap[currentIndex] > heap[parentIndex])
			return false;
		return isMaxHeap(heap, leftIndex) && isMaxHeap(heap, rightIndex);
	}	

	public static void main(String[] args) {
		int array[] = {20, 30, 10, 18, 15, 12, 9};
		buildMaxHeap(array);
		System.out.print("Max heap: "+Arrays.toString(array));		
		
		int array1[] = {-45,20,0, 30, 10, 18, 15, 12, 9,-1,45};
		heapSort(array1);
		System.out.print("\nSorted Elements: "+ Arrays.toString(array1));	
		
		System.out.println("\n"+Arrays.toString(array)+" is max heap:"+isMaxHeap(array));
		array[1] = -3;
		System.out.println("\n"+Arrays.toString(array)+" is max heap:"+isMaxHeap(array));
	}

}
