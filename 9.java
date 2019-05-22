public class Solution {
	public int JumpFloor2(int target) {
		if (target <= 0) {
			return -1;
		}
		else if (target == 1) {
			return 1;
		}
		else {
			return 2 * JumpFloor2(target - 1);
		}
	}
}
