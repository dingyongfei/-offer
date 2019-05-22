public class Solution {
	public static String ReverseSentence(String str) {
		int len = str.length();
		if (len == 0)
			return "";
		int s = 0, e = 0;
		char[] chs = str.toCharArray();
		ReverseWord(chs, 0, str.length() - 1);
		while (e < str.length()) {
			while (e < str.length() && chs[e] == ' ') {
				e++;
			}
			s = e;
			while (e < str.length() && chs[e] != ' ') {
				e++;
			}
			ReverseWord(chs, s, e - 1);
		}
		return String.valueOf(chs);
	}
	
	public static void ReverseWord(char[] chs, int i, int j) {
		while (i < j) {
			char temp = chs[i];
			chs[i++] = chs[j];
			chs[j--] = temp;
		}
	}
}
