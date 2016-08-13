/* Height of Binary Tree */

public class BinaryTree{
	TreeNode root;

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}}

	public static void main(String [] args){
		BinaryTree obj = new BinaryTree();

		obj.constructTree();
		obj.inorder();
		System.out.println("\nThe Max height of the tree: " + obj.maxHeight());
		System.out.println("\nThe Min height of the tree: " + obj.minHeight());

		System.out.println("\nIs tree balanced: " + obj.isBalanced());
	}

	private void constructTree(){
		TreeNode temp = new TreeNode(20, new TreeNode(6, new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),new TreeNode(5)),
														 new TreeNode(14, new TreeNode(12), new TreeNode(15)))
					,new TreeNode(28, new TreeNode(26), new TreeNode(29)));
		this.root = temp;
	}

	private void inorder(){
		inorder(this.root);
	}

	private void inorder(TreeNode current){
		if(current == null) return;
		inorder(current.left);
		System.out.print(current.val + "\t");
		inorder(current.right);

	}

	private int maxHeight(){
		return maxHeight(this.root);
	}

	private int maxHeight(TreeNode current){
		if(current == null) return 0;
		else return 1 + Math.max(maxHeight(current.left),maxHeight(current.right));
	}

	private int minHeight(){
		return minHeight(this.root);
	}

	private int minHeight(TreeNode current){
		if(current == null) return 0;
		else return 1 + Math.min(minHeight(current.left), minHeight(current.right));
	}

	private boolean isBalanced(){
		return isBalanced(this.root);
	}

	private boolean isBalanced(TreeNode current){
		if(current == null) return true;
		int leftHeight = maxHeight(current.left);
		int righHeight = maxHeight(current.right);

		return Math.abs(leftHeight - righHeight) <= 1;
	}
}