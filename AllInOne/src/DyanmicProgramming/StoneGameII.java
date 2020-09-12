/**
 * 1140. Stone Game II
 * ref: https://leetcode.com/problems/stone-game-ii/discuss/355710/Java-simple-DP-solution-with-explanation
 * 
 * @author jingjiejiang
 * @history Sep 12, 2020
 */
class Solution {
  public int stoneGameII(int[] piles) {

    final int n = piles.length;
    // initial sum array
    for (int i = n - 2; i >= 0; i--) piles[i] += piles[i+1];
    
    if (n <= 2) return piles[0];
    // (n+1)/2+1: assume size = 5 [2 7 9 4 4], then max m should be 4
    int[][] dp = new int[n][(n+1)/2+1];

    for (int i = n-1; i >= 0; i--) {

        int sum = piles[i];
        // coz the choice is 2m, not need to +1 here
        int m = (n-i+1)/2;
        dp[i][m] = sum;
        
        while (--m > 0) {
            dp[i][m] = 0;
            for (int x = 1; x <= m * 2 && i+x < n; x++) {
                int mx = Math.min((n-i-x+1)/2, Math.max(x, m));
                dp[i][m] = Math.max(dp[i][m], sum - dp[i+x][mx]);
            }
        }
    }

    return dp[0][1];
  }
}
