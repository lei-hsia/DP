空间优化: 

对于网格的dp，如果```f[i][j]```只依赖本行的```f[i][x]```和上一行的```f[i-1][y]```, 那么可以采用滚动数组压缩空间. 空间复杂度为```O(n)```而不是```O(m*n)```

1. Minimum Path Sum: 如果要打印path, 关键: 记录每一次是从left还是up的方向来的; 最后的path是从```A[m-1][n-1]```倒着得到的; 然后再reverse打印出来;
2. Longest Increasing Subsequence; ```dp[i][j]```记录到```grid[i][j]```的位置的LIS长度;
3. Bomb Enemy: 四个方向; e.g. 从上面来的方向: ```if(i>0) up[i][j] = up[i-1][j]+1```;
4. [Longest Increasing Subsequence奇淫技巧](https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation)
---

异或: 不进位的加法: 1^1 = 0;

4. Counting Bits: 

  1. brute-force:这个数不断mod2, floor(i/2); 直到最后为0: ``O(NlogN)```;
  2. dp; 每个二进制数看最后一位是0/1, 再看去掉最后一位之后剩下的二进制有多少个1;
  3. ```>>```:右移相当于除2往下找floor();
  4. ```<<```:左移相当于乘2;
  5. 另外, ```i%2```是很慢的, ```i & 1```有相同的作用, 但是位操作比mod快很多;
---
### 坐标型&&序列型dp区别: 
1. 坐标型dp: ```f[i]```表示以ai为结尾的某种性质
2. 序列型dp: ```f[i]```下标```i```表示**前**i个元素```a[0], ...a[i-1]```的某种性质
3. 序列型dp这样，是因为初始化的时候```f[0]```表示前0个，所以就是**空序列**,这样的话初始化条件很简单

**最长序列型dp**: 本质上是坐标型dp

--- 
### 序列+状态型dp: 
1. when: 当思考dp到最后一步时，这一步依赖前一步的某种状态
2. 初始化时，```f[0]```代表前0个元素/前0天的状态--与坐标型dp区别
3. 计算时, ```f[i]```代表前```i``` 个元素, i.e. 元素```0- (i-1)```的某种性质 

---
### 划分型dp:
1. subset;
2. game theory;
3. backpack;

常见: 给定长度为K的序列或string，要求划分成若干段;
- 段数不限，或者指定K段; 段数不限的时候就不用记录段数， 指定K段需要开一维记录段数;
- 每一段满足一定的性质;

approach:
- 类似序列型dp, 但是通常要加上段数信息; e.g. best time to buy sell stocks;
- 一般用```f[i][j]```记录前i个元素(元素```0 ~ i-1```分成j段的性质, e.g. minCost;





