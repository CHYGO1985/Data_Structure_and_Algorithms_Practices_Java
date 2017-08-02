/**
 * 
 * 651. 4 Keys Keyboard
 * 
 * Round 1: unsolved, did not think about copy of copy.
 * ref: https://discuss.leetcode.com/topic/97631/two-java-dp-solution-o-n-2-and-o-n
 * 
 * @author jingjiejiang
 * @history
 * 1. Aug 2, 2017
 */
public class FourKeysKeyboard {
	
	public int maxA(int N) {
        
        if (N < 1) return -1;
        if (N <= 3) return N;
        
        int[] dp = new int[N + 1];
        
        for (int i = 1; i <= N; i ++) {
            dp[i] = i;
         // the 2nd loop is for copy of copy of copy ...
            for (int j = 3; j <= i; j ++) {
            	// *** j - 1 is from (j - 2 + 1)
            	// -2 means the ops for crt-a AND crt-c
            	// +1 means the i - j is one of the num that will be copied
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        
        return dp[N];   
    }

}
