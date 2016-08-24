/* 
An array contains n numbers ranging from 0 to n-1. There are some numbers duplicated in the
array. It is not clear how many numbers are duplicated or how many times a number gets duplicated. 
How do you find a duplicated number in the array? For example, 
if an array of length 7 contains the numbers {2, 3, 1, 0, 2, 5,3},
 the implemented function (or method) should return either 2 or 3.*/
import java.util.HashSet;

public class DuplicateDetection{
	public static void main(String [] args){
		int [] array = {2, 3, 1, 0, 2, 5,3};
		print("Duplicate: " + detectDuplicate(array));
		print("Duplicate: " + detectDuplicate2(array));
	}
	private static void print(Object o){
		System.out.println(o);
	}

	private static int detectDuplicate(int [] array){
		HashSet<Integer> set = new HashSet<>();

		for(int i = 0; i < array.length; i++){
			if(set.contains(array[i])) return array[i];
			set.add(array[i]);
		}
		return -1;
	}

	private static int detectDuplicate2(int [] array){
		for(int i = 0; i < array.length; i++){
			if(array[i] < 0 || array[i] > array.length - 1)
				throw new IllegalArgumentException("Invalid Numbers");
		}

		for(int i = 0; i < array.length; i++){
			while(array[i] !=i){
				if(array[i] == array[array[i]])
					return array[i];

				//Swap twoo numbers
				int temp = array[i];
				array[i] = array[temp];
				array[temp] = temp;
			}
		}
		throw new IllegalArgumentException("No duplicates");
	}
}