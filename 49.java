public class Solution {
	public int StrToInt(String str) {
		char[] c = str.toCharArray();
		int n = str.length(), s = 1;
		int res = 0;
		if (n == 0)
			return 0;
		if (c[0] == '-')
			s = -1;
		for (int i = (c[0] == '-' || c[0] == '+') ? 1 : 0; i < n; i++) {
			if (c[i] < '0' || c[i] > '9')
				return 0;
			res = res * 10 + c[i] - '0';
		}
		str = c.toString();
		return res * s;
	}
}
