public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }
    
    private TreeNode reConstructBinaryTree(int[] pre, int sPre, int ePre, int[] in, int sIn, int eIn) {
        if (sPre > ePre || sIn > eIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[sPre]);
        for (int i = sIn; i <= eIn; i++) {
            if (in[i] == pre[sPre]) {
               root.left = reConstructBinaryTree(pre, sPre + 1, sPre + i -sIn, in, sIn, i - 1);
               root.right = reConstructBinaryTree(pre, i – sIn + sPre + 1, ePre, in, i + 1, eIn);
               break;
            }
        }
        return root;
    }
}
