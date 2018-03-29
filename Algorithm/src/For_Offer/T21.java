package For_Offer;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
public class T21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		invalid
		int[] sequence_1 = {8,9,4,10,11,5};
//		invalid
		int[] sequence_2 = {7,4,6,5};
//		valid
		int[] sequence_3 = {3,9,8,11,18,13,10};
		System.out.println(verifySequenceOfBST(sequence_3));
	}
	//找到第一个比根大的值，分隔左右子树，判断左子树元素是否都比根小，右子树元素是否都比根大
	public static boolean verifySequenceOfBST(int[] sequence) {
		int[] leftChild = null;
		int[] rightChild = null;
		if(sequence.length > 1) {
			int root = sequence[sequence.length-1];
			int division = -1;
			for (int i = 0; i < sequence.length - 1 ; i++) {
				if(sequence[i] > root) {
					division = i;
					break;
				}
			}
			if(division == -1) {
				leftChild = new int[sequence.length-1];
				for (int i = 0; i < leftChild.length; i++) {
					if(sequence[i] > root) return false;
					leftChild[i] = sequence[i];
				}
			}else if(division == 0) {
				rightChild = new int[sequence.length-1];
				for (int i = 0; i < rightChild.length; i++) {
					if(sequence[i] < root) return false;
					rightChild[i] = sequence[i];
				}
			}else {
				leftChild = new int[division];
				for (int i = 0; i < leftChild.length; i++) {
					if(sequence[i] > root) return false;
					leftChild[i] = sequence[i];
				}
				rightChild = new int[sequence.length - division - 1];
				for (int i = 0; i < rightChild.length; i++) {
					if(sequence[division + i] < root) return false;
					rightChild[i] = sequence[division + i];
				}
			}
		}else {
			return true;
		}
		return verifySequenceOfBST(leftChild) && verifySequenceOfBST(rightChild);
	}
}
