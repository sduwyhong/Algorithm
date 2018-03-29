package For_Offer;
//给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点。
public class T10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		linkedList.printFromTail();
		linkedList.remove(linkedList.head, new Node(5));
		System.out.println();
		linkedList.printFromTail();
	}

}
