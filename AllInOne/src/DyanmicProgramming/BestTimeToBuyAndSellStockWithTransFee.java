/**
 * 
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 
 * @author jingjiejiang
 * @history Sep 18, 2020
 * 
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        if (prices == null || prices.length == 0) return 0;

        // 0: sell ; 1: buy
        int[] profits = new int[2];
        profits[0] = 0;
        profits[1] = -prices[0];

        for (int idx = 1; idx < prices.length; idx ++) {

            int preSell = profits[0];
            profits[0] = Math.max(profits[0], profits[1] + prices[idx] - fee);
            profits[1] = Math.max(profits[1], preSell - prices[idx]);
        }

        return profits[0];
    }
}