/**
 * 
 * 123. Best Time to Buy and Sell Stock III
 * 
 * @author jingjiejiang
 * @history Sep 16, 2020
 * 
 */
class Solution {
  public int maxProfit(int[] prices) {

    int[][][] dp = new int[2][3][2];

    dp[0][0][0] = 0;
    dp[0][0][1] = dp[0][1][1] = dp[0][2][1] = - prices[0];

    for (int idx = 1; idx < prices.length; idx ++) {

      dp[idx % 2][1][0] = Math.max(dp[(idx - 1) % 2][1][0], dp[(idx - 1) % 2][1][1] + prices[idx]);
      dp[idx % 2][1][1] = Math.max(dp[(idx - 1) % 2][1][1], dp[(idx - 1) % 2][0][0] - prices[idx]);

      dp[idx % 2][2][0] = Math.max(dp[(idx - 1) % 2][2][0], dp[(idx - 1) % 2][2][1] + prices[idx]);
      dp[idx % 2][2][1] = Math.max(dp[(idx - 1) % 2][2][1], dp[(idx - 1) % 2][1][0] - prices[idx]);
    }

    return Math.max(0, Math.max(dp[(prices.length - 1) % 2][1][0], dp[(prices.length - 1) % 2][2][0]));
  }
}