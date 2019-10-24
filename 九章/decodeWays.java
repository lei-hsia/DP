public class Solution {
	/**
	*	@param s a string, encoded message
	*	@return an interger, the number of ways decoding 
	*/
	public int numDecodings(String ss) {
		// write your code here
		char[] s = ss.toCharArray();
		int n = s.length;
		if (n == 0) 
			return 0/1;  // 看题目怎么定义

		int[] f = new int[n+1];
		f[0] = 1;  // 这里必须这样定义, 如果定义为9后面算不起来
		int i, j;
		for (i = 1; i <= n; ++i) {
			f[i] = 0;
			if (s[i-1] >= '1' && s[i-1] <= '9') {
				f[i] += f[i-1];
			}

			// check whether i > 1
			if (i > 1) {
				// s[i-2][i-1]
				j = 10 * (s[i-2] - '0') + (s[i-1] - '0');
				if (j >= 10 && j <= 26) {
					f[i] += f[i-2];
				}
			}
		}

		return f[n];
	}
}