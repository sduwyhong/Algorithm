package For_Offer;
//输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
//例子说明：
//例如输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，和最大的子数组为｛3, 10, -4, 7, 2}。因此输出为该子数组的和18 。
public class T28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
		findMaxSub(arr);
	}

	private static void findMaxSub(int[] arr) {
		if(arr.length < 1 || arr == null) throw new IllegalArgumentException("invalid array");
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int cur = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] > max) max = arr[j];
				else{
					cur += arr[j];
					if(cur > max) max = cur;
				}
			}
		}
		System.out.println(max);
	}

}
