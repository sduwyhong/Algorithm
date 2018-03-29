package For_Offer;
//输入两棵二叉树A 和B，判断B 是不是A 的子结构。
//①找到子结构根节点在主树种的位置
//②比较分别以两个节点作为根的中序与后序遍历是否相同
public class T15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		BinaryTree subBinaryTree = new BinaryTree();
		int[] levelTraversal_1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		binaryTree.createNode(levelTraversal_1);
		int[] levelTraversal_2 = {2,4,5,8,9,10,11};
		subBinaryTree.createNode(levelTraversal_2);
		System.out.println(isSubTree(binaryTree,subBinaryTree));
	}

	private static boolean isSubTree(BinaryTree binaryTree,
			BinaryTree subBinaryTree) {
		TreeNode node = null;
		if((node = findRoot(binaryTree.root,subBinaryTree.root.value)) == null){
			return false;
		} else{
			binaryTree.root = node;
			return binaryTree.equals(subBinaryTree);
		}
	}

	private static TreeNode findRoot(TreeNode node, int value) {
		if(node != null && node.value != value) {
			TreeNode _node = null;
			if((_node = findRoot(node.left, value)) != null 
					|| (_node = findRoot(node.right, value)) != null) {
				return _node;
			}else {
				return null;
			}
		} else{
			return node;
		}
	}

}
