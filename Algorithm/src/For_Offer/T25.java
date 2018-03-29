package For_Offer;
//输入一个字符串，打印出该字符串中字符的所有排列。
//例如输入字符串abc,则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba 。
public class T25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fullPermutation("abcd");
	}

	private static void fullPermutation(String string) {
		fullPermutation(string.toCharArray(), 0);
	}

	private static void fullPermutation(char[] string, int head) {
		if(head != string.length - 1) {
			for (int i = head; i < string.length; i++) {
				//把第一个字符与后面第i个字符作交换
				swap(string, head, i);
				//将新字符串的子串作全排列
				fullPermutation(string, head + 1);
				//复原，否则原字符串顺序会乱
				swap(string, head, i);
			} 
		}else {
			//已经是最后一个字符，则打印当前字符串
			System.out.print(new String(string)+" ");
		}
	}

	private static void swap(char[] string, int toSwap, int swappingIndex) {
		char temp = string[toSwap];
		string[toSwap] = string[swappingIndex];
		string[swappingIndex] = temp;
	}
}
