/**
 * 
 * 790. Domino and Tromino Tiling
 * 
 * @author jingjiejiang
 * @history Jan 11, 2021
 * 
 */
class Solution {
    public int numTilings(int N) {
        
        int mod = (int)1e9 + 7;
        // notice to use long here, then transfer to int at the end, otherwise the result will be false when N = 30
        long[][] dp = new long[N + 1][2];
        dp[0][0] = dp[1][0] = 1;
        
        for (int idx = 2; idx <= N; idx ++) {
            
            dp[idx][0] = (dp[idx - 1][0] + dp[idx - 2][0] + 2 * dp[idx - 1][1]) % mod;
            dp[idx][1] = (dp[idx - 2][0] + dp[idx - 1][1]) % mod;
        }
        
        return (int)dp[N][0];
    }
}
