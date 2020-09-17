/**
 * 
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/share-my-thinking-process
 * 
 * @author jingjiejiang
 * @history Sep 17, 2020
 * 
 */
class Solution {
    public int maxProfit(int[] prices) {
        
        int sell = 0;
        int preSell = 0;
        int buy = Integer.MIN_VALUE;
        int preBuy = Integer.MIN_VALUE;

        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }

        return sell;
    }
}