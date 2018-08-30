package BestTimeBuyAndSellStock;

// when to sell?
// 2  4  1  13  
// 2 - 13 pro: 9
// 2 - 4 + 1 - 13 pro: 10
// 2 2 1 13
// 2 - 13 pro: 9
// 2 4 1 2 pro: 0
// 4 1 1 1 pro: 0
public class BestTimeBuyAndSellStock {
	
	public static int maxProfit(int[] prices, int fee) {
        int res = 0, initPrice = prices[0], prePrice = prices[0];
        for (int index = 1; index < prices.length; index ++) {
        	
        }
        
        return res < 0 ? 0 : res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
