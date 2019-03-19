package Array;

/**
 * 
 * @author jingjiejiang Mar 19, 2019
 *
 */
public class FibonacciNumber {
	public int fib(int N) {
        
        if (N <= 1) return N;
        
        int[] res = new int[N + 1];
        res[0] = 0;
        res[1] = 1;
        
        for (int idx = 2; idx < res.length; idx ++) {
            res[idx] = res[idx - 1] + res[idx - 2];
        }
        
        return res[N];
    }
}
