public class Solution {
	public String PrintMinNumber(int[] numbers) {
		int len = numbers.length;
		String s = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			list.add(numbers[i]);
		}
//使用了模板方法模式，让子类可以重写方法的一部分，而不是整个重写，你可以控制子类需要重写哪些操作。
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer str1, Integer str2) {
				String s1 = str1 + "" + str2;
				String s2 = str2 + "" + str1;
				return s1.compareTo(s2);
			}
		});
		
		for (int j : list) {
			s += j;
		}
		return s;
	}
}
//方法二
public String PrintMinNumber(int[] numbers) {
	if(numbers == null || numbers.length == 0) 
		return "";
	int len = numbers.length;
	String[] str = new String[len];
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < len; i++) {
		str[i] = String.valueOf(numbers[i]); 
	}
	Arrays.sort(str, new Comparator<String>() {
		@Override
		public int compare(String s1,String s2) {
			String c1 = s1 + s2;
			String c2 = s2 + s1;
			return c1.compareTo(c2);
		}
	});
	for (int i = 0; i < len; i++) {
		sb.append(str[i]);
	}
	return sb.toString();
}
