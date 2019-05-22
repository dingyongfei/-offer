public class Solution {
	public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
		ListNode n1 = head1;           //注：新建两个节点
		ListNode n2 = head2;
		while (n1 != n2) {              //这个条件，还是这个条件啊！！！
			n1 = (n1 == null ? head2 : n1.next);
			n2 = (n2 == null ? head1 : n2.next);
		}
		return n1;
	}
}
