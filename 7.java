public class Solution {
	public int Fibonacci(int n){
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		int a = 1;
		int b = 1;
		int result = 0;
		for (int i = 3; i <= n; i++) {
			result = a + b;
			a = b;
			b = result;
		}
		return result;
	}
}
