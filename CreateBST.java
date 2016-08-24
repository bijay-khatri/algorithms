/* Create a Balanced Binaray Tree from a given sorted array */

public class CreateBST{
	
	TreeNode root;

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
		}
	}

	public static void main(String [] args){

		CreateBST obj = new CreateBST();
		obj.test1();
		obj.test2();
		obj.test3();
	}

	private void test(String testName, int [] array, int top, boolean expected){
		System.out.print(testName + " started... ");
		this.root = createTree(array);
		this.printInOrder();
		if(expected == (top == this.root.val)) print("true");
		else print("FAIL");
	}

	private TreeNode createTree(int [] array){
		return createTree(array,0, array.length - 1);
	}

	private TreeNode createTree(int [] array, int low, int high){
		TreeNode root = null;
		if(low <= high){
			int mid = (low + high) / 2;
			TreeNode temp  = new TreeNode(array[mid]);
			temp.left  = createTree(array, low , mid - 1);
			temp.right = createTree(array, mid + 1, high);
			root = temp;
		}
		return root;
	}

	private void printInOrder(){
		printInOrder(this.root);
		System.out.println("");
	}

	private void printInOrder(TreeNode node){
		if(node == null) return;
		printInOrder(node.left);
		System.out.print(node.val);
		printInOrder(node.right);
	}

	private void print(Object o){
		System.out.println(o);
	}

	private void test1(){
		test("Test1", new int[]{1,2,3}, 3, false);
	}

	private void test2(){
		test("Test2", new int[]{2,5, 6, 7, 8, 9}, 6, true);
	}

	private void test3(){
		test("Test3", new int[] {1,2,3,4,5}, 3, true);
	}
}