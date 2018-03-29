package MyAlgs;

import java.util.HashMap;
import java.util.Map;

//比如，968548+968545=321732732它的答案里没有前面两个数里的数字，有多少这样的6位数。
public class T12 {

	public static void main(String[] args) {
		specialSixDigits();
	}

	private static void specialSixDigits() {
		Map<Integer, Integer> map = null;
		for (int i = 10; i < 100; i++) {
			for(int j = i; j < 100; j++) {
				//判断0~9的重复，还可以用数组 int[] a={0,0,0,0,0,0,0,0,0,0}，其中下标表示数字，值表示出现次数
				map = new HashMap<Integer, Integer>();
				boolean flag = true;
				int _i = i;
				int _j = j;
				while(_i != 0) {
					map.put(_i % 10, 1);
					map.put(_j % 10, 1);
					_i /= 10;
					_j /= 10;
				}
				long sum = i + j;
				while(sum != 0) {
					int remainder = (int) (sum % 10);
					if(map.containsKey(remainder)) {
						flag = false;
						break;
					}
					sum /= 10;
				}
				if(flag) System.out.printf("%d + %d = %d\n", i, j, (long)(i + j));
			}
		}
	}

}
