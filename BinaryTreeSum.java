/* Given a binary tree and a sum, find if sum from root to leaf which is equal to given sum.*/

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeSum{
	private TreeNode root;

	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data){
			this.data = data;
		}

		public TreeNode(int data, TreeNode left, TreeNode right){
			this.left = left;
			this.right = right;
			this.data = data;
		}

		public TreeNode(){

		}

		public void setLeft(TreeNode left){
			this.left = left;
		}

		public void setRight(TreeNode right){
			this.right = right;
		}

		public TreeNode getLeft(){
			return this.left;
		}

		public TreeNode getRight(){
			return this.right;
		}

		public int getData(){
			return this.data;
		}

		@Override
		public String toString(){
			return this.data + " ";
		}
	}
	public void test(String testName, TreeNode tree, int sum, boolean expected){
		System.out.print(testName + " started.... ");

		if(expected == sum(tree, sum)) print("pass");
		else print("FAIL");
	}

	private void test1(){
		test("Test1", null, 0, true);
	}

	private void test2(){
		test("Test2", new TreeNode(1), 1, true);
	}

	private void test3(){
		test("Test3", new TreeNode(1,new TreeNode(2), null), 3, true);
	}

	private void test4(){
		test("Test4", new TreeNode(1, new TreeNode(2), null), 4, false);
	}

	private void test5(){
		test("Test5", new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),null),10, true);
	}

	public static void main(String [] args){
		BinaryTreeSum obj = new BinaryTreeSum();
		obj.test1();
		obj.test2();
		obj.test3();
		obj.test4();
		obj.test5();

		obj.constructTree();

		print("Path: " + obj.findPathWithSum(21));

		//obj.inOrderTraversal();
	}

	private void constructTree(){
		TreeNode root = new TreeNode(9,new TreeNode(5, new TreeNode(2)
			, new TreeNode(4, new TreeNode(3), new TreeNode(9))), new TreeNode(1, 
				new TreeNode(7), new TreeNode(8, new TreeNode(10), null))
			);
		this.root = root;
	}

	public void inOrderTraversal(){
		inOrderTraversal(root);
	}

	private void inOrderTraversal(TreeNode root){
		if(root == null) return;
		inOrderTraversal(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrderTraversal(root.getRight());
	}

	private static void print(Object o){
		System.out.println(o);
	}
	int total = 0;
	private boolean sum(TreeNode root, int sum){
		int total = sum(root);
		return total == sum;
	}

	private int sum(TreeNode root){
		if(root == null){
			return 0;
		}
		return root.data + sum(root.left) + sum(root.right);
	}

	private Deque<Integer> findPathWithSum(int sum){
		Deque<Integer> result = new LinkedList<>();
		boolean answer = findPathWithSum(this.root, sum, result);
		if(!answer) return null;
		else return result;
	}

	private boolean findPathWithSum(TreeNode node, int sum, Deque<Integer> result){
		if(node == null) return false;
		else if(node.left == null && node.right == null){
			//leaf node
			if(node.data == sum){
				result.addFirst(node.data);
				return true;
			}
			return false;
		}
		else if(findPathWithSum(node.right, sum - node.data, result)){
			result.addFirst(node.data);
			return true;
		}
		else if(findPathWithSum(node.left, sum - node.data, result)){
			result.addFirst(node.data);
			return true;
		}
		return false;
	}
}
