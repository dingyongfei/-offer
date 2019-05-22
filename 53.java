public class Solution {
	public boolean isNumeric(String str) {
		char[] c = str.toCharArray();
		int len = str.length();
		// 标记符号、小数点、e是否出现过
		boolean sign = false, decimal = false, hasE = false;
		for (int i = 0; i < len; i++) {
			if (c[i] == 'e' || c[i] == 'E') {
				if (i == len - 1)
					return false; // e后面一定要接数字
				if (hasE)
					return false; // 不能同时存在两个e
				hasE = true;
			} else if (c[i] == '+' || c[i] == '-') {
				// 第二次出现+-符号，则必须紧接在e之后
				if (sign && c[i - 1] != 'e' && c[i - 1] != 'E')
					return false;
				// 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
				if (!sign && i > 0 && c[i - 1] != 'e' && c[i - 1] != 'E')
					return false;
				sign = true;
			} else if (c[i] == '.') {
				// e后面不能接小数点，小数点不能出现两次
				if (hasE || decimal)
					return false;
				decimal = true;
			} else if (c[i] < '0' || c[i] > '9') // 不合法字符
				return false;
		}
		str = c.toString();
		return true;
	}
}
