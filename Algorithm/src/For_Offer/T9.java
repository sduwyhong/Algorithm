package For_Offer;
//输入数字n，按顺序打印出从1到n位最大十进数的数值。比如输入3，则打印出1、2、3一直到最大三位数即999。
public class T9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print_2(3);
	}

	private static void print_2(int i) {
		int[] num = new int[i];
		//个位每次+1，到10的时候个位置0，前一位进1，直到所有位都为9
		add(num, num.length-1);
	}

	private static void add(int[] num, int off) {
		//递归结束条件：将要被+1的数是数组的首位且已经为9
		if(num[off] != 9) {
			//当前位不为9，+1，打印，然后进行个位+1
			num[off]++;
			printCur(num);
			add(num, num.length-1);
		}else if(off != 0){
			//当前位为9，则置0，前一位进1
			num[off] = 0;
			add(num,off-1);
		}
	}

	private static void printCur(int[] num) {
		for (int i = 0; i < num.length; i++) {
			if(i != num.length-1) System.out.print(num[i]);
			else System.out.print(num[i]+",");
		}
	}

	private static void print_1(int i) {
		int max = (int) Math.pow(10, i);
		for (int j = 1; j < max ; j++) {
			if(j != max-1) {
				System.out.print(j+",");
			}else {
				System.out.print(j);
			}
		}
	}

}
