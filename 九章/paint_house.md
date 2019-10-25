1. paint_house: 3 colors: 

```3``` colors: 
```
for (int k = 0; k < 3; ++k) {
					if (j != k) {
						f[i][j] = Math.min(f[i][j], f[i-1][k] + C[i-1][j]);
					}
				}
      ...
```

in each scenario, find min in each round;

2. paint house ii:

```k``` colors:

if in each most inner loop: enumerate K times: ```O(n*k^2)```: too slow;

instead: in fact, 对于```j```, ```j=0; j<K;```；

实际上```min(f[i][j])```这一组数中最小值总是某个值```min1```,对应的染色index在```[0,K]```中记为```id1```;
min总是这个```min1```, 除了一种情况: ```f[i][j]```选择的就是```id1```, 为了不撞色，此时min只能选在```[0,K]```
中的次小值```min2```, 对应的index是```id2```;

也就是说,min的选择，并不需要每次遍历K种: 这样重复计算了很多次;只需要遍历```i```的时候，不要直接遍历```j```, 而是先把整个中的
```min1, min2```求出来, 这样后面判断min的时候只需要看```f[i][j]```选的颜色是不是当前```id1```就行了
