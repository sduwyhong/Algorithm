package For_Offer;
//我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
//举例说明：
//例如6、8 都是丑数，但14 不是，它包含因子7。习惯上我们把1 当做第一个丑数。
public class T31 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		findUglyNumber_2(1500);
		System.out.printf("cost:%d", System.currentTimeMillis() - start);
	}

	private static void findUglyNumber_1(int i) {
		if(i < 1) throw new IllegalArgumentException("invalid input");
		int count = 0;
		int number = 1;
		while(count < i) {
			number++;
			int _number = number;
			while(_number % 2 == 0) _number /= 2;
			while(_number % 3 == 0) _number /= 3;
			while(_number % 5 == 0) _number /= 5;
			if(_number == 1) count++;
		}
		System.out.println(number);
	}
	
	private static void findUglyNumber_2(int i) {
		if(i < 0) throw new IllegalArgumentException("invalid input");
		int[] arr = new int[i+1];
		arr[0] = 1;
		for (int k = 1; k < arr.length; k++) {
			int min_2 = 0;
			int min_3 = 0;
			int min_5 = 0;
			for (int j = 0; j < k; j++) {
				if(min_2 <= arr[k-1]) min_2 = arr[j] * 2;
				if(min_3 <= arr[k-1]) min_3 = arr[j] * 3;
				if(min_5 <= arr[k-1]) min_5 = arr[j] * 5;
			}
			min_2 = min_2 < min_3 ? min_2 : min_3;
			min_2 = min_2 < min_5 ? min_2 : min_5;
			arr[k] = min_2;
		}
		System.out.println(arr[arr.length-1]);
	}
}
