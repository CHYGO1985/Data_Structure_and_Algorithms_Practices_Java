/**
 * 
 * 650. 2 Keys Keyboard
 *
 * round 1: solved, 40 minutes, O(n^2) solution, beat 64.15%
 * *** first time I did not think about odd and non-prime numer, e.g. 9, 15
 * DP: 1) if n is even: dp[j / 2] + 2; (copy the closet dp[x])
 * the theory is: take 8 as example,as 4 is from 2, if only copy 2 to reach 8, 
 * then the another 4 will cost more than 2 for sure, but if copy 4 if will cost
 * another 2, so just use dp[j / 2]
 * 
 * 2) odd: from big to small check j % m == 0, then dp[j] = dp[m] + 2 + (m - 2)
 * --> dp[j] = dp[m] + m
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
                    	// the first 2 means 2 steps copy all and paste
                    	// the second 2 means 2 m, the dp[j/m] produces the first m, 
                    	// then 2 produce the second m
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
