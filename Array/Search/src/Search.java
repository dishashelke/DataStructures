public class Search {

	public static boolean linearSearch(int[] array, int key)
	{
		for(int i=0;i<array.length;i++)		
			if(array[i] == key)			
				return true;					
		return false;
	}
	public static boolean binarySearch(int[] array,int key, int min, int max)
	{
		if(min > max)
			return false;
		else
		{
			int mid = (min+max)/2;				
			if(array[mid] < key)
				return binarySearch(array, key, mid+1, max);
			else if(array[mid] > key)
				return binarySearch(array, key, min, mid-1);
			else 
				return true;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{1,4,7,23,-45,5,0};
		int key = 1;
		System.out.println("[Linear Search]Element found:"+linearSearch(array, key));
		
		int[] sortedArray = new int[]{-9999,-45,-9,-6,0,23,56,90,234,567,1111,8754,9999};
		int key2 = 8754;
		System.out.println("[Binary Search]Element found:"+binarySearch(sortedArray, key2,0,sortedArray.length));
	}

}
