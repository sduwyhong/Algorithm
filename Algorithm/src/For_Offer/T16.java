package For_Offer;
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//每个节点的任务：把右子树和左子树对调
public class T16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] levelTraversal_1 = {1,2,3,4,5,6,7,8,9,10};
		binaryTree.createNode(levelTraversal_1);
		mirror(binaryTree.root);
		binaryTree.inorderTraversal();
	}

	private static TreeNode mirror(TreeNode root) {
		if(root != null) {
			//记录左右孩子，否则递归2中参数受递归1结果影响
			TreeNode left = root.left;
			TreeNode right = root.right;
			//递归1
			root.left = mirror(right);
			if(root.left!=null)
				System.out.println(root.value + "的左孩子变成" + root.left.value);
			//递归2
			root.right = mirror(left);
			if(root.right!=null)
				System.out.println(root.value + "的右孩子变成" + root.right.value);
		}else {
			return null;
		}
		return root;
	}

}
