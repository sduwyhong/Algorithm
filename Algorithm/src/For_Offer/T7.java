package For_Offer;
//写一个函数，输入n，求斐波那契数列的第n项值。
public class T7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(10));
	}

	private static long fibonacci(int i) {
		if(i < 3) return 1;
		return fibonacci(i-2) + fibonacci(i-1);
	}

}
