package For_Offer;

import java.util.ArrayList;
import java.util.List;

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建二叉树并输出它的头结点。
public class T4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		//		int[] levelTraversal = new int[10];
		//		for (int i = 0; i < levelTraversal.length; i++) {
		//			levelTraversal[i] = i+1;
		//		}
		//		binaryTree.createNode(levelTraversal);
		//		binaryTree.inorderTraversal();
		int[] preorderTraversal = {1,2,4,7,3,5,6,8};
		int[] inorderTraversal = {4,7,2,1,5,3,8,6};
		binaryTree.rebuild(preorderTraversal, inorderTraversal);
		binaryTree.postorderTraversal();
	}

}
class BinaryTree{
	TreeNode root;
	public void createNode(int[] levelTraversal) {
		createNode(levelTraversal, 0);
	}
	public TreeNode createNode(int[] levelTraversal,int off) {
		TreeNode node = new TreeNode(levelTraversal[off]);
		if(off == 0) {
			root = node;
		}
		if(levelTraversal.length > 2*off + 1) node.left = createNode(levelTraversal,2*off+1);
		if(levelTraversal.length > 2*off + 2) node.right = createNode(levelTraversal,2*off+2);
		return node;
	}
	public TreeNode rebuild (int[] preorderTraversal, int[] inorderTraversal) {
		//递归结束条件1：传入前序遍历为空，则返回空节点（相对于完全二叉树）
		if(preorderTraversal.length == 0) {
			return null;
		}
		//当前根
		int temp_root = preorderTraversal[0];
		TreeNode node = new TreeNode(temp_root);
		if(root == null) root = node; 
		//递归结束条件2：中序元素>1继续分割，只剩一个元素否则返回当前节点
		if(inorderTraversal.length > 1 ) {

			for (int i = 0; i < inorderTraversal.length; i++) {
				if(inorderTraversal[i] == temp_root) {
					//获取根节点在中序集合中的位置，分隔中序集合中的左子树元素与右子树元素
					int[] leftIT = new int[i];
					int[] rightIT = new int[inorderTraversal.length-(i+1)];
					int rightIT_index = 0;
					for (int j = 0; j < inorderTraversal.length; j++) {
						int value = inorderTraversal[j];
						if(j < i) {
							leftIT[j] = value;
						} else if(j > i){
							rightIT[rightIT_index++] = value;
						}
					}
					//根据中序集合的分隔情况，分隔前序集合的左子树元素与右子树元素
					int[] leftPT = new int[i];
					int[] rightPT = new int[inorderTraversal.length-(i+1)];
					int rightPT_index = 0;
					for (int j = 1; j < preorderTraversal.length; j++) {
						int value = preorderTraversal[j];
						if(j<i+1) {
							leftPT[j-1] = value;
						} else{
							rightPT[rightPT_index++] = value;
						}
					}
					//递归，返回的左子树节点及时添加到当前节点
					node.left = rebuild(leftPT, leftIT);
					if(node.left!=null)
						System.out.println(node.left.value + "节点被设置为" + node.value + "的左孩子");
					//递归，返回的右子树节点及时添加到当前节点
					node.right = rebuild(rightPT, rightIT);
					if(node.right!=null)
						System.out.println(node.right.value + "节点被设置为" + node.value + "的右孩子");
				}
			}
		}
		return node;
	}
	public void inorderTraversal() {
		System.out.print("中序遍历：");
		inorderTraversal(root);
	}
	public void postorderTraversal() {
		System.out.print("后序遍历：");
		postorderTraversal(root);
	}
	public void inorderTraversal(TreeNode node) {
		if(node!=null) {
			inorderTraversal(node.left);
			System.out.print(node.value+" ");
			inorderTraversal(node.right);
		}
	}
	public void postorderTraversal(TreeNode node) {
		if(node!=null) {
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.value+" ");
		}
	}
	public String inorder(TreeNode node, StringBuilder result) {
		if(node!=null) {
			inorder(node.left, result);
			result.append(node.value);
			inorder(node.right, result);
		}
		return result.toString();
	}
	public String postorder(TreeNode node, StringBuilder result) {
		if(node!=null) {
			postorder(node.left, result);
			postorder(node.right, result);
			result.append(node.value);
		}
		return result.toString();
	}
	public boolean equals(BinaryTree tree) {
		System.out.println(inorder(this.root, new StringBuilder()));
		System.out.println(inorder(tree.root, new StringBuilder()));
		System.out.println(postorder(this.root, new StringBuilder()));
		System.out.println(postorder(tree.root, new StringBuilder()));
		return (inorder(this.root, new StringBuilder()).equals(inorder(tree.root, new StringBuilder())) 
				&& postorder(this.root, new StringBuilder()).equals(postorder(tree.root, new StringBuilder())));
	}
	
}
class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int value) {
		super();
		this.value = value;
	}

}