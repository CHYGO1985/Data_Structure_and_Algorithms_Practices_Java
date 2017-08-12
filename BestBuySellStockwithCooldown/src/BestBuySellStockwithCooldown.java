
public class BestBuySellStockwithCooldown {
	
	public static int maxProfit(int[] prices) {
        
        // partial best option --> reach the final best option
        // take first three as example:
        
        // 1 2 1 2
        // 0 3 4 5 3 2
        // 0 3 4 5 5 5
        // 0 0 0 0 0 0
        
        // 1 2 3 2 5
        // 0 1 2 2 4
        // 1 1 1 1 1
        
        // 1 2 3 0 2
        // 0 1 2 2 3
        
        // from matrix
        // dp[i] = price[i] - min stock; (if prices[i] > min.stock)
        // if (min stock pos == i - 1) then dp[i] += dp[i - 2]
        // else dp[i] += dp[min stock pos]
        // dp[i] = math.max(dp[i - 1], dp[i])
        
		if (null == prices || 0 == prices.length) return 0;
        
        int len = prices.length;
        
        int[] priceIdx = new int[len];
        int[] max = new int[len + 1];
        
        int minPriceIdx = 0; 
        priceIdx[0] = 0;
        max[0] = 0;
        max[1] = 0;
        
        for (int i = 1; i < len; i ++) {
            int maxIndex = i + 1;
            if (prices[i] < prices[minPriceIdx]) minPriceIdx = i;
            
            if (prices[i] - prices[i - 1] > 0) {
                max[maxIndex] = prices[i] - prices[i - 1];
                if (maxIndex >= 3) max[maxIndex] += max[maxIndex - 3];
            }
            else {
                max[maxIndex] = max[i];
            }
            
            if (minPriceIdx != i - 1) {
                int temp = prices[i] - prices[minPriceIdx];
                if (minPriceIdx >= 2) temp += max[minPriceIdx - 2 + 1];
                max[maxIndex]= Math.max(max[maxIndex], temp);
            }
                
        }
        
        return max[len];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = maxProfit(new int[]{2,1,2,1,0,1,2});
	}

}
