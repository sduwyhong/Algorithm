package For_Offer;
//输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
//提示：如果一棵树只有一个结点，它的深度为1。 如果根结点只有左子树而没有右子树， 那么树的深度应该是其左子树的深度加1，
//	      同样如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1. 如果既有右子树又有左子树， 那该树的深度就是其左、右子树深度的较大值再加1。
public class T36 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] levelTraversal = {1,2,3,4,0,6,7,8,0};;
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createNode(levelTraversal);
		System.out.printf("height:%d",height(binaryTree.root));
	}

	public static int height(TreeNode root) {
		if(root.left == null || root.right == null){
			return 1;
		}
		int left_height = 0;
		int right_height = 0;
		if(root.left.value != 0) left_height = height(root.left);
		if(root.right.value != 0) right_height = height(root.right);
//		System.out.printf("root:%d, left_height:%d, right_height:%d", root.value, left_height, right_height);
		return left_height > right_height ? left_height + 1 : right_height + 1; 
	}

}
