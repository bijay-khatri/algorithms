/*
Given an array arr of length n where each element is at most k places away from its sorted position,
Plan and code an efficient algorithm to sort arr.
Analyze the runtime and space complexity of your solution.

Example: n=10, k=2. The element belonging to index 6 in the sorted array, may be at indices 4, 5, 6, 7 or 8 on the given array.
*/
import java.util.Arrays;
import java.util.PriorityQueue;
public class KSortedArray{
	int [] array;
	int size;

	public KSortedArray(int [] array){
		this.array = array;
		this.size = array.length - 1;
	}

	public static void main(String [] args){
		KSortedArray obj = new KSortedArray(new int[] {9,10,1,2,3,4,5,6,7,8});
		obj.print("Original Array is " + Arrays.toString(obj.array));
		obj.sort(2);
		obj.print("Sorted Array is " + Arrays.toString(obj.array));
	}

	private void sort(int k){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0; i < k; i++){
		    queue.offer(array[i]);				
		}
		print(queue);
		
		for(int i = k ; i <= size - k; i++){
			array[i - k] = array[i];
		}

		for(int i = size + 1 - k; i <=size; i++){
			array[i] = queue.poll();
		}


	}

	private void print(Object o){
		System.out.println(o);
	}
}