public class Solution {
	public int GetNumberOfK(int[] array, int k) {
		int length = array.length;
		if (length == 0) 
			return 0;
		int firstK = getFirstK(array, k, 0, length - 1);
		int lastK = getLastK(array, k, 0, length - 1);
		if (firstK != -1 && lastK != -1){
			return lastK - firstK + 1;
		}
		return 0;
	}
	//迭代
	private int getFirstK(int[] array, int k,int start, int end) {
		if(start > end) 
			return -1;
		int mid = ((end - start) >> 1) + start; ---注意，不能写成” int mid = (end - start) >> 1 + start; ”  因为+、-的优先级比<<、>>高
		if (array[mid] > k) {
			return getFirstK(array, k, start, mid - 1);
		} else if (array[mid] < k) {
			return getFirstK(array, k, mid + 1, end);
		} else if (mid - 1 >= 0 && array[mid - 1] == k) {
			return getFirstK(array, k, start, mid - 1);
		} else {
			return mid;      //注意，该题是return mid，和前面的return arr[low]不一样
		}
	}
	//循环
	private int getLastK(int[] array, int k, int start, int end) {
		int length = array.length;
		int mid = (start + end) >>1;
		while (start <= end) {
			if (array[mid] > k) {
				end = mid - 1;
			} else if (array[mid] < k) {
				start = mid +1;
			} else if (mid + 1 < length && array[mid+1] == k) {
				start = mid + 1; 
			} else {
				return mid;
			}
			mid = (start + end) >> 1;
		}
		return -1;
	}
}
//方法二
public class Solution {
	public int getNumberOfK(int[] data, int k) {
		return biSearch(data, k + 0.5) - biSearch(data, k - 0.5);
	}
	
	private int biSearch(int[] data, double num) {         //注意，num是double类型的变量
		int s = 0, e = data.length - 1;
		while (s <= e) {
			int mid = (e - s)  /2 + s;
			if (data[mid] < num)
				s = mid + 1;
			else if (data[mid] > num) 
				e = mid - 1;
		}
		return s;
	}
}
