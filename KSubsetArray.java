/* 42: Print all size K subsets from an array
e.g. {1,2,3}, given size 2, all size-2 subsets are [1,2], [1,3] and [2,3] */

public class KSubsetArray{
	
	public static void main(String [] args){
		KSubsetArray obj = new KSubsetArray();
		obj.printSubset(new int[]{1,2,3}, 2);
	}

	private void printSubset(int [] array, int window){
		boolean [] values = new boolean[array.length];
		printSubset(array, 0, 0, values, window);
	}

	private void printSubset(int [] array, int start, int size, boolean [] values, int window){
		//base case
		if(size == window){
			for(int i = 0; i < array.length; i++){
				if(values[i])
					System.out.print("[ + " + array[i] + " ,");
			}
			System.out.print("]\n");
			return;
		}

		if(start == array.length) return;

		values[start] = true;
		printSubset(array, start++, size++, values,window);

		values[start] = false;
		printSubset(array, start++, size, values, window);
	}

}