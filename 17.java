---------------------------------------------------------------------
（1）	普通解法：（时间复杂度O(m * n)）二叉树遍历 + 匹配
（2）	最优解法：（时间复杂度O(m + n)）二叉树序列化 + KMP算法
---------------------------------------------------------------------
public class Solution {
	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;      
//设置一个boolean型变量，用于判断是否需要继续寻找。
		if (root2 != null && root1 != null) {
			if (root1.val == root2.val) {
				result = doesTree1HaveTree2(root1, root2);
			}
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}
	
	public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
		if (node2 == null) {
			return true;
		}
		if (node1 == null) {
			return false;
		}
		if (node1.val != node2.val) {
			return false;
		}
		return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
	}
}
