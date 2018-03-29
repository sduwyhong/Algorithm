package Test;
import java.util.*;

public class Finder {
	
	public static void main(String[] args) {
		int[] arr = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
		System.out.println(findKth(arr, 49, 24));
	}
	
	public static int findKth(int[] a, int n, int K) {
		// write code here
		return quickSort(a, 0, n - 1, K);
	}

	private static int quickSort(int[] a, int i, int j, int k) {
		int left = i;
		int right = j;
		int _return = 0;
		if(i < j) {
			while(left != right) {
				//右边小于基准
				if(a[right] < a[left]) {
					swap(a, left, right);
					while(left != right) {
						//左边大于基准
						if(a[left] > a[right]) {
							swap(a, left, right);
							break;
						}else{
							left++;
						}
					}
				}else {
					right--;
				}
			}
			//判断K-1与当前重合指针下标的大小关系，只用选取一边进行快排
			if(left == k - 1) _return =  a[left];
			else if(left > k - 1) _return =  quickSort(a, i, left - 1, k);
			else _return =  quickSort(a, right + 1, j, k); 
		}
		return i == j ? a[i] : _return;
	}

	private static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}