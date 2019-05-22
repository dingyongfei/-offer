public class Solution {
	public boolean Verify(int[] sequence) {
		if (sequence.length == 0) {
			return false;
		}
		if (sequence.length == 1) {
			return true;
		}
		return judge(sequence, 0, sequence.length - 1);
	}
	
	public boolean judge(int[] a, int start, int end) {
		if (start >= end) {                    // 注意，当右子树为空时
			return true;                         //（” > ”为空，” = ”为叶子节点）      -----和第4题十分相似。
		}
		int i = start;
		while (a[i] < a[end]) {
			++i;
		}
		for (int j = i; j < end; j++) {
			if (a[j] < a[end]) {
				return false;
			}
		}
		return judge(a, start, i - 1) && judge(a, i, end - 1);
	}
}
