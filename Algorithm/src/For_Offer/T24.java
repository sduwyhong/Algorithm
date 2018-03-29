package For_Offer;

import java.util.ArrayList;
import java.util.List;

import For_Offer.BinarySearchTree.TreeNode;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
//提示：中序遍历
public class T24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {10,8,13,3,9,11,18};
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(arr);
		printLinkedList(toSortedTwoWayLinkedList(binarySearchTree.root));
	}

	private static void printLinkedList(TreeNode root) {
		while(root.left != null) {
			root = root.left;
		}
		while(root != null) {
			System.out.print(root.value+" ");
			root = root.right;
		}
	}

	private static TreeNode toSortedTwoWayLinkedList(
			TreeNode root) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		toSortedTwoWayLinkedList(root, nodes);
		TreeNode[] arr = new TreeNode[nodes.size()];
		nodes.toArray(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr.length <= 1) arr[0].left = arr[0].right = null;
			if(i == 0){
				arr[0].left = null;
				arr[0].right = arr[1];
			}else if(i == arr.length-1){
				arr[i].left = arr[i-1];
				arr[i].right = null;
			}else{
				arr[i].left = arr[i-1];
				arr[i].right = arr[i+1];
			}
		}
		return arr[0];
	}

	private static void toSortedTwoWayLinkedList(TreeNode root,
			List<TreeNode> nodes) {
		if(root != null) {
			toSortedTwoWayLinkedList(root.left, nodes);
			nodes.add(root);
			toSortedTwoWayLinkedList(root.right, nodes);
		}
	}
}
class BinarySearchTree{
	public TreeNode root;
	class TreeNode{
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}
	public void add(int value) {
		add(value, root);
	}
	public void add(int[] values) {
		for (int i = 0; i < values.length; i++) {
			add(values[i], root);
		}
	}
	private void add(int value, TreeNode _root) {
		if(root == null) root = new TreeNode(value);
		else {
			if(_root.value > value) {
				if(_root.left == null) {
					_root.left = new TreeNode(value);
					return;
				}
				else {
					add(value, _root.left);
				}
			}
			if(_root.value < value) {
				if(_root.right == null) {
					_root.right = new TreeNode(value);
					return;
				}
				else {
					add(value, _root.right);
				}
			}
		}
	}
	public void inorderTraversal(TreeNode root) {
		if(root != null) {
			inorderTraversal(root.left);
			System.out.print(root.value+" ");
			inorderTraversal(root.right);
		}
	}
}