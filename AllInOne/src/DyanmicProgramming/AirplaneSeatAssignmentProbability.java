/**
 * 
 * 1227. Airplane Seat Assignment Probability
 * 
 * @CHYGO1985
 * @history Nov 8, 2020
 * 
 * ref: https://leetcode.com/problems/airplane-seat-assignment-probability/discuss/542719/C%2B%2B-DP-and-math-solution-w-explanation-and-proof
 * 
 */
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        
        if (n == 1) return 1.0d;

        double[] dp = new double[n + 1];
        dp[1] = 1.0d;
        dp[2] = 1.0d / n; // when there are 2, the prob is 1/2 when i = 2, n = 2, get 1/2

        for (int i = 3; i <= n; i ++) {
            
            dp[i] = dp[i - 1] + dp[i - 1] / (n - i + 2);
        }

        return 1 - dp[n];
    }
}