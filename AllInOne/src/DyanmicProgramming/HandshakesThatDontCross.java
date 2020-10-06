/**
 * 
 * 1259. Handshakes That Don't Cross
 * 
 * @CHYGO1985
 * @history Oct 6, 2020
 * 
 */
class Solution {
    public int numberOfWays(int num_people) {
        
        if (num_people < 2) return -1;

        int mod = (int)Math.pow(10, 9) + 7;
        int pair = num_people / 2;
        long[] dp = new long[pair + 1];
        dp[0] = 1;

        for (int pairCnt = 1; pairCnt <= pair; pairCnt ++) {
            for (int leftPair = 0; leftPair < pairCnt; leftPair ++) {
                dp[pairCnt] = (dp[pairCnt] + dp[leftPair] * dp[pairCnt - 1 - leftPair]) % mod;
            }
        }

        return (int)dp[pair];
    }
}