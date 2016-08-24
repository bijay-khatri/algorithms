/*Given an array arr of length n where each element is at most k places away from its 
sorted position, Plan and code an efficient algorithm to sort arr.
Analyze the runtime and space complexity of your solution.

Example: n=10, k=2. The element belonging to index 6 in the sorted array, 
may be at indices 4, 5, 6, 7 or 8 on the given array. */

import java.util.Arrays;
import java.util.PriorityQueue;
public class Pramp01{
	
	public static void main(String [] args){
		int [] array = {5, 6, 7, 1, 2, 3};

		System.out.println("The original array is : " + Arrays.toString(array));
		//sort(array, 3);
		insertionSort(array);
		System.out.println("The array after sorting is: " + Arrays.toString(array));
	}

	private static void sort(int [] array, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<>(array.length);

		// copy the windows into pq with sliding window of K + 1
		for(int i = 0; i <=k; i++)
			queue.offer(array[i]);

		//Slide the windows by each step and place the min in the left of window
		for(int i = k + 1; i < array.length; i++){
			array[i -(k + 1)] = queue.poll();
			queue.offer(array[i]);
		}

		for(int i = 0; i <=k; i++){
			array[array.length - (k + 1 - i)] = queue.poll();
		}	

	}

	private static void insertionSort(int [] array){

		for(int i = 1; i < array.length; i++){
			int min = array[i];
			int j = i - 1;
			while(j >=0 && array[j] > min){
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = min;
		}
	}

}