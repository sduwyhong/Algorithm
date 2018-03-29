package For_Offer;
//输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
public class T14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLinkedList linkedList_1 = new MyLinkedList();
		MyLinkedList linkedList_2 = new MyLinkedList();
		for (int i = 1; i <= 10; i++) {
			linkedList_1.add(2*i-1);
			linkedList_2.add(2*i);
		}
		merge(linkedList_1,linkedList_2).print();
	}

	private static MyLinkedList merge(MyLinkedList linkedList_1,
			MyLinkedList linkedList_2) {
		MyLinkedList linkedList = new MyLinkedList();
		Node ref = null;
		Node ref_1 = linkedList_1.head;
		Node ref_2 = linkedList_2.head;
		while(ref_1 != null && ref_2 != null) {
			//较小的一方指针后移
			if(ref_1.value <= ref_2.value) {
				if(linkedList.head == null) {
					linkedList.head = ref_1;
					ref = linkedList.head;
				}else {
					ref.next = ref_1;
					ref = ref_1;
				}
				ref_1 = ref_1.next;
			} else{
				if(linkedList.head == null) {
					linkedList.head = ref_2;
					ref = linkedList.head;
				}else {
					ref.next = ref_2;
					ref = ref_2;
				}
				ref_2 = ref_2.next;
			}
		}
		if(ref_1 == null) {
			while(ref_2 != null) {
				ref.next = ref_2;
				ref_2 = ref_2.next;
			}
		} else {
			while(ref_1 != null) {
				ref.next = ref_1;
				ref_1 = ref_1.next;
			}
		}
		return linkedList;
	}

}
