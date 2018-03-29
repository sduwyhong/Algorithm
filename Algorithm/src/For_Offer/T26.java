package For_Offer;

import java.util.Arrays;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
public class T26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5,5,1,5,5,5,2,4,4,5,5,3,4,4,4,5,5};
		partition(arr);
	}
	//缺点：多余的循环，例如{1,1,2,2,2}，i=1确定了1不是结果，但i=2仍会循环，可在自循环判断该数在前面是否已经出现，但开销相当。
	//另一种思路：将数组排序，位于中间的数就是结果
	private static void find(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] == arr[i]) count++;
				if(count > arr.length/2) {
					System.out.println(arr[i]);
					break;
				}
			}
		}
	}
	private static void partition(int[] arr) {
		Arrays.sort(arr);
		System.out.println(arr[arr.length/2]);
	}
	
	
}
