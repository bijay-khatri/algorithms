/* LeetCode382 : Given a singly linked list, return a random node's value from the linked list. 
Each node must have the same probability of being chosen */
import java.util.Random;
public class RandomNode{
	ListNode head;

	public RandomNode(ListNode head){
		this.head = head;
	}
	
	public static void main(String [] args){
		// Init a singly linked list [1,2,3].
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		//Solution solution = new Solution(head);

	// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
		RandomNode obj =  new RandomNode(head);

		int val = obj.getRandom();

		System.out.println(val);

	}

	public int getRandom(){
		ListNode temp = head;
		int i = 0;
		while(temp != null){
			temp = temp.next;
			i++;
		}
		return getRandomValue(i);
	}

	public int getRandomValue(int limit){
		ListNode temp = head;

		Random rand = new Random();
		int N = rand.nextInt(limit);

		int count = 0;
		while(count < N){
			temp = temp.next;
			count++;
		}

		return temp.val;
	}

}