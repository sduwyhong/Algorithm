package For_Offer;
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
public class T11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		parityAdjustment(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	//维护两个指针，初始时指针1位于数组头部，指针2位于数组尾部，若指针1所指元素为奇数则后移1位，否则检查指针2所指元素是否为偶数，
	//若是则指针2前移一位，当指针1所指元素为偶数同时指针2所指元素为奇数时交换两个元素
	private static void parityAdjustment(int[] arr) {
		int front_ref = 0;
		int back_ref = arr.length-1;
		while(front_ref != back_ref) {
			if(arr[front_ref]%2 == 0) {
				if(arr[back_ref]%2 != 0) {
					int temp = arr[front_ref];
					arr[front_ref] = arr[back_ref];
					arr[back_ref] = temp;
				} else{
					back_ref--;
				}
			} else{
				front_ref++;
			}
		}
	}

}
