/*Given a pointer to the middle node of a Linked List, delete that node.*/
public class DeleteNode{
	Node head;

	public void setHead(Node n){
		this.head = n;
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
			return next;
		}

		@Override
		public String toString(){
			return this.data + " -> " + "[" + this.next + "]";
		}
	}

	private void test(String testName, int key, boolean result){
		this.printNodes();
		System.out.print(testName + " begins: ");
		if(result == search(key)){
			print("passed");
		}
		else print("FAILED");
	}

	private static void print(Object o){
		System.out.println(o);
	}

	private void test1(){
		Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
		this.head = node;
		test("Test1",3,true);
	}

	private void test2(){
		Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
		this.head = node;
		test("Test2",6,false);
	}

	private void test3(){
		Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
		this.head = node;
		Node temp = node.next.next;
		delete(temp);
		test("Test3",4,true);
	}

	private void test4(){
		Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
		this.head = node;
		Node temp = node.next.next;
		delete(temp);
		test("Test4",3,false);
	}

	private void test5(){
		Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
		this.head = node;
		Node temp = node.next.next;
		delete(temp);
		test("Test5",2,true);
	}


	private void delete(Node pointer){
		Node temp = pointer.next;
		pointer.data = temp.data;
		pointer.next = temp.next;
	}

	private void printNodes(){
		Node temp = this.head;
		while(temp != null){
			print(temp);
			temp = temp.next;
		}
	}

	private boolean search(int key){
		Node temp = this.head;
		while(temp != null){
			if(temp.data == key) return true;
			temp = temp.next;
		}
		return false;
	}

	public static void main(String [] args){
		DeleteNode obj = new DeleteNode();
		obj.test1();
		obj.test2();
		print("After Deleting 3");
		obj.test3();
		obj.test4();
		obj.test5();
	}
}