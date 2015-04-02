//Kadane's Algorithm
//same as maxSubsequence
package maximumSubarraySum;

public class MSS {

	public static int maxSubSum(int[] array) {
		int max_ending_here, max_so_far;
		max_ending_here = max_so_far = array[0];
		for(int i = 1; i<array.length; i++) {
			max_ending_here = (max_ending_here > array[i]) ? (max_ending_here + array[i]) : array[i];
			max_so_far = (max_so_far > max_ending_here) ? max_so_far : max_ending_here; 
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.print(maxSubSum(array));
	}

}
