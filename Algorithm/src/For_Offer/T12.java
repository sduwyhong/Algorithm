package For_Offer;

import java.util.Stack;

//输入一个链表，输出该链表中倒数第k 个结点。
//为了符合大多数人的习惯，本题从1 开始计数，即链表的尾结点是倒数第1 个结点．
//例如一个链表有6 个结点，从头结点开始它们的值依次是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点。
public class T12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		for (int i = 1; i < 7; i++) {
			linkedList.add(i);
		}
		reciprocal(linkedList, 3);
	}

	private static void reciprocal(MyLinkedList linkedList, int i) {
		Node head = linkedList.head;
		Stack<Integer> stack = new Stack<Integer>();
		Node ref = head;
		while(ref != null) {
			stack.push(ref.value);
			ref = ref.next;
		}
		for (int j = 0; j < i-1; j++) {
			stack.pop();
		}
		System.out.println(stack.pop());
	}

}
