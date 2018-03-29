package For_Offer;
//把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。
//例如数组{3,4,5,1,2 ｝为｛ 1,2,3,4,5}的一个旋转，该数组的最小值为1。
public class T6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {13,14,15,16,17,18,19,20,1,2,3,4,5,6,7,8,9,10,11,12};
		System.out.println(min_2(array));
	}

	private static int min_2(int[] array) {
		int ref_1 = 0;
		int ref_2 = array.length-1;
		int mid = (ref_1+ref_2)/2;
		//最终指针1指向前面递增数组的最大值，指针2指向后面递增数组的最小值
		while(ref_1+1 != ref_2) {
			if(array[mid] > array[ref_1]) {
				//位于前面递增数组，最小值肯定在中间的后面，前面指针移到中间
				ref_1 = mid;
				mid = (ref_1+ref_2)/2;
			}
			if(array[mid] < array[ref_2]) {
				//位于前面递增数组，最小值肯定在中间的前面，后面指针移到中间
				ref_2 = mid;
				mid = (ref_1+ref_2)/2;
			}
		}
		return array[ref_2];
	}

	private static int min_1(int[] array) {
		int min = 0;
		for (int i = 0; i < array.length; i++) {
			if(i == 0) min = array[0];
			else {
				if(array[i] < min) min = array[i];
			}
		}
		return min;
	}

}
