package For_Offer;
//输入n个整数，找出其中最小的k个数。
//例子说明：
//例如输入4 、5 、1、6、2、7、3 、8 这8 个数字，则最小的4 个数字是1 、2、3 、4
public class T27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {4,5,1,6,2,7,3,8};
		findMinK(arr, 4);
	}

	private static void findMinK(int[] arr, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
