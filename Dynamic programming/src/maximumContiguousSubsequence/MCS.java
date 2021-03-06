//m(j) = maximum subsequence ending at j
//m(j) = max {m(j-1)+A[j], A[j]}
//same as maximum subarray sum

package maximumContiguousSubsequence;

public class MCS {

	public static int maxSubsequence(int[] array) {
		int m[] = new int[array.length];
		int  max =  array[0];
		m[0] = array[0];
		for(int j = 1; j<array.length; j++) {
			m[j] = m[j-1]+ array[j] > array[j] ?  m[j-1]+ array[j]  : array[j]; 
			System.out.print(m[j]+" ");
			if(m[j] > max)
				max = m[j];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.print(maxSubsequence(array));
	}

}
