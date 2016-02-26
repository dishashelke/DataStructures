/*
 * Array is sorted(increasing order) and has duplicate elements
 */

public class SortedArray {

	public static int boundryIndex(int []array, int key, boolean searchFirst) {
		int firstIndex = -1;
		int low = 0;
		int high = array.length-1;
		while(low <= high) {
			int mid = (high+low) / 2;
			if(array[mid] == key){//store the current index 
				firstIndex = mid;
				if (searchFirst)//search for more occurrences in left half
					high = mid - 1;
				else// search for more occurrences in the right part
					low = mid + 1;
			}
			else if(key < array[mid])//search in left half
				high = mid - 1;
			else//search in right half
				low = mid  + 1;
		}
		return firstIndex;
	}
	
	public static int countOccurence(int []array, int key){
		int firstIndex = boundryIndex(array, key, true);//find first occurrence
		int lastIndex = boundryIndex(array, key, false);//find the last occurrence
		if(firstIndex !=  -1)
			return lastIndex - firstIndex + 1;
		return 0;
	}
	
	public static void main(String[] args) {
		int []sortedArray = {1,2,2,3,3,3,4,4,5,5,5,6,7,7,7,7};
		
		System.out.println("first occurrence of 2 is "+boundryIndex(sortedArray, 2, true));
		System.out.println("first occurrence of 5 is "+boundryIndex(sortedArray, 5, true));
		
		System.out.println("last occurrence of 2 is "+boundryIndex(sortedArray, 2, false));
		System.out.println("last occurrence of 5 is "+boundryIndex(sortedArray, 5, false));
		
		System.out.println("total occurences of 2: "+countOccurence(sortedArray, 2));
		System.out.println("total occurences of 5: "+countOccurence(sortedArray, 5));
	}
}
