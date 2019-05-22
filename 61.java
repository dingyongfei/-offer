public class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int val) {
		this.val = val;
	}
} 

public class Solution {

	public int index = -1;
	
	String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}

		sb.append(root.val + ",");
		
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
	
	TreeNode Deserialize(String str) {
		index++;
		String[] str1 = str.split(",");

		TreeNode node = null;
		if (!str1[index].equals("#")) {      //注意，此处是用equals()方法
			node = new TreeNode(Integer.valueOf(str1[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
}
