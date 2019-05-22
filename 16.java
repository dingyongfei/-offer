//一、递归版本：
public ListNode Merge(ListNode list1,ListNode list2) {
	if (list1 == null) 
		return list2;
	if (list2 == null)
		return list1;
	if (list1.val <= list2.val) {
		list1.next = Merge(list1.next, list2);
		return list1;
	} else {
		list2.next = Merge(list1, list2.next);
		return list2;
	}
}
//二、非递归版本
public ListNode Merge(ListNode list1,ListNode list2) {
	if (list1 == null) {
		return list2;
	}
	if (list2 == null) {
		return list1;
	}
	ListNode mergeHead =null;
	ListNode current = null;          //新建一个current节点
	while (list1 != null && list2 != null) {
		if (list1.val <= list2.val) {
			if (mergeHead == null) {
				mergeHead = current = list1;
			} else {
				current.next = list1;
				current = current.next;
			} 
			list1 = list1.next;       //注意该位置
		} else {
			if (mergeHead == null) {
				mergeHead = current = list2;
			} else {
				current.next = list2;
				current = current.next;
				}
			list2 = list2.next;
		}
	}
	if (list1 == null) {
		current.next = list2;
	} else {
		current.next = list1;
	}
	return mergeHead;
}
