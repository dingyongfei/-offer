//一个一步，一个两步，相遇时，其中一个置为起点。再都一步，相遇点即为所求点。
（时间复杂度O(n)）
//另一种思路：遍历链表，将链表的每一个节点加入到Set里去，如果在Set中发现重复节点，证明链表有环，否则无环。    


public class Solution {
	public ListNode EntryNodeOfLoop(ListNode node) {
		ListNode fast = node;
		ListNode slow = node;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)    //注意，不能写成” fast.val == slow.val ” !!!
				break;
		}
		if (fast == null || fast.next == null) {  
			return null;
}
		fast = node;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}


//方法二
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
