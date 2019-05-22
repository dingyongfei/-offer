//根据该结点的右子树有无情况进行判定。
public class Solution {

	public static class Node {
		public int value;
		public Node left; 
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getNextNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			return getLeftMost(node.right);
		} else {
			Node parent = node.parent;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;                //包含node为整棵树中序遍历下的
		}                                  //最后一个节点的结果，即parent为null
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
