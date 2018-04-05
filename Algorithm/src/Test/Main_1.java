package Test;
import java.util.Scanner;
public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean positive = false;
        int reverse = 1;
        int sum = 0;
        for (int i = 1; i <= 2*m; i++) {
        	if(!positive) {
        		sum += -i;
        	}else{
        		sum += i;
        	}
        	
        	if(reverse++ == m) {
        		reverse = 1;
        		if(positive) positive = false;
        		else positive = true;
        	}
		}
        //收获：亿级的变量参与乘法运算要考虑到溢出
        System.out.print(1L*(n/(2*m))*sum);
    }
}