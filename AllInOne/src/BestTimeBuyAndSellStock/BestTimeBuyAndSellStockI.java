package BestTimeBuyAndSellStock;

/**
 * 
 * @author jingjiejiang created on Sep 2, 2018
 *
 */
public class BestTimeBuyAndSellStockI {
	
//	public static int maxProfit(int[] prices) {
//		
//		if (prices == null || prices.length <= 1) return 0;
//		
//        int[][] profit = new int[prices.length + 1][2];
//        profit[0][0] = 0;
//        profit[0][1] = Integer.MIN_VALUE;
//        
//        for (int i = 0; i < prices.length; i++) {
//			profit[i + 1][0] = Math.max(profit[i][0], profit[i][1] + prices[i]);
//			// here is the actuall control of just one transaction, just - prices[i]
//			profit[i + 1][1] = Math.max(profit[i][1], - prices[i]);
//		}
//        
//        return Math.max(profit[prices.length][0], profit[prices.length][1]);
//    }
	
	// optimise with less spaces
//	public static int maxProfit(int[] prices) {
//		
//		if (prices == null || prices.length <= 1) return 0;
//		
//        int[][] profit = new int[2][2];
//        profit[0][0] = 0;
//        profit[0][1] = Integer.MIN_VALUE;
//        
//        for (int i = 0; i < prices.length; i++) {
//			profit[(i + 1) % 2][0] = Math.max(profit[i % 2][0], profit[i % 2][1] + prices[i]);
//			// here is the actuall control of just one transaction, just - prices[i]
//			profit[(i + 1) % 2][1] = Math.max(profit[i % 2][1], - prices[i]);
//		}
//        
//        return profit[prices.length % 2][0];		
//	}
	
	public int maxProfit(int[] prices) {
        
		// 0: 0 stock in hand; 1: 1 stock in hand
        int[][] profits = new int[2][2];
        profits[0][0] = 0;
        profits[0][1] = Integer.MIN_VALUE;
        
        for (int idx = 0; idx < prices.length; idx ++) {
        	profits[(idx + 1) % 2][0] = Math.max(profits[idx % 2][0], profits[idx % 2][1] + prices[idx]);
        	profits[(idx + 1) % 2][1] = Math.max(profits[idx % 2][1], - prices[idx]);
        }
        
        return profits[prices.length % 2][0];
    }

	// variable: buy/sell on day X
	// con: only one trans
	// [i][0/1], k: num of trans, 0/1: stock num
	// res[i][0] = max(res[i-1][0], res[i - 1][1] + stock_price);
	// res[i][1] = max(res[i-1][1], res[i - 1][0] - stock_price);
	public static void main(String[] args) {
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

}
