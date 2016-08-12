/* Heap Sort 

 @author Bijay Khatri
 @since Aug 12 2016
 @version 1.0
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Iterator;

 public class HeapSortEx{
 	private static int len;

 	public static void main(String [] args){
 		int [] a = {3,4,10,19,2,1};
		
		System.out.println("Elements before order: " + Arrays.toString(a));
		//heapSort(a);
		internalHeapSort(a);

		System.out.print("Elements after Quick Sort: " + Arrays.toString(a));
 	}

 	private static void heapSort(int [] a){
 		len = a.length - 1;

 		//start from the child node and move up to the root
 		for(int i = len/2; i >= 0; i--){
 			heapify(a, i);
 		}

 		accumateAndConstruct(a);
 	}

 	private static void accumateAndConstruct(int [] a){
 		//Max element is at 0 so swap it with last element
 		//Cut the length of the tree by 1 and reheapify

 		for(int i = len; i > 0 ; i--){
 			swap(a, 0 , i);
 			len--;
 			heapify(a, 0); // last element now at root might violate max heap property
 		}
 	}

 	private static void heapify(int [] a, int pos){
 		//Assumption 0th index is the root
 		int left = 2 * pos + 1;
 		int right = 2 * pos + 2;
 		int max = pos;

 		if(left <=len && a[left] > a[max]) max = left;
 		if(right <=len && a[right] > a[max]) max = right;

 		//if max is the root of left and right
 		if(max != pos){
 			//move the max up
 			swap(a, max, pos);

 			//moving up might cause heap to violate max heap property so let's heapify
 			//a tree rooted at max
 			heapify(a, max);
 		}
 	}

 	private static void swap(int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}


	private static void internalHeapSort(int [] array){
		PriorityQueue<Integer> heap = new PriorityQueue<>(array.length);
	   //We can pass Collections.reverseOrder()

		for(int i = 0; i < array.length; i++){
			heap.offer(array[i]);
		}
		//
		
		for(int i = 0; i < array.length; i++){
			array[i] = heap.poll();
		}
	}
 	
 }