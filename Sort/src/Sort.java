import java.util.Arrays;


public class Sort {

	public static final void swap(int[] array, int src, int dest)
	{
		int temp = array[src];
		array[src] = array[dest];
		array[dest] = temp; 
	}
	
	public static int[] bubble(int[] array)
	{
		for(int cnt = 0; cnt < (array.length-1); cnt++)	
			for(int pos = 0; (pos< array.length-1-cnt); pos++)			
				if(array[pos] > array[pos+1])
					swap(array, pos, pos+1);					
		return array;
	}

	public static int[] insertion(int []array){
		for(int i=1; i<array.length; i++){
			int j = i;
			while(j > 0 && array[j] < array[j-1]){
				swap(array, j, j-1);
				j--;
			}
		}
		return array;
	}
	// starting merge sort
	public static int[] mergeSort(int[] array){
		int arraySize = array.length;
		if (arraySize > 1){
			int mid =  arraySize / 2;
			int[] leftPart = (Arrays.copyOfRange(array, 0, mid));//(array, 0, mid);
			int[] rightPart = (Arrays.copyOfRange(array, mid, arraySize));//(array,mid+1, arraySize);			
			mergeSort(leftPart);
			mergeSort(rightPart);
			merge(leftPart,rightPart,array);
			//array =  merge(leftPart, rightPart);
		}
		return array;
	}
	public static void merge(int[] leftPart, int[] rightPart, int[] newArray)
	//public static int[] merge(int[] leftPart, int[] rightPart)
	{
		int i, j, k;
		i = j = k = 0;
		//int[] newArray = new int[leftPart.length + rightPart.length];
		while ((i < leftPart.length) &&( j< rightPart.length))
			if(leftPart[i] < rightPart[j])			
				newArray[k++] = leftPart[i++];		
			else 
				newArray[k++] = rightPart[j++];
		//after this while loop one of the arrays(leftPart or rightPart not both) might contain elements. So copy these elements.
		while (i < leftPart.length)
			newArray[k++] = leftPart[i++];
		while(j<rightPart.length)
			newArray[k++] = rightPart[j++];
		//return newArray;
	}
	//end of merge sort
	
	//start of quick sort
	public static int[] quickSort(int[] array)
	{
		return quickSort(array, 0, array.length-1);
	}
	public static int[] quickSort(int[] array, int low, int hi)
	{
		if(low < hi)
		{
			int pivoteIndex = partition(array, low, hi);
			quickSort(array, low, pivoteIndex-1);
			quickSort(array, pivoteIndex+1, hi);
		}
		return array;
	}
	public static int partition(int[] array, int low, int hi)
	{
		int storeIndex = low;
		int pivoteIndex = choosePivote(low,hi);
		int pivoteValue = array[pivoteIndex];
		swap(array,pivoteIndex, hi);
		for(int i=low; i < hi; i++)
		{
			if(array[i] < pivoteValue)
			{
				swap(array,i, storeIndex);
				storeIndex++;
			}
		}
		swap(array,storeIndex,hi);
		return storeIndex;
	}
	public static int choosePivote(int low, int hi)
	{
		//return (low+hi)/2; 
		return low;
	}
	//end of quicksort
	
	//start of quickSelect
	public static int quickSelect(int[] array, int k)
	{
		return quickSelect(array,0,array.length-1,k);
	}
	public static int quickSelect(int[] array, int low, int hi, int k)
	{
		if(low == hi)
			return array[low];
		int pivoteIndex = partition(array,low,hi);
		if(pivoteIndex == k)
			return array[pivoteIndex];
		else if(pivoteIndex > k)
			return quickSelect(array,low, pivoteIndex - 1, k);
		else
			return quickSelect(array, pivoteIndex+1, hi, k);
	}
	//end of quickSelect
	
	public static void printArray(int[] array)
	{
		for(int pos=0; pos< array.length; pos++)
			System.out.print(array[pos]+" ");
	}
	public static void main(String[] args) {
		int[] array = {56,-45,0,78,-3,555,4,10};
		System.out.print("\nBubble: ");
		printArray(bubble(array));
		
		System.out.print("\nInsertion sort: ");
		printArray(insertion(array));
		
		/*System.out.print("\nMerge Sort:");
		printArray(mergeSort(array));*/
		
		System.out.print("\nQuickSort:");
		printArray(quickSort(array));
		
		System.out.print("\nKth smallest element : "+quickSelect(array, 0));
		//wrong op for k=7????????????
	}

}
