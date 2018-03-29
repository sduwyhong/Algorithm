package For_Offer;
//在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//举例分析
//例如在数组｛7, 5, 6, 4 中， 一共存在5 个逆序对，分别是（7, 6）、（7，5），(7, 4）、（6, 4）和（5, 4）。
//提示：两个指针
public class T34 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {7,5,6,4};
		invertedSequence(arr);
	}

	private static void invertedSequence(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if(arr[i] > arr[j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
