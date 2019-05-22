public int Sum_Solution(int n) {
	int sum = n;
	boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);   //严格的n>0条件，而不能是n>=0,否则递归的最后一层返回一个-1;
	return sum;
}
