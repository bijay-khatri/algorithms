/* Given a sorted integer array which is rotated any number of times and an integer num, 
find the index of num in the array. If not found, return -1 */
import java.util.Arrays;

public class RotatedSearch{
	int [] array;
	int size;

	public RotatedSearch(int [] arr){
		if(arr == null) throw new IllegalArgumentException("Canot create object. Null Array encountered");
		this.array = arr;
		size = array.length;
	}

	private static void print(Object o){
		System.out.println(o);
	}

	public static void main(String [] args){
		int [] array = {7, 8, 10, 11, 13, 1, 3, 5, 6, 7};
		RotatedSearch obj = new RotatedSearch(array);
		
		int k = 13;
		print("Serching " + k + " , index = " + obj.search(k));
	}

	private int search(int key){
		return search(key, 0, size -1);
	}

	private int search(int key, int low, int high){
		if(low <= high){
			//recurse
			int mid = (low + high) / 2;
			if(array[mid] == key) return mid;
			else if(array[low] <= array[mid]){
				//left halv is sorted
				if(key >= array[low] && key < array[mid]){
					return search(key, low, mid - 1);
				}
				return search(key, mid + 1, high);
			}
			else{
				//right halv is sorted
				if(key >= array[mid] && key < array[high]){
					return search(key, mid + 1, high);
				}
				return search(key, low, mid - 1);
			}
		}
		return -1;
	}


	private int searchIterative(){
		return 0;
	}
}