/* Quick Sort 

@author Bijay Khatri
@since August 12 2016
@version 1.0 */

import java.util.Arrays;
public class QuickSortEx{
	public static void main(String [] args){
		int [] a = {3,4,10,5,6,7,9,10,19,2,1};
		
		quickSort(a);

		System.out.print("Elements after Quick Sort: " + Arrays.toString(a));
	}

	private static void quickSort(int [] a){
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(int [] a, int low, int high){
		if(low < high){
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot - 1);
			quickSort(a, pivot + 1, high);
		}
		
	}

	private static int partition(int [] a, int low, int high){
		int pivot = a[high];

		int start = low;

		for(int i = low; i < high; i++){
			if(a[i] <= pivot){
				int temp = a[start];
				a[start] = a[i];
				a[i] = temp;
				start++;
			}
		}

		//swap pivot with start pos
		int temp = a[start];
		a[start] = a[high];
		a[high] = temp;

		return start; 
	}
}