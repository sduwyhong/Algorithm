package MyAlgs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//给你一组字符如{1，3，4，7，2，1，1，5，2}，让你输出里面出现次数最多且数值最大的一个，出现几次
//8
//1 3 4 7 2 1 5 2
//6
//9 5 4 6 2 4
//10
//1 5 1 9 8 1 5 8 5 9

public class T6 {

	public static void main(String[] args) {
//		int[] arr = {1,3,4,7,2,1,5,2};
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int[] arr = new int[scan.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scan.nextInt();
			}
			printFreq(arr);
		}
	}

	private static void printFreq(int[] arr) {
		
		if(arr == null || arr.length < 1) throw new IllegalArgumentException();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if(!map.containsKey(i)) map.put(i, 1);
			else map.put(i, map.get(i) + 1);
		}
		Set<Integer> keySet = map.keySet();
		int result_key = 0;
		for (int key : keySet) {
			if(result_key == 0) {
				result_key = key;
				continue;
			}
			if(map.get(key) > map.get(result_key)) result_key = key;
			else if(map.get(key) == map.get(result_key)) {
				if(key > result_key) result_key = key;
			}
		}
		System.out.printf("出现次数最多的数是：%s，出现的次数是：%d\n", result_key, map.get(result_key));
	}

}
