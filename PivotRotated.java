/* Given a sorted integer array which is rotated any number of times, 
find the pivot index i.e. index of the minimum element of the array.
Ex: In array {78, 82, 99, 10, 23, 35, 49, 51, 60}*/

import java.util.Arrays;

public class PivotRotated{
	private static int len;
	public static void main(String [] args){
		print("Pivot in Rotated Array");
		int [] array = {78, 82, 99, 101, 222, 10, 23, 35, 49, 51, 60};
		print("Original Array : " + Arrays.toString(array));
		print("The pivot index is (Iterative) : " + findPivotIndex(array));
		print("The pivot index is : " + findPivotIndexRecursive(array));
		int key = 36;
		print(" Searching for "+ key + " : " + findElement(array, key));

		print(" Heap Sort :::");
		//insertionSort(array);
		heapSort(array);
		print(Arrays.toString(array));
	}

	private static void print(Object o){
		System.out.println(o);
	}

	private static int findPivotIndex(int [] array){
		if(array == null || array.length == 0) return -1;
		if(array[0] < array[array.length - 1]) return 0;
		
		int low = 0, high = array.length - 1, mid = 0;
		while(low <= high){
			mid = (low + high) / 2;
			if(mid < array.length - 1 && array[mid] > array[mid + 1]) return mid + 1;
			else if(array[low] <= array[mid]) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
	}

	private static int findPivotIndexRecursive(int [] array){
		return findPivotIndexRecursive(array, 0, array.length - 1);
	} 

	private static int findPivotIndexRecursive(int [] array, int low , int high){
		if(low <= high){
			int mid = (low + high) / 2;
			if(mid < array.length - 1 && array[mid] > array[mid + 1]) return mid + 1;
			else if(array[low] <= array[mid]) return findPivotIndexRecursive(array, mid + 1, high);
			else return findPivotIndexRecursive(array, low, mid - 1);
		}
		return -1;
	}

	private static int findElement(int [] array , int key){
		//return findElementIterative(array,key);
		return findElementRecursive(array,key, 0, array.length - 1);
	}

	private static int findElementIterative(int [] array , int key){
		int low = 0; int high = array.length - 1; int mid = 0;

		while(low <= high){
			mid = (low + high) / 2;
			if(array[mid] == key) return mid;

			else if(array[low] <= array[mid]){
				/* Lower Half is Sorted */
				if(key >= array[low] && key < array[mid]) high = mid - 1;
				else low = mid + 1;
			}
			else{
				/* Higher Half is Sorted */
				if(key >= array[mid] && key < array[high]) low = mid + 1;
				else high = mid - 1;
			}
		}
		return -1;
	}

	private static int findElementRecursive(int [] array, int key, int low, int high){
		if(low <=high){
			int mid = (low + high) / 2;
			if(array[mid] == key) return mid;
			else if(array[mid] >= array[low]){
				if(key >= array[low] && key < array[mid]) 
					return findElementRecursive(array, key,low, mid - 1);
				return findElementRecursive(array, key, mid + 1, high);
			}
			else{
				if(key >= array[mid] && key < array[low])
					return findElementRecursive(array, key, mid + 1, high);
				return findElementRecursive(array, key, low, mid - 1);
			}
		}
		return -1;
	}


	public static void insertionSort(int [] array){
		// Scan each items and insert in into appropriate positon
		for(int i = 1; i < array.length; i++){
			int j = i;
			int temp = array[i];
			while(j > 0 && array[j - 1] > temp){
				array[j] = array [j - 1];
				j--;
			}
			array[j] = temp;
		}
	}

	public static void heapSort(int [] array){
		len = array.length - 1;

		for(int i = len/2 ; i >= 0; i--){
			buildMaxHeap(array,i);
		}

		//collect and build array
		for(int i = len; i > 0;  i--){
			swap(array, 0, i);
			len--;
			buildMaxHeap(array, 0);
		}
	}

	private static void buildMaxHeap(int[] array, int index){
		
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		int max = index;

		if(left <= len && array[left] > array[max])
			max = left;

		if(right <= len && array[right] > array[max])
			max = right;

		if(max != index){
			swap(array, max, index);
			buildMaxHeap(array, max);
		}
	}

	private static void swap(int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}