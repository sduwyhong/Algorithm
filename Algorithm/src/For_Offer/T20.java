package For_Offer;

import java.util.LinkedList;
import java.util.Queue;

//从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
//提示：层次遍历---》队列
public class T20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = i + 1;
		}
		binaryTree.createNode(arr);
		levelTraversal(binaryTree.root);
	}

	private static void levelTraversal(TreeNode root) {
		if(root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			//将根添加到打印队列
			queue.add(root);
			//队列中仍有节点
			while(!queue.isEmpty()) {
				//取队列头节点
				TreeNode node = queue.remove();
				//打印
				System.out.print(node.value + " ");
				//添加非空左右子节点到队列
				if(node.left!=null) queue.add(node.left);
				if(node.right!=null) queue.add(node.right);
			}
		}
		
	}

}
