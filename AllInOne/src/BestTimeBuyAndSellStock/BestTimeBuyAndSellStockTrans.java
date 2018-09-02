package BestTimeBuyAndSellStock;

// DP solution
public class BestTimeBuyAndSellStockTrans {
	
	// every day, can buy or sell or do nothing
	// for buy/sell status digit: 0 -> buy, 1 -> sell
	public static int maxProfit(int[] prices, int fee) {

		if (prices == null || prices.length <= 1) return 0;
		
		int[][] res = new int[2][2];
		res[0][0] = res[0][1] = 0;
		res[1][0] = - prices[0];
		res[1][1] = 0;
		
		for (int index = 2; index <= prices.length; index ++) {
			int tmpIndex = index % 2;
			// res[tmpIndex - 1][0] means hold a stock, hold yesterday's buying res[i - 1][0]
			// or buy, means yesterday sells res[i - 1][1]
			res[tmpIndex][0] = Math.max(res[(index - 1) % 2][0], res[(index - 1) % 2][1] - prices[index - 1]);
			// res[tmpIndex - 1][1] means SKIP, coz we sell yesterday
			// or sell, means yesterday buys res[i - 1][0]
			res[tmpIndex][1] = Math.max(res[(index - 1) % 2][1], res[(index - 1) % 2][0] + prices[index - 1] - fee);
		}
		
		return res[prices.length % 2][1];
    }

	public static void main(String[] args) {
		int[] prices = new int[]{1, 3, 2, 8, 4, 9};
//		int[] prices = new int[]{1, 5, 9};
		System.out.println(maxProfit(prices, 2));
	}
}
