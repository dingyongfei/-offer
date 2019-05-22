public class Solution {
	public int MoreThanHalfNum_Solution(int[] numbers) {
		int n = numbers.length;
		if (n == 0) 
			return 0;
		int num = numbers[0], count = 1;    //将数组中第一个元素选作参数值做比较，并将计数器的值count初始化为1.
		for (int i = 1; i < n; i++) {
			if (num == numbers[i]) count++;
			else count--;
			if (count == 0) {
				num = numbers[i];
				count = 1;
			}
		}
		//Verifying
		count = 0;
		for (int i = 0; i < n; i++) {
			if (num == numbers[i]) count++;
		}
		if (count * 2 > n) return num;
		return 0;
	}
}
