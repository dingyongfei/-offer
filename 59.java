//使用Stack，通过改变左右子节点的入栈顺序，以达到逆序的目的
public class Solution {
	public static ArrayList<ArrayList<Integer>> Print(TreeNode root) {
		int layer = 1;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		s1.push(root);
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		while (!s1.empty() || !s2.empty()) {
			if (layer % 2 != 0) {
				ArrayList<Integer> temp = new ArrayList<>();
				while (!s1.empty()) {
					root = s1.pop();
					temp.add(root.val);
					System.out.print(root.val + " ");
					if (root.left != null)
						s2.push(root.left); // 开辟两个新的栈空间，用栈
					if (root.right != null)
						s2.push(root.right); // 保存每一层节点的左右子节点
				}
				list.add(temp);
				layer++;
				System.out.println();
			} else { // 偶数层
				ArrayList<Integer> temp = new ArrayList<>();
				while (!s2.empty()) {
					root = s2.pop();
					temp.add(root.val);
					System.out.print(root.val + " ");
					if (root.right != null)
						s1.push(root.right);
					if (root.left != null)
						s1.push(root.left);
				}
				list.add(temp);
				layer++;
				System.out.println();
			}
		}
		return list;
	}
}

//方法二
//利用LinkedList的底层实现是双向链表的特点
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(null);            // 层分隔符         //先加入一个分隔符
		queue.addLast(root);            // 遇到分隔符就遍历，遇到非分隔符
		boolean leftToRight = true;     // 就加入左右子节点。
		while (queue.size() != 1) {
			TreeNode node = queue.removeFirst();
			if (node == null) {
				Iterator<TreeNode> it = null;
				if (leftToRight) {
					it = queue.iterator(); // 从前向后遍历
				} else {
					it = queue.descendingIterator(); // 从后向前遍历
				}
				leftToRight = !leftToRight;
				while (it.hasNext()) {
					TreeNode temp = (TreeNode) it.next();
					list.add(temp.val);
				}
				ret.add(new ArrayList<Integer>(list));
				list.clear();
				queue.addLast(null);
				continue;
			}
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}
		return ret;
	}
}
