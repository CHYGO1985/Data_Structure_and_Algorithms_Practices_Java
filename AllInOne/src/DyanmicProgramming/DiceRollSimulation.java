/**
 * 
 * 1223. Dice Roll Simulation
 * 
 * @CHYGO1985
 * @history Nov 30, 2020
 *
 * ref: https://leetcode.com/problems/dice-roll-simulation/discuss/403756/Java-Share-my-DP-solution
 * 
 */
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        long divisor = (long) Math.pow(10, 9) + 7;
        // n is the num of rolls, and 7 is 6 nums(idx:0 -5) + sum(idx:6)
        long[][] dp = new long[n][7];

        for (int idx = 0; idx < 6; idx ++) {
          dp[0][idx] = 1;
        }

        dp[0][6] = 6;

        for (int row = 1; row < n; row ++) {
          long sum = 0;
          // iterate through each dice num to get the sum for current roll
          for (int col = 0; col < 6; col ++) {
            // probability: the current roll = previous num of possible rolls 
            // e.g. 2 rolls, for X1, there are 6 posibilities
            dp[row][col] = dp[row - 1][6];
            int invalidDigits = row - rollMax[col];

            if (invalidDigits == 0) {
                dp[row][col] = (dp[row][col] - 1) % divisor;
            } else if (invalidDigits > 0) {
                // we add another round of divisor as we need to cal sum after this
                dp[row][col] = (dp[row][col] - (dp[invalidDigits - 1][6] - dp[invalidDigits - 1][col])) % divisor + divisor; 
            } 

            sum = (sum + dp[row][col]) % divisor;
          }

          dp[row][6] = sum;
        }

        return (int)dp[n - 1][6];
    }
}