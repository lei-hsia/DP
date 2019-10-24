public class Solution  {
	/**
		@param consts n * 3 const matrix
		@return an integer, the min cost to paint all houses
	*/
	public int minCost(int[][] C) {
		int n = C.length();
		if (n == 0) 
			return 0;

		// sequence type dp
		int[][] f = new int[n+1][3];
		f[0][0] = f[0][1] = f[0][2] = 0;
		int i, j, k;
		for (int i = 1; i <= n; ++i) {
			// color of house i-1: j
			for (int j = 0; j < 3; ++j) {
				f[i][j] = Integer.MAX_VALUE;
				// color of house i-2: k
				for (int k = 0; k < 3; ++k) {
					if (j != k) {
						// f[i-1][k]: 前(i-1栋房子，最后一栋染成k这种颜色
						// C[i-1][j]: 第(i-1)栋房子, 这一栋染成j这种颜色
						f[i][j] = Math.min(f[i][j], f[i-1][k] + C[i-1][j]);
					}
				}
			}
		}

		return Math.min(f[n][0], Math.min(f[n][1], f[n][2]));

	}
}