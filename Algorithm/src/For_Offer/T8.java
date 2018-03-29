package For_Offer;
//请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制1001，有2位1。因此如果输入9，该函数输出2。
public class T8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bitCount(15));
		System.out.println(0x000000c0 ^ 0x00000040);
	}

	private static int bitCount(int i) {
		int count = 0;
		for (int j = 0; j < 32; j++) {
			count += i & 0x00000001;
			i >>>= 1;
		}
		return count;
	}

}
