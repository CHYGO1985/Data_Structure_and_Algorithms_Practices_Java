/**
 * 
 * 651. 4 Keys Keyboard
 * 
 * @CHYGO1985
 * @history Sep 19, 2020
 * 
 */
class Solution {
    public int maxA(int N) {
        
        if (N == 0) return 0;
        
        int[] dp = new int[N + 1];
        dp[0] = 0;
        
        for (int idx = 1; idx <= N; idx ++) {
            
            // if the current pos is a pressed
            dp[idx] = dp[idx - 1] + 1;
            
            for (int printPos = 2; printPos <= idx; printPos ++) {
                
                dp[idx] = Math.max(dp[idx], dp[printPos - 2] * (idx - printPos + 1));
            }
        }
        
        return dp[N];
    }
}