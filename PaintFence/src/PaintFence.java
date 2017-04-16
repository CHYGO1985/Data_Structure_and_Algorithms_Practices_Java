
public class PaintFence {
	
	public int numWays(int n, int k) {
        // round 1: DP, two hours. too long for a solution 
        
        // idea: draw on paper to fomd regulation
        // count as 1/k part, so final result * k 
        // minus:   0  1  (k-1)
        // index:   1  2    3             
        // res  :   1  k  res*k-minus(use previous minus)  (update minus and res each time) 
        if (n == 0 || k == 0)
            return 0;
        
        int[] status = new int[n + 1];
        status[0] = 0;
        status[1] = 1;
        
        int fact = 1;
        int minus = 0;
        
        for (int i = 2; i <= n; i ++) {
            status[i] = fact * k - minus;
            fact = status[i];
            minus = status[i - 1] - minus;
        }
        
        return status[n] * k;
    }
}
