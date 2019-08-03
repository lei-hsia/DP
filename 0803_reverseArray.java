// reverse一个数组A 

int i, j, t, n = A.length;
i = 0;
j = n-1;
while (i < j) {
	// 每次交换最前面第n个和从后往前数第n个
	t = A[i];
	A[i] = A[j];
	A[j] = t;
	++i;
	--j;
}