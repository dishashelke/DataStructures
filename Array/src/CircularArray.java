/*
 * Circular array is a sorted array which is rotated, and does not have duplicates
 * Ex: 12, 14, 18, 21, 3, 6, 8, 9, rotated 4 times
 */


public class CircularArray {
	
	/*Given a circular array return index of an element else -1*/
	public static int search(int []array, int key) {
		int low = 0;
		int high = array.length-1;		
		while(low <= high){
			int mid = (high+low)/2;
			if(array[mid] == key)
				return mid;
			if(array[low] < array[mid]) {//left half sorted
				if(array[low] <= key && key < array[mid]) //key is in left half
					high = mid - 1;				
				else //key is in right half
					low = mid + 1;
			}
			else {//right half is sorted 
				if(array[mid] < key && key <= array[high]) //key is in right half
					low = mid + 1;
				else //key is in left half
					high = mid - 1;
			}
		}
		return -1;
	}
	
	/*Algorithm: Find the smallest number in an array and return the index of it
	 * case 1: element at mid index is smallest
	 * case 2:left half sorted=> search in right half
	 * case 3: right half  sorted => search in left half
	 */
	public static int findRotationCount(int []array) {
		if(array[0] <= array[array.length-1])
			return 0;
		int low = 0;
		int high = array.length - 1;
		int size = array.length - 1;
		while(low <= high) {
			int mid = array.length/2;
			int next = (mid+1) / size;
			int previous = (mid-1+size) / size;
			if(array[mid] < array[previous] && array[mid] < array[next])//mid is smallest
				return mid;
			if(array[low] < array[mid])//left half sorted
				low = mid + 1;
			else//right half sorted
				high = mid - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("element is present at:"+search(new int[]{12, 14, 18, 21, 3, 6, 8, 9}, 3));
		
		System.out.println("element is present atRotation count:"+findRotationCount(new int[]{ 14, 18, 21, 3, 6, 8, 9}));
		System.out.println("element is present atRotation count:"+findRotationCount(new int[]{3, 6, 8, 9, 14, 18, 21}));
	}

}
