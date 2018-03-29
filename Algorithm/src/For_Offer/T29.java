package For_Offer;
//输入一个整数n，求从1 到n这n个整数的十进制表示中1 出现的次数。
//举例说明：
//例如输入12 ，从1 到12 这些整数中包含1 的数字有1、10、11 和12，1 一共出现了5 次。
public class T29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		frequencyOfOne_2(12);
	}
	//字符串解法
	private static void frequencyOfOne_1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			char[] digit = (i+"").toCharArray();
			for (int j = 0; j < digit.length; j++) {
				if(digit[j] == '1') count++;
			}
		}
		System.out.println(count);
	}
	//取余解法
	private static void frequencyOfOne_2(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int digit = i;
			if(digit%10 == 1) count++;
			if(digit >= 10){
				while(digit > 0) {
					digit /= 10;
					if(digit%10 == 1) count++;
				}
			}
		}
		System.out.println(count);
	}
}
