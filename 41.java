public class Solution {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int s) {
		ArrayList<ArrayList<Integer>> allRes = new ArrayList<>();
		int high = 2, low = 1;
		while (high > low) {
			int sum = (high + low) * (high - low + 1) / 2;
			if (sum < s)
				high++;
			if (sum == s) { 
				ArrayList<Integer> res = new ArrayList<>();
				for (int i = low;  i<= high; i++)
					res.add(i);
					allRes.add(res);
					low++;
			}
			if (s < sum)
				low++;
		}
		return allRes;
	}
}
