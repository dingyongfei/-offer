public class Solution {
	public String LeftRotateString(String str, int n) {
		int len = str.length();
		if (len == 0)
			return "";
		n = n % len;
		str += str;
		return str.substring(n, n + len);   // 截子串，从no.3开始，截到no.9前面的一个，也即“[,)”区间
	}
}
