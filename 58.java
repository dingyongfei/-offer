//和17题相似
public class Solution {
	public boolean isSymmetrical(TreeNode root) {
		if (root == null) {
			return true;
		}
		return comRoot(root.left, root.right);
	}
	
	private boolean comRoot(TreeNode left, TreeNode right) {

		if (left == null || right == null) {            -----> 非常简便的写法！！！
            	return left == right;
        	}
		/* if (left == null)
			return right == null;
		   if (right == null)
			return false; */

		if (left.val != right.val)
			return false;
		return comRoot(left.right, right.left) && 
comRoot(left.left, right.right);
	}
}
