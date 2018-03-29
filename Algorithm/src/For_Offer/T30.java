package For_Offer;
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//例子说明：
//例如输入数组{3， 32, 321}，则扫描输出这3 个数字能排成的最小数字321323。
public class T30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3, 32, 321};
		permutationMin(arr);
	}

	private static void permutationMin(int[] arr) {
		if(arr == null || arr.length < 1) throw new IllegalArgumentException("invalid array");
		System.out.println(permutationMin(arr, 0, 0));
	}

	private static int permutationMin(int[] arr, int i, int min) {
		if(i != arr.length-1) {
			for (int j = i; j < arr.length; j++) {
				swap(arr, i, j);
				min = permutationMin(arr, i+1, min);
				swap(arr, j, i);
			}
		}else {
			String cur = "";
			for (int j2 = 0; j2 < arr.length; j2++) {
				cur += arr[j2];
			}
			int _cur = Integer.parseInt(cur);
			if(min != 0) {
				if(_cur < min) {
					return _cur;
				}
			}else{
				min = _cur;
			}
		}
		return min;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
