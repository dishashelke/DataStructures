package lis;
import java.util.ArrayList;

//LONGEST INCREASING SUBSEQUENCE
public class LIS {

	public static ArrayList<Integer> LongestIS(int[] array){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(array.length);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(array[0]);
		list.add(0, list0);		
		for(int i=1; i <array.length; i++)
		{			
			int maxLength = 0;
			int maxIndex=-1;
			for(int j=0;j<i;j++)
			{
				if((array[j] < array[i]) && (list.get(j).size() > maxLength))
				{
					maxLength = list.get(j).size();
					maxIndex = j;
				}				
			}
			ArrayList<Integer> newList;
			if(maxIndex ==  -1)
				newList = new ArrayList<Integer>();								
			else				
				newList = new ArrayList<Integer>(list.get(maxIndex));//deep copy of arraylist
			newList.add(array[i]);
			list.add(i, newList);
		}		
		return list.get(array.length-1);
	}
	public static void printArrayList(ArrayList<Integer> list){
		for(int pos=0; pos< list.size(); pos++)
			System.out.print(list.get(pos)+" ");
		System.out.print("\n");
	}
	public static void main(String[] args) {
		int[] array = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		ArrayList<Integer> lis = LongestIS(array);
		printArrayList(lis);
	}

}
