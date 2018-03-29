package For_Offer;

import java.util.Stack;

//用两个栈实现一个队列。队列的声明如下，
//请实现它的两个函数appendTail 和deleteHead，
//分别完成在队列尾部插入结点和在队列头部删除结点的功能。
public class T5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> queue = new MyQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.add(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(queue.remove() + " ");
		}
	}

}
class MyQueue<T>{
	private Stack<T> stack_1;
	private Stack<T> stack_2;
	
	public MyQueue() {
		stack_1 = new Stack<T>();
		stack_2 = new Stack<T>();
	}
	
	public synchronized void add(T t) {
		stack_1.push(t);
	}
	
	public synchronized T remove() {
		//for循环里的参数要为常量
		int size_1 = stack_1.size();
		for (int i = 0; i <size_1; i++) {
			stack_2.push(stack_1.pop());
		}
		T t = stack_2.pop();
		int size_2 = stack_2.size();
		for (int i = 0; i < size_2; i++) {
			stack_1.push(stack_2.pop());
		}
		return t;
	}
	
}