//堆的结构非常重要，几乎一切贪心的结构都是用堆结构来做的。 堆排序本身就很重要，堆更重要。

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	int count;
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});
	
	public void Insert(Integer num) {
		count++;
		if ((count & 1) == 0) {     //当数据总数为偶数时，新加入的元素应当先加入大根堆，经大根堆筛选出堆中最大的元素后，再将此元素加入小根堆中
			if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
		} else {              //当数据总数为奇数时，新加入的元素应当先加入小根堆，经小根堆筛选出堆中最小的元素后，再将此元素加入大根堆中
			if (!minHeap.isEmpty() && num > minHeap.peek()) {
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);       //第一个元素进入大根堆
		}
	}
	
	public Double GetMedian() {      // !!必须写成Double类型

		if (count == 0)
			throw new RuntimeException("no available number!");
		double result;
         // !!注意，该位运算必须写成(count & 1) == 1，否则会产生类型错误。
		if ((count & 1) == 1)      //当总数为奇数时，大根堆堆顶就是中位数
			result = maxHeap.peek();
		else
			result = (minHeap.peek() + maxHeap.peek()) / 2.0;
		return result;
	}
}
