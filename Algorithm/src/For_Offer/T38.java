package For_Offer;

import java.util.HashMap;
import java.util.Map;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
public class T38 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if(!map.containsKey(num)) map.put(num, 1);
			else map.put(num, map.get(num) + 1);
		}
		for(Integer i : map.keySet()) {
			if(map.get(i) == 1) System.out.printf("%d ", i);
		}
	}

}
