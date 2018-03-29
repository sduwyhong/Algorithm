package For_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
//提示：二叉树向下遍历路径符合前序遍历顺序（先根后两叶）
public class T22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] levelTraversal = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		binaryTree.createNode(levelTraversal);
		for (int i = 1; i < 27; i++) {
			findPaths(binaryTree.root, i);
		}
	}

	private static void findPaths(TreeNode root, int target) {
		List<Integer> queue = new LinkedList<Integer>();
		findPaths(root, target, queue, 0);
	}

	/**
	 * @param root 当前根节点
	 * @param target 目标数值
	 * @param queue 装路径的队列
	 * @param cur 当前数值
	 */
	private static void findPaths(TreeNode root, int target, List<Integer> queue, int cur) {
		if(cur + root.value > target) return;
		if(cur + root.value == target) {
			queue.add(root.value);
			print(queue, target);
		}
		else{
			cur += root.value;
			queue.add(root.value);
			if(root.left != null)
				findPaths(root.left, target, queue, cur);
			if(root.right != null)
				findPaths(root.right, target, queue, cur);
		}
		queue.remove(queue.size()-1);
	}

	private static void print(List<Integer> queue, int target) {
		System.out.println("target="+target+":"+Arrays.toString(queue.toArray()));
	}

}
