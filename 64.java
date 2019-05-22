import java.util.LinkedList;
----------------------------------------------------------------
！！关键点：队列中始终加入的是数组中每个元素的下标值（即" i " ！ ）,而在第一步中，做比较的是相应的下标所对应的数组元素值。
注：在每次for循环中的整个过程是：
1.	不断将队尾元素所对应的值（arr[qmax.peekLast()]）和arr[i]做比较。当队列不为空且为" < "关系时，就不断弹出队尾元素。
2.	否则（ > ），就把当前元素的下标值加入队列尾部。
3.	如果当前队首元素已经过期(即qmax.peekFirst() == i  -w),则直接弹出队首元素。
4.	如果当前数组元素的下标值长满了队列的大小（即i - w >= -1），则就正式开始用新建的数组记录当前队列的最大值（即队首弹出的元素）。
----------------------------------------------------------------
public class Solution {
	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length – w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) { //比arr[i]小
				qmax.pollLast();                //保证队列的第一个元素是
			}                                    //窗口的最大值
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w) {       //比arr[i]大
				qmax.pollFirst();             //比较arr[i]和窗口最大值的下标，即若
			}                                  //最大值已过期，则直接移出队列
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
}
