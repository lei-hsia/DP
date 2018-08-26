# memoization
Memoization in Dynamic Programming: replace the inefficient recursion

(more a way of thinking than writing code)

Using recursion to solve problems is a normal practice; it also can be an inefficient in doing so. Take the classic problem of calculating the Fibonacci Sequence for instance, a recursive way can solve the problem, the time complexity is O(2^n). This is because the calculation of fib(n) can be divide into the calculations of fib(n-1) and fib(n-2), then fib(n-1) be devided into calculations of fib(n-2) & fib(n-3), fib(n-2) be divided into fib(n-3) & fib(n-4), etc. This structure is a tree and each time one divides into two so the tree has a depth of n so Big-O is O(2^n). It can be seen from this that fib(n-2) is calculated twice, fib(n-3) three times and so on. This is the root of inefficiency. If each value is calculated only once with it's valued stored at some place; then whenever it's needed, just take it's value from the place: use an array/list to store their values. 

Actually whenever the same value is calculated over and over again(often seen in recursion), it brings inefficiency. When this happens, use an array to store values generated each time. This is the essence of "Dynamic Programming": Creating an array to store the value generated each time along with other recursive processes, and extract those values when needed. The process is also called "Memoization"(not Memorization).

In this fashion, the calculations of n numbers in fib(n) only take time complexity of O(n): each time it's going to compute the same value again, see if it's in the array. Extract value from the array if it's there, otherwise this value is never computed before. 
