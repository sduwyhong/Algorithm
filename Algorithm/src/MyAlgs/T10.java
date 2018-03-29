package MyAlgs;


//编写一个程序，有1，2,3,4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
public class T10 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		for (int i = -1; i < 3; i++) {
			if(i == -1) permutation(arr, 3, 0);
			else {
				swap(arr, i, 3);
				permutation(arr, 3, 0);
				swap(arr, i, 3);
			}
		}
	}

	private static void permutation(int[] arr, int bitCount, int begin) {

		if(arr == null || arr.length < 1 || arr.length < bitCount) throw new IllegalArgumentException();

		if(begin != bitCount - 1) {
			for (int j = begin; j < bitCount; j++) {
				swap(arr, begin, j);
				permutation(arr, bitCount, begin + 1);
				swap(arr, begin, j);
			}	
		}else{
			for (int i = 0; i < bitCount; i++) {
				System.out.printf("%d", arr[i]);
			}
			System.out.println();
		}
	}

	private static void swap(int[] arr, int begin, int i) {
		int temp = arr[begin];
		arr[begin] = arr[i];
		arr[i] = temp;
	}

}
