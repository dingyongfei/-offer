public class Solution {
	public boolean isPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0) 
			return false;
		Stack<Integer> s = new Stack<Integer>();
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);    //-----注意，这一行要放在for循环中的前面！！
			while (!s.empty() && s.peek() == popA[popIndex]) {
                   //类似于单调栈的写法！！（ >= ）
				s.pop();
				popIndex++;
			}
		}
		return s.empty();
	}
}
