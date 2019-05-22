public class Solution {
	public ListNode deleteDuplication(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.val == head.next.val) {
			ListNode node = head.next;
			while (node != null && node.val == head.val) {
				node = node.next;
			}
			return deleteDuplication(node);
		} else {
			head.next = deleteDuplication(head.next);
			return head;
		}
	}
}

//self
public class Solution {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
            return deleteDuplication(head);
        } else  {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }
}
