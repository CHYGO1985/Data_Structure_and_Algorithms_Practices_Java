import java.util.HashMap;

// code ref: https://www.youtube.com/watch?v=sn0DWI-JdNA#t=212.147608
public class CoinChange {
	
	public static long makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Long>());
	}
	
	/**
	 * 
	 * @param coins kinds of coins [1,2,4]
	 * @param money total money amount for change
	 * @param index
	 * @param memo
	 * @return
	 */
	public static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
		
		if (money == 0) {
			return 1;
		}
		
		if (index >= coins.length) {
			return 0;
		}
		
		String key = money + "-" + index;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int amountWithCoin = 0;
		long ways = 0;
		while (amountWithCoin <= money) {
			int remaining = money - amountWithCoin;
			ways += makeChange(coins, remaining, index + 1, memo);
			amountWithCoin += coins[index];
		}
		
		memo.put(key, ways);
		return ways;
	}
	
	/*
	Question: https://www.hackerrank.com/challenges/ctci-coin-change
	Ref: https://www.hackerrank.com/challenges/ctci-coin-change/forum
	Method 2: DP + memp (non- recursive)
	The theory behind this method is that, take the total method for amount A equals = ways of A (without coins[index]) + ways of (A - coins[index])
	(need to draw on map to find the regulation)
	For example: 
	The regulation is that for amount 2, use coins 1 or coins 2, that is 2 ways
	For amount 4, 
	Way 1: all use 1 is same as previous,
	Way 2:  then use coins 2, puls remain 2 use 1
	Way 3: the remaining 2 which use 1 use another 2 
    */
	/*
	public static long makeChange(int[] coins, int money) {
	
	    // amount 1 to n, dp puls 0, so + 1
	    long[] DP = new long[money + 1]; // O(N) space.
	    DP[0] = (long)1; 	// n == 0 case.
	    for(int i = 0 ; i < coins.length; i++) {
	        int coin = coins[i];
	        for(int j = coin; j < DP.length; j++) {
	        // The only tricky step.
	            DP[j] += DP[j - coin];
	        }
	    }       
	    return DP[money];
	}
    */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coints = {4,2,1};
		// int[] coints = {4,3};
		int money = 10;
		long ways = makeChange(coints, money);
	}

}
