// 写法一
public class Solution {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] visited = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (exist(matrix, rows, cols, i, j, str, 0, visited))
					return true;
			}
		}
		return false;
	}

	private boolean exist(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] visited) {
		if (k == str.length)
			return true;
		int index = i * cols + j;
		if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1 || matrix[index] != str[k] || visited[index])
			return false;
		visited[index] = true;
		if (exist(matrix, rows, cols, i - 1, j, str, k + 1, visited) || 
			exist(matrix, rows, cols, i + 1, j, str, k + 1, visited) || 
			exist(matrix, rows, cols, i, j - 1, str, k + 1, visited) || 
			exist(matrix, rows, cols, i, j + 1, str, k + 1, visited)) {
			return true;
		}
		visited[index] = false;
		return false;
	}
}

// 写法二
public class Solution {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (exist(matrix, rows, cols, i, j, str, 0))
					return true;
			}
		}
		return false;
	}

	private boolean exist(char[] matrix, int rows, int cols, int i, int j, char[] str, int k) {
        if (k == str.length)
			return true;
		int index = i * cols + j;
		if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1 || matrix[index] != str[k])
			return false;
		matrix[index] = '*';
		if (exist(matrix, rows, cols, i - 1, j, str, k + 1) || 
			exist(matrix, rows, cols, i + 1, j, str, k + 1) || 
			exist(matrix, rows, cols, i, j - 1, str, k + 1) || 
			exist(matrix, rows, cols, i, j + 1, str, k + 1)) {
			return true;
		}
		matrix[index] = str[k];
		return false;
	}
}
