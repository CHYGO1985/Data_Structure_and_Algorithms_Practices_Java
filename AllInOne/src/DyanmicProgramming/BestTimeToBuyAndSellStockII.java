class Solution {

    // method 1: DP
    // public int maxProfit(int[] prices) {
                    
    //     if (prices == null || prices.length == 0) return 0;
        
    //     // 0: sell, 1: buy
    //     int[][] profits = new int[prices.length][2];
    //     profits[0][0] = 0;
    //     profits[0][1] = - prices[0];
    //     boolean ableToBuy = false;
        
    //     for (int idx = 1; idx < profits.length; idx ++) {
            
    //         int potentialProfits = profits[idx - 1][0] + (profits[idx - 1][1] + prices[idx]);
    //         if (potentialProfits > profits[idx - 1][0]) ableToBuy = true;
    //         profits[idx][0] = Math.max(profits[idx - 1][0], potentialProfits);
    //         profits[idx][1] = ableToBuy? - prices[idx] : Math.max(profits[idx - 1][1], - prices[idx]);
    //     }
        
    //     return profits[prices.length - 1][0];
    // }

    // DP: optimize to 1 dimentional array
    // public int maxProfit(int[] prices) {
                    
    //     if (prices == null || prices.length == 0) return 0;
        
    //     // 0: sell, 1: buy
    //     int[] profits = new int[2];
    //     profits[0] = 0;
    //     profits[1] = - prices[0];
    //     boolean ableToBuy = false;
        
    //     for (int idx = 1; idx < prices.length; idx ++) {
            
    //         int potentialProfits = profits[0] + (profits[1] + prices[idx]);
    //         if (potentialProfits > profits[0]) ableToBuy = true;
    //         profits[0] = Math.max(profits[0], potentialProfits);
    //         profits[1] = ableToBuy? - prices[idx] : Math.max(profits[1], - prices[idx]);
    //     }
        
    //     return profits[0];
    // }

    // ultimate optimized version
    public int maxProfit(int[] prices) {
                    
        if (prices == null || prices.length == 0) return 0;
        
        // 0: sell, 1: buy
        int[] profits = new int[2];
		profits[0] = 0;
		profits[1] = - prices[0];
        int preSellProfits = 0;
		
		for (int idx = 1; idx < prices.length; idx ++) {
            preSellProfits = profits[0];
			profits[0] = Math.max(profits[0],
					profits[1] + prices[idx]);
			profits[1] = Math.max(profits[1],
					preSellProfits - prices[idx]);
		}
		
		return profits[0];
    }
}