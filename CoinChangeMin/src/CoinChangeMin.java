
public class CoinChangeMin {

	public static int coinChange(int[] coins, int amount) {
        // idea: greedy --> from max to min, need to check all possibility with different numbers
        // 1.dp (status array) --> bottom up: int[] count (length = amount + 1)
        // 1) for those < min coin, always - 1;
        // 2) core: count[curNum - i] = count[i] + 1;
        // e.g. coins[1,2,4] for 
        // 0 1 2 3 4
        // 0 1 1
        // 1) for 2,count[curNum - i] = count[2 - 1], means when part of 2 used coin 1 to present it, the remain 1, used 1
        // so total is 2; then [2 - 2] = 0 (num of 0 = 0), can just use coin 2 to repsent it, then 0 + 1 = 1, 1 replace 2.
        // 3 is the same...
        // 2. based on the dp solution proposed here for finding total ways of coin change: 
        // Algorithms: Solve 'Coin Change' Using Memoization and DP
        // result: 22 ms, beat 80%
        // things learned: 1) for *** one dimensional *** DP problem, must find out the core of accumulation procedure
        // 2) procedure can be top-down or bottom-up.
        // 3) for coin change: the procedure is bottom up, for each amount, 
        // ways of change amount = ways[amount] (without) + ways[amount - i];
        
        // edge case
        if (null == coins || 0 == coins.length) {
            return -1;
        }
        if (0 == amount) {
            return 0;
        }
        
        // *** sort the coins will make the solution a bit slower
        //Arrays.sort(coins);
        int[] count = new int[amount + 1];
        // when sum = 0, there is 0 coin used, so skip
        int sum = 1;
        
        while (sum <= amount) {
            // every time need to renew the value, as the loop is independent for each sum
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && count[sum - coin] != -1) {
                    int temp = count[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min) ? temp : min;
                }
            }
            count[sum] = min;
            sum ++;
        }
        
        return count[amount];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,4};
		int amount = 8;
		int res = coinChange(coins, amount);

	}

}
