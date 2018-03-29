package For_Offer;
//输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1 ，那么它就是一棵平衡二叉树。
public class T37 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] levelTraversal = {1,2,3,4,0,6,7,8,0};;
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createNode(levelTraversal);
		System.out.println(isAVLTree(binaryTree.root));
	}

	private static boolean isAVLTree(TreeNode root) {
		
		if(root == null) return true;
		
		int left_height = 0;
		int right_height = 0;
		if(root.left != null) left_height = T36.height(root.left);
		if(root.right != null) right_height = T36.height(root.right);
		if(Math.abs(left_height - right_height) > 1) return false;
		
		return isAVLTree(root.left) && isAVLTree(root.right);
	}

}
