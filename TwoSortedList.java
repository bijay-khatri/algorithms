/*
Given two sorted linked lists, merge two linked lists in one list in sorted order without using extra space */


public class TwoSortedList{
	static ListNode list1;

	static ListNode list2;

	public static void main(String [] args){
		TwoSortedList obj = new TwoSortedList();
		obj.createFirstList();
		obj.createSecondList();

		obj.print(list1);
		obj.print(list2);

		obj.sort();

		System.out.println("After Printing..");
		obj.print(list1);
		obj.print(list2);
	}

	private void sort(){
		
		if(list1 == null) return ;
		if(list2 == null) return ;

		ListNode head = null;

		if(list1.val <= list2.val){
			head = list1;
		}
		else{
			head = list2;
			list2 = list1;
			list1 = head;
		}

		while(list1.next != null && list2 != null){
			if(list1.next.val > list2.val){
				ListNode temp = list1.next;
				list1.next = list2;
				list2 = temp;
			}
			list1 = list1.next;
		}

		if(list1.next == null) list1.next = list2;

	}

	private void createFirstList(){
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(4);

		this.list1 = root;
	}

	private void createSecondList(){
		ListNode root = new ListNode(1);
		root.next = new ListNode(3);
		root.next.next = new ListNode(5);

		this.list2 = root;
	}

	private void print(ListNode root){
		if(root == null) return;
		ListNode temp = root;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
	}
}