public class Solution {
	public boolean isContinuous(int[] nums) {
		if (nums.length != 5) 
			return false;
		int min = 14;
		int max = -1;
		int flag = 0;                                //注意，flag的初始值设为0！
		for(int i = 0; i< nums.length; i++) {
			int num = nums[i];
			if (num < 0 || num > 13)
				return false;
			if (num == 0)
				continue;   //注意，另一种写法中，如用max-min方法检查时，要跳过0；此方法中，此处也要跳过0
			if (((flag >> num) & 1) == 1) 
				return false;
			flag |= (1 << num);
			if (num > max)
				max = num;
			if (num < min) 
				min = num;
			if (max – min >= 5)
				return false;
		}
		return true;
	}
}
//方法二
import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        int length = numbers.length;
        if (length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < length - 1; i++) {    
            if (numbers[i] != 0 && numbers[i] == numbers[i + 1]) {    //注意，跳过0
                return false;
            }
        }
        
        int i = 0;
        while (numbers[i] == 0) {               //注意，跳过0
            i++;
        }
        if (numbers[length-1] - numbers[i] >= 5) {
            return false;
        }
        return true;
    }
}

