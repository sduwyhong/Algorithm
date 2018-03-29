package For_Offer;
//输入两个链表，找出它们的第一个公共结点。
public class T35 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLinkedList linkedList_1 = new MyLinkedList();
		MyLinkedList linkedList_2 = new MyLinkedList();
		for (int i = 0; i < 10; i++) {
			linkedList_1.add(i);
			linkedList_2.add(i+5);
		}
		firstPublicNode(linkedList_1, linkedList_2);
	}

	private static void firstPublicNode(MyLinkedList linkedList_1,
			MyLinkedList linkedList_2) {
		Node ref_1 = linkedList_1.head;
		Node ref_2 = linkedList_2.head;
		while(ref_1.value != ref_2.value) {
			if(ref_1.next == null) {
				ref_1 = linkedList_1.head;
				if(ref_2.next != null) {
					ref_2 = ref_2.next;
				}else {
					System.out.println("not exists");
					return;
				}
			}else{
				ref_1 = ref_1.next;
			}
		}
		System.out.printf("the first public node is:%d", ref_1.value);
	}

}
