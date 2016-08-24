/*Reverse a Linked List Recursively.*/
import java.util.Deque;
import java.util.ArrayDeque;
public class ReverseLinkedList{
	
	Node head;

	public void setHead(Node head){
		this.head = head;
	}

	public Node getHead(){
		return head;
	}

	class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;

		}

		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}

		public void setNext(Node next){
			this.next = next;
		}

		public Node getNext(){
			return this.next;
		}

		@Override
		public String toString(){
			return this.data + "->" + this.getNext();
		}
	}
	
	public static void main(String [] args){
		ReverseLinkedList list = new ReverseLinkedList();
		list.create();
		list.print();
		list.reverse();
		print("After Reverse: ");
		list.print();
	}

	public void create(){
		Node newNode = new Node(1, new Node(2, new Node(3)));
		this.head = newNode;
	}

	public void print(){
		Node temp = this.head;
		while(temp !=null){
			print(temp);
			temp = temp.getNext();
		}
	}

	public void reverse(){
		reverse(this.head);
	}

	private void reverse(Node curr){
		if(curr == null) return;
		if(curr.getNext() == null){
			this.head = curr;
			return;
		}
		reverse(curr.getNext());
		curr.getNext().setNext(curr);
		curr.setNext(null);
	}

	

	private static void print(Object o){
		System.out.println(o);
	}
}