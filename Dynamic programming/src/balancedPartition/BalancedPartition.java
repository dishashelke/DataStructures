/*
 * Goal: Partition array into two subsets S1 & S2 
 * 		  minimize | sum(S1) - sum(S2) |
 * Solution: let P(j, i) = { true	  if some subset of {A1..Ai} has a sum of j
 * 	1<= i <=n			  		{ false   otherwise
 * 	0 <= j <= nk
 * 
 *		P(j, i) = max{P(j, i-1), P(j-Ai, i-1)} = P(j, i-1) || P(j-Ai, i-1) 
 *		P(j-Ai, i-1)=1 if sum of first i-1 elements is equal to j-Ai, so if we add Ai then sum would be j 		
 *
 *		Let S = (sum(Ai)) / 2
 */
package balancedPartition;

import java.util.ArrayList;
import java.util.List;

public class BalancedPartition {

	public static int sum(int array[]){
		int sum = 0;
		for(Integer each: array)
			sum += each;
		return sum;
	}

	public static void main(String[] args) {
		//int array[] = {2,1,3,4,2};
		int array[] = {3,1,1,2,2};
		int size = array.length;
		/*in Java8
		 * int sum = IntStream.of(a).sum();
		 */
		int sum = sum(array);
		boolean P[][] = new boolean[sum/2+1][ size+1];
		
		for(int i = 0; i < size+1; i++)
			P[0][i] = true;
		
		for(int s = 1; s <= sum/2 ; s++)
			for(int index = 1;  index<= size; index++)
				if(array[index-1] <= s)
					P[s][index] = P[s][index-1] || P[s-array[index-1]][index-1];
				else
					P[s][index] = P[s][index-1];
		
		//minimize sum and find two sets
		List<Integer> set1 = new ArrayList<Integer>();
		List<Integer> set2 =  new ArrayList<Integer>();
		int minSum = sum/2;
		for(int i = 0; i < size; i++){
			if(P[sum/2][i] == true && minSum>0){
				minSum -= array[i];
				set1.add(array[i]);
			}
			else
				set2.add(array[i]);
		}
		System.out.println("\nMinimum Sum: "+minSum);
		System.out.print("\nSet1: "+set1);
		System.out.print("\nSet2: "+set2);
	}

}
