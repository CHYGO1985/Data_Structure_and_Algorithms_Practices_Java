/**
 *
 * 1140. Stone Game II
 * ref: https://leetcode.com/problems/stone-game-ii/discuss/355710/Java-simple-DP-solution-with-explanation
 * 
 * @author jingjiejiang
 * @history Sep 12, 2020
 *
 */
class Solution {
  public int stoneGameII(int[] piles) {

    final int n = piles.length;
    // initial sum array
    for (int idx = n - 2; idx >= 0; idx --) piles[idx] += piles[idx + 1];
    
    if (n <= 2) return piles[0];
    // (n+1)/2+1: assume size = 5 [2 7 9 4 4], then max m should be 4
    int[][] dp = new int[n][(n + 1)/2 + 1];

    for (int idx = n - 1; idx >= 0; idx --) {

        int sum = piles[idx];
        // coz the choice is 2m, not need to +1 here 
        // (n - i + 1) is the current length of avail piles
        int m = (n - idx + 1)/2;
        // Let DP[i][m] be the maximal number of stones a player can get when the 0, 1, ..., i-1 piles have already been taken and the current M is m
        dp[idx][m] = sum;
        
        // as dp[i][m]'s value is known, so we check (m-1 ~ 0)
        while (--m > 0) {
            dp[idx][m] = 0;
            for (int x = 1; x <= m * 2 && idx + x < n; x++) {
                // Math.min is an important step
                // n - (i + x) + 1:  the right part between x and n - 1. the max value can get for next M
                // mx is the next M from x to n - 1. dp[i+x][mx] is the other player can get
                int nextM = Math.min((n- (idx + x) + 1)/2, Math.max(x, m));
                // here we need to compare is that for example  1 3 4 15, if the first player take 1 3, then it will lost
                // if it take 1, then it will finally get 15, it will win
                dp[idx][m] = Math.max(dp[idx][m], sum - dp[idx + x][nextM]);
            }
        }
    }

    return dp[0][1];
  }
}
