public class Solution {
	public int LastRemaining(int n , int m) {
		if (m == 0 || n == 0) {
			return -1;
		}
		LinkedList<Integer> data = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			data.add(i);
		}
		int index = -1;              //初始值
		while (data.size() > 1) {
			index = (index + m) % data.size();  //注意，结果对list的长度取模
			data.remove(index);
			index--;    //每次从删掉的节点下一个开始取，所以要减1  
//牢记这句，每次循环序号一定要缩进1！！！！
		}
		return data.get(0);    //remove(0);
	}
}
//方法二
//用数组模拟环
public class Solution {
	public static int findLastNumber(int n, int m) {
		if (n < 1 || m < 1) 
			return -1;
		int[] array = new int[n];
		int i = -1, step = 0, count = n;
		while (count > 0) {   //跳出循环时最后一个元素也设置为了-1
			i++;
			if (i >= n)
				i = 0;   //模拟环
			if (array[i] == -1) 
				continue;
				step++;
			if (step == m) {
				array[i] = -1;
				step = 0;
				count--;
			}
		}
		return i;
	}
}
