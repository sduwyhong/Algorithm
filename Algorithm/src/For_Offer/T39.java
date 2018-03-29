package For_Offer;
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
//举例说明
//例如输入数组｛1 、2 、4、7 、11 、15 ｝和数字15. 由于4+ 11 = 15 ，因此输出4 和11 。
public class T39 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,4,7,11,15};
		printAddends(arr, 15);
	}

	private static void printAddends(int[] arr, int result) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == result) System.out.printf("%d + %d = %d", arr[i], arr[j], result);
			}
		}
	}

}
