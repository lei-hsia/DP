// 1. 这样分阶段实际上把问题变得非常清晰，也很麻烦; 但是at most k transactions的时候好处就出来了
// 2. max()函数自身迭代的时候，首先要f[i][j]自己赋值一个，因为Max函数有一位就是自己本身
// 3. 判断Integer.MIN_VALUE的时候，并不需要判断f[i][j]那个, 因为实际上仔细分析一下，这个肯定是有定义的, 并不会落到Integer.MIN_VALUE对应的那个里面

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int n = prices.length;
        if (n == 0) return 0;
        
        int[][] f = new int[n+1][5+1];
        int i, j;
        
        f[0][1] = 0;
        for (i = 2; i <= 5; ++i) {
            f[0][i] = Integer.MIN_VALUE;
        }
        
        // 注意这个i是到n. 因为f是前i个...  所以是可以最后等于n的
        for (i = 1; i <= n; ++i) {
            // state 1,3,5: f[i][j] = max(f[i-1][j], f[i-1][j-1] + prices[i-1] - prices[i-2])
            for (j = 1; j <= 5; j += 2) {
                f[i][j] = f[i-1][j];
                if (j > 1 && i >= 2 && f[i-1][j-1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + prices[i-1] - prices[i-2]);
                }
            }
            // state 2, 4: f[i][j] = max(f[i-1][j] + prices[i-1] - prices[i-2], f[i-1][j-1])
            for (j = 2; j <= 5; j += 2) {
                f[i][j] = f[i-1][j-1];
                if (i >= 2 && f[i-1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i-1][j] + prices[i-1] - prices[i-2]);
                }
            }
        }
        
        return Math.max(f[n][1], Math.max(f[n][3], f[n][5]));
    }
}
