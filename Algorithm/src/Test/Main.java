package Test;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Set;
//import java.util.TreeMap;
//public class Main {
//	public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        Map<Integer, Integer> work = new TreeMap<Integer, Integer>();
//        for (int i = 0; i < n; i++) {
//        	int d = in.nextInt();
//        	int p = in.nextInt();
//        	if(!work.containsKey(d) || work.get(d) < p) work.put(d, p);
//		}
//        int[] friends = new int[m];
//        for (int i = 0; i < m; i++) {
//        	friends[i] = in.nextInt();
//		}
//        printHighestPayment(work, friends);
//	}
//
//	private static void printHighestPayment(Map<Integer, Integer> work,
//			int[] friends) {
//		Set<Integer> keySet = null;
//		for (int i = 0; i < friends.length; i++) {
//			keySet = work.keySet();
//			int maxPay = 0;
//			for (Integer key : keySet) {
//				int p = work.get(key);
//				if(friends[i] >= key){
//					maxPay = p >= maxPay ? p : maxPay;
//				}else{
//					break;
//				}
//			}
//			System.out.println(maxPay);
//		}
//	}
//}
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        String[] strs = str.split(",");
//        int[] arr = new int[strs.length];
//        for (int i = 0; i < arr.length; i++) {
//			arr[i] = Integer.parseInt(strs[i].trim());
//		}
//        
//        findMax(arr);
//        
//    }
//
//	private static void findMax(int[] arr) {
//		int max = 0; 
//		for (int i = 0; i < arr.length - 1; i++) {
//			int cur = arr[i];
//			for (int j = i + 1; j < arr.length; j++) {
//				cur += arr[j];
//				if(cur > max) max = cur;
//			}
//		}
//		System.out.println(max);
//	}
//}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strs[i].trim());
		}
        
        findMax(arr);
        
    }

	private static void findMax(int[] arr) {
		int max = 0; 
		int max_tail = arr.length - 1;
		for (int i = 0; i < max_tail; i++) {
			int cur = arr[i];
			int temp_tail = 0;
			for (int j = i + 1; j <= max_tail; j++) {
				cur += arr[j];
				if(cur > max) {
					max = cur;
					temp_tail = j;
				}
			}
			if(temp_tail < max_tail) max_tail = temp_tail; 
//			System.out.printf("max:%d,max_tail:%d\n", max,max_tail);
		}
		System.out.println(max);
	}
}