/**
 * 
 * 121. Best Time to Buy and Sell Stock
 * 
 * @author jingjieijang 
 * @history Sep 14, 2020
 */
class Solution {

    // DP: without optimize
    // public int maxProfit(int[] prices) {
                    
    //     if (prices == null || prices.length == 0) return 0;
        
    //     // 0: sell, 1: buy
    //     int[][] profits = new int[prices.length][2];
    //     profits[0][0] = 0;
    //     profits[0][1] = - prices[0];
        
    //     for (int idx = 1; idx < profits.length; idx ++) {
            
    //         profits[idx][0] = Math.max(profits[idx - 1][0], profits[idx - 1][1] + prices[idx]);
    //         profits[idx][1] = Math.max(profits[idx - 1][1], - prices[idx]);
    //     }
        
    //     return profits[prices.length - 1][0];
    // }


    // optimize to 1 demensional array
    public int maxProfit(int[] prices) {
                    
        if (prices == null || prices.length == 0) return 0;
        
        // 0: sell, 1: buy
        int[] profits = new int[2];
        profits[0] = 0;
        profits[1] = - prices[0];
        
        for (int idx = 1; idx < prices.length; idx ++) {
            
            profits[0] = Math.max(profits[0], profits[1] + prices[idx]);
            profits[1] = Math.max(profits[1], - prices[idx]);
        }
        
        return profits[0];
    }
}