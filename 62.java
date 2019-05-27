public class Solution {
	int index = 0;
	TreeNode KthNode(TreeNode root, int k) {
		if (root != null) {
			TreeNode node = KthNode(root.left,k);
			if (node != null) 
				return node;
			index++;
			if (index == k)
				return root;
			node = KthNode(root.right,k);
			if (node != null)               //需要做非空判断，为了避免node为空时将
				return node;             //另一个递归的非空的node值覆盖
		}
		return null;
	}
}

//方法二，简单版
public class Solution {
    TreeNode res = null;
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        KthNode(pRoot.left, k);
        count++;
        if (count == k) {
            res = pRoot;
        }
        KthNode(pRoot.right, k);
        return res;
    }
}
