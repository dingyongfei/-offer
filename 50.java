//对比54题，用的是哈希表
//boolean只占一位，所以比较省内存
public class Solution {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		boolean[] k = new boolean[length];
		for (int i = 0; i < k.length; i++) {
			if (k[numbers[i]] == true) {
				duplication[0] = numbers[i];
				return true;
			}
			k[numbers[i]] = true;
		}
		return false;
	}
}
