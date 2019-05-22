//也可以用数组结构来实现
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] c = str.toCharArray();
        int[] a = new int['z' + 1];   
        for (char d : c) {
            a[d]++;                       //此处有自动类型转换，即char->int
        }
        for (int i = 0; i < c.length; i++) {
            if (a[c[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
/*
public class Solution {
	public int FirstNotRepeatingChar(String str) {
		map<Character,Integer> mp;
		for (int i = 0; i < str.size(); ++i) 
			mp[str[i]]++;
		for (int i = 0; i < str.size(); ++i) {
			if (mp[str[i]] == 1)
				return i;
		}
		return -1;
	}
}
*/
