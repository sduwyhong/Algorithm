package MyAlgs;

import java.util.Arrays;

//用1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列，如：512234、412345等，
//要求： "4 "不能在第三位， "3 "与 "5 "不能相连.
public class T9 {

	public static void main(String[] args) {
		int[] arr = {1,2,2,3,4,5};
		permutationByConditions(arr, 0);
	}

	private static void permutationByConditions(int[] arr, int begin) {
		
		if(arr == null || arr.length < 1 || begin < 0) throw new IllegalArgumentException();
		
		//递归结束条件：只剩下两个元素
		if(begin != arr.length - 1) {
			for (int i = begin; i < arr.length; i++) {
				if(begin != i && arr[begin] == arr[i]) continue;
				swap(arr, begin, i);
				permutationByConditions(arr, begin + 1);
				swap(arr, begin, i);
			}
		}else {
			if(isValid(arr)) System.out.println(Arrays.toString(arr));
		}
	}

	private static boolean isValid(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if((i == 2 && arr[i] == 4) || (arr[i] == 3 && i < arr.length - 1 && arr[i + 1] == 5)) return false;
		}
		return true;
	}

	private static void swap(int[] arr, int begin, int i) {
		int temp = arr[begin];
		arr[begin] = arr[i];
		arr[i] = temp;
	}

}
