 /* Find Nth largest element from a given binary search tree */

 /*
  @author Bijay Khatri
  @since August, 11, 2016
  @version 1.0
 */
 import java.util.ArrayList;
 import java.util.List;

 public class LargestInBST{
 	private TreeNode root;


 	class TreeNode{
 		int value;
 		TreeNode left;
 		TreeNode right;

 		public TreeNode(int data){
 			this.value = data;
 		}

 		@Override 
 		public String toString(){
 			return value + " ";
 		}
 	}

 	private void test(String testName, int k, int expected){
 		System.out.print(testName + " Started.... ");

 		if(expected == findKthLargest(k)){
 			print("true");
 		}
 		else
 			print("false");
 	}

 	private void print(Object o){
 		System.out.println(o);
 	}

 	private int findKthLargest(int k){
 		List<Integer> elements = new ArrayList<>();
 		reverseInOrder(this.root, elements);
 		print(elements);
 		if(k > elements.size() && k - 1 < 0) return -1;
 		return elements.get(k - 1);
 	}

 	private void reverseInOrder(TreeNode root, List<Integer> elements){

 		if(root == null) return;

 		reverseInOrder(root.right, elements);
 		elements.add(root.value);
 		reverseInOrder(root.left, elements);         /*      10
 														  7		  12
 														5   8   11  13 */
 	}

 	private void test1(){
 		test("Test 1", 1, 13);
 	}

 	private void test2(){
 		test("Test 2", 5, 8);
 	}

 	public static void main(String [] args){
 		LargestInBST obj = new LargestInBST();
 		obj.createTree();
 		obj.test1();
 		obj.test2();
 	}

 	private void createTree(){
 		TreeNode root = new TreeNode(10);
 		root.left = new TreeNode(7);
 		root.right = new TreeNode(12);
 		root.left.left = new TreeNode(5);
 		root.left.right = new TreeNode(8);
 		root.right.left = new TreeNode(11);
 		root.right.right = new TreeNode(13);
 		this.root = root;
 	}
 }