package For_Offer;
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
public class T19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data1 = {1,2,3,4,5};
		int[] data2 = {5,4,3,2,1};
		System.out.println(sequenseIsPop(data1, data2));
	}
	
	public static boolean sequenseIsPop(int[] data1, int[] data2) {
		int index = 0;
		boolean result = true;
		for (int i = data1.length-1; i >= 0; i--) {
			if(data1[i] != data2[index++]) {
				result = false;
				break;
			}
		}
		return result;
	}
}
