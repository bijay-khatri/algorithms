/*Two linked lists A and B are joined on a particular node, called the point of intersection of the linked lists. Find the point of intersection, i.e. the first node after which both lists have same nodes.*/
import java.util.Set;
import java.util.HashSet;

public class IntersectionLinkedList{
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

		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}

		public Node(int data){
			this.data = data;
		}

		public void setNext(Node next){
			this.next = next;
		}


		public Node getNext(){
			return this.next;
		}
		public int getData(){
			return data;
		}

		@Override
		public String toString(){
			return this.data + " ";
		}
	}

	public static void main(String [] args){
		IntersectionLinkedList l1 = new IntersectionLinkedList();
		IntersectionLinkedList l2 = new IntersectionLinkedList();
		
		l1.createList(3);
		l2.createList(6);

		l2.makeConnection(l1);
		
		print("Linked List 1: ");
		l1.printLinkedList();
		print("Linked List 2: ");
		l2.printLinkedList();

		l1.findIntersection(l2);
	}

	public void createList(int size){
		Node head = new Node(size);
		Node temp = head;
		for(int i = size - 1; i >= 1; i--){
			temp.setNext(new Node(i));
			temp = temp.getNext();
		}
		this.setHead(head);
	}

	public void printLinkedList(){
		printLinkedList(this.head);
	}

	private void printLinkedList(Node head){
		if(head == null) print("");

		while(head !=null){
			print(head);
			head = head.getNext();
		}
	}

	public void findIntersection(IntersectionLinkedList l){
		findIntersection(this.getHead(), l.getHead());
	}

	private void findIntersection(Node n1, Node n2){
		if(n1 == null || n2 == null) print("doesnot exists");

		HashSet<Node> set = new HashSet<>();

		Node temp = n1;

		while(temp !=null){
			set.add(temp);
			temp = temp.getNext();
		}

		temp = n2;

		while(temp !=null){
			if(set.contains(temp)){
				print("Detected::" + temp);
				break;
			}
			temp = temp.getNext();
		}


	}

	public  void makeConnection(IntersectionLinkedList l1){
		makeConnection(this.getHead(), l1.getHead());
	}

	private  void makeConnection(Node n1, Node n2){
		int i = 1;
		Node temp = n2;
		while(i++ < 3){
			temp = temp.getNext();
		}
		
		Node temp1 = n1;
		while(temp1.getNext() !=null){
			temp1 = temp1.getNext();
		}

		temp1.setNext(temp);
	}

	private static void print(Object o){
		System.out.println(o);
	}
}