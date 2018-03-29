package MyAlgs;
//编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。 
//但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"，6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
public class T1 {

	public static void main(String[] args) {
		String string = "我ABC汉DEF";
		int bytes = 4;
		cutOutString(string, bytes);
	}

	private static void cutOutString(String string, int bytes) {
		
		if(string == null || string.length() < bytes || bytes < 0) throw new IllegalArgumentException();
		
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(bytes > 0) {
				if(isLetter(chars[i])) {
					System.out.printf("%s", chars[i]);
					bytes--;
				}else {
					if(bytes >= 2) {
						System.out.printf("%s", chars[i]);
						bytes -= 2;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
	}

	private static boolean isLetter(char c) {
		//一个字节表示字母和数字
		int letter_max = 0x80;
		if(c/letter_max == 0) return true;
		return false;
	}

}
