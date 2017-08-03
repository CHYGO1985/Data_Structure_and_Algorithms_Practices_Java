/**
 * 
 * 650. 2 Keys Keyboard
 *
 * round 1: solved, 40 minutes, O(n^2) solution, beat 64.15%
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 3, 2017
 */
public class TwoKeysKeyboard {
	public int minSteps(int n) {
        
        if (n <= 0) return 0;
        
        // n % 2 == 0, dp[i] = dp[i/2] + 2
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        
        for (int j = 2; j <= n; j ++) {
            dp[j] = Integer.MAX_VALUE;
            if ((j & 1) == 0) 
                dp[j] = dp[j / 2] + 2;
            else {
                int m = 2;
                int limit = (int)Math.sqrt(j);
                while (m <= limit) {
                    if (j % m == 0) {
                        dp[j] = Math.min(dp[j], dp[j / m] + 2 + m - 2);
                    }
                    m ++;
                }
                dp[j] = Math.min(dp[j], 2 + j - 2); // j is a prime number
            }
        }
        
        return dp[n];
    }
}
