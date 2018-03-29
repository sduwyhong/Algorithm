package MyAlgs;

import java.util.HashMap;
import java.util.Map;

//639172每个位数上的数字都是不同的，且平方后所得数字的所有位数都不会出现组成它自身的数字。
//（639172*639172=408540845584），类似于639172这样的6位数还有几个？分别是什么？
public class T11 {

	public static void main(String[] args) {
		specialSixDigits();
	}

	private static void specialSixDigits() {
		Map<Integer, Integer> map = null;
		for (int i = 100000; i < 1000000; i++) {
			map = new HashMap<Integer, Integer>();
			int number = i;
			boolean flag = true;
			while(number != 0) {
				int remainder = number % 10;
				if(map.containsKey(remainder)) {
					flag = false;
					break;
				}
				map.put(remainder, 1);
				number /= 10;
			}
			long square = (long) Math.pow(i, 2);
			while(square != 0) {
				int remainder = (int) (square % 10);
				if(map.containsKey(remainder)) {
					flag = false;
					break;
				}
				square /= 10;
			}
			if(flag) System.out.printf("%d * %d = %d\n", i, i, (long)Math.pow(i, 2));
		}
	}

}
