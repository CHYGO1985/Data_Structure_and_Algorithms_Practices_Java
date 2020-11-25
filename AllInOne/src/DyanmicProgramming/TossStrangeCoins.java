/**
 * 
 * 1230. Toss Strange Coins
 * 
 * @CHYGO1985
 * @history Nov 25, 2020
 * 
 * ref: https://leetcode.com/problems/toss-strange-coins/discuss/408485/JavaC%2B%2BPython-DP
 * state transfer: dp[c][k] = dp[c - 1][k]*(1-p) + dp[c-1][k-1]*p
 * the prob of heads face up at pos c:
 */
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        
        double[] dp = new double[target + 1];
        dp[0] = 1.0d;

        for (int idx = 0; idx < prob.length; idx ++) {
            for (int headsCount = Math.min(idx + 1, target); headsCount >= 0; headsCount --) {
                dp[headsCount] = dp[headsCount] * (1 - prob[idx]) +
                    (headsCount > 0 ? dp[headsCount - 1] * prob[idx] : 0);
            }
        }
        
        return dp[target];
    }
}