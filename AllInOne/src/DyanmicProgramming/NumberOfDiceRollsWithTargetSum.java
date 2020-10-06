/**
 * 
 * 1155. Number of Dice Rolls With Target Sum
 * 
 * @CHYGO1985
 * @history Oct 6, 2020
 * 
 */
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        
        int mod = (int)Math.pow(10, 9) + 7;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;

        for (int dCnt = 1; dCnt <= d; dCnt ++) {
            for (int targetCnt = 1; targetCnt <= target; targetCnt ++) {
                for (int fCnt = 1; fCnt <= f; fCnt ++) {
                    if (targetCnt >= fCnt) {
                        dp[dCnt][targetCnt] = (dp[dCnt][targetCnt] + dp[dCnt - 1][targetCnt - fCnt]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }

        return dp[d][target];
    }
}