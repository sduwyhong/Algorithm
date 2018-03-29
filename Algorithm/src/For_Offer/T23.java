package For_Offer;
//请实现函数ComplexListNode clone(ComplexListNode head),复制一个复杂链表。
//在复杂链表中，每个结点除了有一个next 域指向下一个结点外，还有一个sibling 指向链表中的任意结点或者null。
public class T23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexListNode head = new ComplexListNode(1);
		ComplexListNode clone = clone(head);
	}

	private static ComplexListNode clone(ComplexListNode head) {
		if(head == null) return null;
		copyNext(head);
		copySibling(head);
		ComplexListNode clone_one = null;
		while(head != null) {
			if(clone_one == null) {
				clone_one = head.next;
			}else {
				clone_one.next = head.next;
				clone_one = clone_one.next;
			}
			head.next = head.next.next;
			head = head.next;
		}
		return clone_one;
	}

	private static void copySibling(ComplexListNode head) {
		while(head != null) {
			if(head.sibling != null) {
				head.next.sibling = head.sibling.next;
			}
			head = head.next.next;
		}
	}

	private static void copyNext(ComplexListNode head) {
		while(head != null) {
			ComplexListNode newNode = new ComplexListNode(head.value);
			newNode.next = head.next;
			head.next = newNode.next;
			head = head.next.next;
		}
	}

}
class ComplexListNode{
	public int value;
	public ComplexListNode next;
	public ComplexListNode sibling;
	public ComplexListNode(int value) {
		super();
		this.value = value;
	}
}
