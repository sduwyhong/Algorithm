package Test;
import java.util.Scanner;
public class Main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int[][] arr = new int[2][2];
        for (int i = 0; i < arr.length; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
        int sum = 0;
        for (int i = 0; i <= arr[0][1]; i++) {
        	for (int j = 0; j <= arr[1][1]; j++) {
				if(K == arr[0][0] * i + arr[1][0] * j) {
					sum += pl(arr[0][1], i) * pl(arr[1][1], j);
				}
			}
		}
        System.out.println(sum % 1000000007);
    }

	private static int pl(int i, int j) {
		if(j == 0) return 0;
		if(j == i) return 1;
		return jc(i)/(jc(i-j) * jc(j));
	}

	private static int jc(int j) {
		if(j == 1) return 1;
		return j * jc(j - 1);
	}
}
