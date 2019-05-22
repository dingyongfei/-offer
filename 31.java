public class Solution {
	public int NumberOf1Between1AndN_Solution(int n) {
		int counter = 0;
		for(int i = 0; i <= n; i++) {
			int val = i;
			while (val >= 1) {                           //暴力过。。。。。
				if (val % 10 == 1) {
					counter++;
				}
				val /= 10;
			}
		}
		return counter;
	}
}
