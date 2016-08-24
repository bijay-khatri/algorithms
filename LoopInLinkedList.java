/* Detect Loop in Linked List */
import java.util.*;
public class LoopInLinkedList{
	ListNode head;

	public static void main(String [] args){
		LoopInLinkedList obj = new LoopInLinkedList();
		obj.construct();

		obj.printNode();
		obj.hasLoop();
		obj.printStartOfLoop();
		obj.printStart();
	}

	private void construct(){
		ListNode temp = new ListNode(1);
		temp.next = new ListNode(2);
		temp.next.next= new ListNode(3);
		temp.next.next.next = new ListNode(4);
		temp.next.next.next.next = new ListNode(5);
		temp.next.next.next.next.next = new ListNode(6);
		temp.next.next.next.next.next.next = new ListNode(7);
		temp.next.next.next.next.next.next.next = temp.next.next.next;
		this.head = temp;
	}
	ListNode detected = null;
	private boolean hasLoop(){
		ListNode fast = this.head;
		ListNode slow = this.head;

		for(int i = 1; i < 8; i++){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) {
				detected = slow;
				print("Meeting Point: " + slow.val);
				return true;
			}
		}

		return false;
	}

	private void printStartOfLoop(){
		Set<ListNode> sets = new HashSet<>();

		ListNode temp = this.head;

		while(temp !=null){
			if(sets.contains(temp)) break;
			sets.add(temp);
			temp = temp.next;
		}

		print("Detected Value: " + temp.val);
	}

	private void printStart(){
		ListNode start = this.head;
		ListNode other = detected;

		while(start !=other){
			start = start.next;
			other = other.next;
		}

		print("Loop Started at: " +other.val);
	}

	private void printNode(){
		ListNode temp = this.head;
		for(int i = 1; i <=8; i++){
			print(temp.val);
			temp = temp.next;
		}
	}
	public static void print(Object o){
		System.out.println(o);
	}


}