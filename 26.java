public class Solution {
	TreeNode head = null;
	TreeNode realHead = null;
//注:此题需要使用两个变量, 一个head用于逐个移动节点, 一个root用于跟踪当前节点
	public TreeNode Convert(TreeNode root) {
		ConvertSub(root);
		return realHead;
	}
	
	private void ConvertSub(TreeNode root) {
		if (root == null) return;             //root为空时，就return
		ConvertSub(root.left);
		if (head == null) {                   //判断head是否为空
			head = root;
			realHead = root;
		} else {
			head.right = root;
			root.left = head;
			head = root;
		}
		ConvertSub(root.right);
	}
}
