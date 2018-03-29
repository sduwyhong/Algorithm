package For_Offer;

import java.util.Stack;

//定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
public class T13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		linkedList.print();
		linkedList.head = reverse(linkedList.head);
		System.out.println();
		linkedList.print();
	}

	private static Node reverse(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node ref = head;
		while(ref != null) {
			stack.push(ref);
			ref = ref.next;
		}
		//在java里没有引用传递，只有值传递
		//参数head为一个指针，指向linkedList.head的对象，下面这条语句执行后该指针指向了别的对象，而linkedList.head的指向不变
		head = stack.pop();
		Node current = head;
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			current.next = temp;
			current = temp;
		}
		current.next = null;
		return head;
	}

}
