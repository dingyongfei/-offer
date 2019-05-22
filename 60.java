public class Solution {
	ArrayList<ArrayList<Integer>> Print(TreeNode root) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode last = root;
		TreeNode nLast = null;
		if (root == null) 
			return al;
		queue.offer(root);
		ArrayList<Integer> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			root = queue.poll();
			list.add(root.val);
			if (root.left != null) {
				queue.offer(root.left);
				nLast = root.left;
			}
			if (root.right != null) {
				queue.offer(root.right);
				nLast = root.right;
			}
			if (root == last) {
				al.add(list);
				last = nLast;
				list = new ArrayList<Integer>();
			}
		}
		return al;
	}
}
//方法二
//利用递归函数记录当前节点的层数

