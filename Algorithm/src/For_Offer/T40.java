package For_Offer;

import java.util.LinkedList;
import java.util.Queue;

//输入一个正数s，打印出所有和为s 的连续正数序列（至少两个数）。
//举例说明
//例如输入15，由于1+2+3+4+5=4＋5+6＝7+8=15，所以结果打出3 个连续序列1～5、4～6 和7～8。
public class T40 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		serialPositives(216);
	}

	private static void serialPositives(int i) {
		int[] arr = new int[i/2 + 1];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = j + 1;
		}
		int begin = 0;
		int end = begin + 1;
		int sum = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		while(begin < i/2) {
			if(queue.isEmpty()) {
				sum += arr[begin];
				queue.add(arr[begin]);
				continue;
			}
			sum += arr[end];
			if(sum == i || sum > i || end >= i/2){
				if(sum == i) {
					queue.add(arr[end]);
					print(queue, i);
				}
				begin++;
				end = begin + 1;
				sum = 0;
				queue.clear();
			}else{
				queue.add(arr[end]);
				end++;
			}
		}
	}

	private static void print(Queue<Integer> queue, int result) {
		int i = 1;
		for (Integer integer : queue) {
			if(i == queue.size()) 
				System.out.printf("%d = %d\n", integer, result);
			else System.out.printf("%d + ", integer);
			i++;
		}
	}

}
