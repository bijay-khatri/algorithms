/* An array contains n numbers ranging from 0 to n-2. There is exactly one number duplicated in
the array. How do you find the duplicated number? For example, if an array with length 5 contains numbers {0, 2,1, 3, 2}, the duplicated number is 2.*/
import java.util.HashSet;

public class DuplicateNumber{
	public static void main(String [] args){
		int [] array = {0, 2, 1, 3, 2} ; 
		int [] test = {0,0};
		int n = 5;

		print(" Duplicate = " + findDuplicate(test, 2));
		print(" Duplicate  = " + findDuplicate2(test));

	}

	private static int findDuplicate(int [] array, int n){
		int sum1 = 0, sum2 = 0;
		for(int i = 0; i < array.length; i++){
			sum1 += array[i];
		}

		for(int i = 0; i <= n - 2; i++){
			sum2 += i;
		}

		return sum1 - sum2;
	}

	private static int findDuplicate2(int [] array){
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < array.length; i++){
			if(set.contains(array[i])) return array[i];
			set.add(array[i]);
		}
		return -1;
	}

	public static void print(Object o){
		System.out.println(o);
	}
}