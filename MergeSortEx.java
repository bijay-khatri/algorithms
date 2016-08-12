/*
Merge Sort


@uthor Bijay Khatri
@since August 12 2016
@version 1.0
*/
import java.util.Arrays;
public class MergeSortEx{
	public static void main(String [] args){
		int a[] = {2,3,4,1,8,7,6,9};
		mergeSort(a);
		System.out.println("After Sorting: " + Arrays.toString(a));
	}

	private static void mergeSort(int [] a){
		if(a == null) throw new IllegalArgumentException("Empty Array - Invalid Input");

		if(a.length == 1) return;

		int high = a.length;
		int low = 0;
		int mid = (low + high) / 2;

		int [] left = divide(a, low, mid); // exclusive
		int [] right = divide(a, mid, high);

		// System.out.println("Left: " + Arrays.toString(left));
		// System.out.println("right: " + Arrays.toString(right));

		mergeSort(left);
		mergeSort(right);

		merge(a, left, right);
	

	}
	private static int [] divide(int [] array, int start, int end){
		int [] res = new int[end - start];
		int j = 0;
		for(int i = start; i < end; i++){
			res[j++] = array[i];
		}
		return res;
	}

	private static void merge(int [] source, int [] left, int [] right){
		int leftStart = 0, leftLimit = left.length;
		int rightStart = 0, rightLimit = right.length;
		int index = 0;

		while(leftStart < leftLimit && rightStart < rightLimit){
			if(left[leftStart] <= right[rightStart]){
				source[index++] = left[leftStart++];
			}
			else
				source[index++]= right[rightStart++];
		}

		//left array might not be empty copy them
		while(leftStart < leftLimit)
			source[index++] = left[leftStart++];

		while(rightStart < rightLimit)
			source[index++] = right[rightStart++];
	}
}