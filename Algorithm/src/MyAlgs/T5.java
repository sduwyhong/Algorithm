package MyAlgs;
//给你一组字符串如：iu7i8hy4jnb2，让你编程输出里面的数字：7842   
public class T5 {

	public static void main(String[] args) {
		String str = "iu7i8hy4jnb2";
		printNumberInString(str);
	}

	private static void printNumberInString(String str) {
		
		if(str == null || str.length() < 1) throw new IllegalArgumentException();
		
		System.out.println(str.replaceAll("\\D", ""));
	}

}
