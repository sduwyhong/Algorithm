package For_Offer;
//输入个链表的头结点，从尾到头反过来打印出每个结点的值。
import java.util.ArrayList;

public class T3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = new MyLinkedList();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		linkedList.printFromTail();
	}

}

class MyLinkedList{
	Node head;
	public void add(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
		} else {
			Node ref = head;
			while(ref.next != null) {
				ref = ref.next;
			}
			ref.next = newNode;
		}
	}
	public void printFromTail(){
		MyStack<Integer> stack = new MyStack<Integer>();
		if(head != null) stack.push(head.value);
		Node ref = head.next;
		while(ref != null) {
			stack.push(ref.value);
			ref = ref.next;
		}
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			System.out.print(stack.pop()+" ");
		}
	}
	public void print() {
		Node ref = head;
		while(ref != null) {
			System.out.print(ref.value + " ");
			ref = ref.next;
		}
	}
	public void remove(Node head, Node node) {
		if(head.value == node.value) head = head.next;
		else{
			Node ref = head;
			while(ref.next.value != node.value && ref.next.next != null) {
				ref = ref.next;
			}
			if(ref.next.next != null) {
				ref.next = ref.next.next;
			}
		}
	}
}

class Node{
	public int value;
	public Node next;
	public Node(int value) {
		super();
		this.value = value;
	}
}

class MyStack<T>{
	private ArrayList<T> values;
	private int size;
	public MyStack() {
		values = new ArrayList<T>();
	}
	public void push(T t){
		values.add(t);
		size++;
	}
	public T pop(){
		return values.remove(--size);
	}
	public int size() {
		return size;
	}
}