package subsetSum;

public class SubsetSum {
	public static boolean isSubsetSum(int[] array, int size, int sum) {
		if (sum == 0)
			return true;
		if (sum !=  0 && size == 0)
			return false;
		if (array[size-1] > sum)
			return isSubsetSum(array, size - 1, sum);
		return isSubsetSum(array, size - 1, sum)
				|| isSubsetSum(array, size - 1, sum - array[size-1]);
	}

	public static void main(String[] args) {
		int []array = {2, 1, 2 , -1, 2};
		System.out.println(isSubsetSum(array, array.length, 7));
	}

}
