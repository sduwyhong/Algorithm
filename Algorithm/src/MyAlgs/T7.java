package MyAlgs;
//求两个数的最大公约数，M，N 
public class T7 {

	public static void main(String[] args) {
		int m = 45234;
		int n = 4564;
		greatestCommonDivisor(m, n);
	}

	private static void greatestCommonDivisor(int m, int n) {
		
		if(m <=0 || n <= 0) throw new IllegalArgumentException();
		
		if(m % n == 0) {
			System.out.printf("最大公约数为：%d", n);
			return;
		}
		int gcd = n - 1;
		for (int i = gcd; i > 0; i--) {
			if(m % i == 0 && n % i == 0) {
				System.out.printf("最大公约数为：%d", i);
				return;
			}
		}
	}

}
