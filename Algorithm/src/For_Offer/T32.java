package For_Offer;

import java.util.ArrayList;
import java.util.List;

//在字符串中找出第一个只出现一次的字符。
//提示：两个指针
public class T32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findChar("abccbadfsaXfsdasdad");
	}

	private static void findChar(String string) {
		char[] array = string.toCharArray();
		int ref_1 = -1;
		int ref_2 = array.length-1;
		//存放出现>1的字符
		List<Integer> list = new ArrayList<Integer>();
		while(ref_1 != ref_2) {
			ref_1++;
			char c = array[ref_1];
			while(list.contains((int)c)){
				c = array[++ref_1];
			}
			ref_2 = array.length-1;
			while(array[ref_2] != c) {
				ref_2--;
				if(ref_1 == ref_2) break;
			}
			if(ref_1 != ref_2) list.add((int)c);
		}
		System.out.println(array[ref_1]);
	}

}
