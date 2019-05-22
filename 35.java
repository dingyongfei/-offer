public class Solution {
	public int InversePairs(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		int count = InversePairsCore(array, copy, 0, array.length - 1);
		return count;
	}
	private int InversePairsCore(int[] array, int[] copy,int low, int high) {
		if (low == high) {
			return 0;
		}
		int mid = (low + high) >> 1;
		int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
		int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
		int count = 0;
		int i = mid;     
		int j = high;                   //注：新建三个变量
		int locCopy = high;
		while (i >= low && j > mid) {
			if (array[i] > array[j]) {
				count += j - mid;
				copy[locCopy--] = array[i--];
				if (count >= 1000000007) {
					count %= 1000000007;
				}
			} else {
				copy[locCopy--] = array[j--];
			}
		}
		for (; i >= low; i--) {
			copy[locCopy--] = array[i];
		}
		for (; j > mid; j--) {
			copy[locCopy--] = array[j];
		}
		for (int s = low; s <= high; s++) {
			array[s] = copy[s];
		}
		return (leftCount + rightCount + count) % 1000000007;
	}
}
//方法二
public class Solution {
    public static int count;
    public static int MergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        MergeSort(arr, 0, arr.length - 1);
        return count;
    }

    public static void MergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = ((r - l) >> 1) + l;
        MergeSort(arr, l, mid);
        MergeSort(arr, mid + 1, r);
        Merge(arr, l, mid, r);
    }

    public static void Merge(int[] arr, int l, int mid, int r) {
        int p1 = l;  // 注意!!! p1的值为l，即p1从l开始
        int p2 = mid + 1;
        int i = 0;
        int[] help = new int[r – l + 1];
        while (p1 <= mid && p2 <= r) {           -----------和归并链表题相似。
            if (arr[p1] > arr[p2]) {
                count += mid -p1 + 1;
            }
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {    // 注意，< 1.相对应地，此处也是从l开始；2.这里是j不是j++ >
            arr[l + i] = help[i];
        }
    }
}
