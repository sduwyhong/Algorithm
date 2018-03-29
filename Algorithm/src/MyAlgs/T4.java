package MyAlgs;

import java.util.Arrays;

//假设字符串类似这样的aba和aab就相等，现在随便给你二组字符串，请编程比较他们看是否相等 
public class T4 {

	public static void main(String[] args) {
		String str_1 = "aba";
		String str_2 = "aab";
		System.out.println(compareString(str_1, str_2));
	}

	private static boolean compareString(String str_1, String str_2) {
		
		if(str_1 == null || str_2 == null) throw new IllegalArgumentException();
		
		char[] chars_1 = str_1.toCharArray();
		char[] chars_2 = str_2.toCharArray();
		Arrays.sort(chars_1);
		Arrays.sort(chars_2);
		return new String(chars_1).equals(new String(chars_2));
	}	

}
