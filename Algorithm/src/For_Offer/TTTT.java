package For_Offer;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;


public class TTTT {
	public static void main(String[] args) {
//		char c = 'Z';
//		System.out.printf("%d:%s",(int)c,Integer.toBinaryString((int)c));
//		String s = "aab";
//		System.out.println(Arrays.toString(s.getBytes()));
//		System.out.println(Integer.toHexString(255));
//		for (int i = 0; i <= 122; i++) {
//			if(i%10 == 0) System.out.println();
//			System.out.printf("%3s ",(char)i);
//		}
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("fpgadrive.c:325", 3);
		map.put("fpgadrive.c:132", 5);
		map.put("fpgadrive.c:1325", 4);
		map.put("fpgadrive.c:125", 2);
		map.put("fpgadrive.c:15", 1);
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.printf("%s:%d\n", string, map.get(string));
		}
		String s = "fpgadrive.c:1325:4";
		System.out.println(s.substring(s.lastIndexOf(":") + 1, s.length()));
		System.out.println(Integer.MIN_VALUE - 1);
		System.out.println(Integer.MAX_VALUE + 1);
		System.out.println(Short.MIN_VALUE);
		System.out.println((short)0xffff);
		System.out.println(new Integer(~2));
	}
}
