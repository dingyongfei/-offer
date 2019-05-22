public class Solution {
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public ArrayList<Integer> printFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			this.printListFromTailToHead(listNode.next);
			arrayList.add(listNode.val);
		}
		return arrayList;
	}
}
