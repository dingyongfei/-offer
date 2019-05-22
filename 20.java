public class Solution {
	Stack<Integer> dataStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int node) {
		dataStack.push(node);
		if (minStack.isEmpty() || node < minStack.peek()) {
			minStack.push(node);
		} else {
			minStack.push(minStack.peek());
		}
	}
	
	public void pop() {
		dataStack.pop();
		minStack.pop();         //注意，要同步 pop() minStack中的元素。
	}
	public int top() {
		return dataStack.peek();
	}
	public int min() {
		return minStack.peek();
	}
}
