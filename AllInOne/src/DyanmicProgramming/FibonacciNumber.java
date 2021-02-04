/**
 * 
 * 509. Fibonacci Number
 * 
 * @author jingjiejiang
 * @history Feb 4, 2021
 * 
 */
class Solution {
    public int fib(int N) {
        
        if(N <= 1)
            return N;

		int[] fib_cache = new int[N + 1];
        fib_cache[0] = 0;
		fib_cache[1] = 1;

		for(int i = 2; i <= N; i++)
		{
			fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
		}
		return fib_cache[N];
    }
}