package For_Offer;
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小数的min 函数。在该栈中，调用min、push 及pop的时间复杂度都是O(1)。
public class T18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 10; i < 20; i++) {
			stack.push(i);
		}
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(min(stack));
	}

	private static Integer min(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();
		int min = stack.pop();
		temp.push(min);
		while(stack.size > 0) {
			int next = stack.pop();
			if(min > next) {
				min = next;
			}
			temp.push(next);
		}
		while(temp.size > 0) {
			stack.push(temp.pop());
		}
		return min;
	}

}

class Stack<T>{
	
	Object[] arr;
	
	int size;
	
	public Stack() {
		arr = new Object[10];
	}
	
	public void push(T t) {
		if(arr.length < size + 1) {
			int newSize;
			if(arr.length + arr.length/2 < size + 1) newSize = arr.length*2;
			else newSize = arr.length + arr.length/2;
			Object[] bigger = new Object[newSize];
			for (int i = 0; i < arr.length; i++) {
				bigger[i] = arr[i];
			}
			arr = bigger;
		}
		size++;
		arr[size-1] = t;
	}
	
	public T pop() {
		T t = (T) arr[size-1];
		arr[size-1] = null;
		size--;
		return t;
	}
	
}