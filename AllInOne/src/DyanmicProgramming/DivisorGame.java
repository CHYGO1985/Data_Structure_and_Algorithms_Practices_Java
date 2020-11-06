/**
 * 
 * 1025. Divisor Game
 * 
 * @CHYGO1985
 * @history Nov 6, 2020
 * 
 * 
 * state transfer: 
 * 
 * when num = i;
 * 
 * whether alice can win is determined by whether dp[i] = true;
 * only if there exist a x, 0 < x < i and i % x == 0
 * and dp[i - x] = false (Bob as the next player will lose);
 * 
 */
class Solution {
    public boolean divisorGame(int N) {

        if (N < 0) return true;

        boolean[] dp = new boolean[N + 1];

        // init dp[0] == true
        dp[0] = true;
        
        for (int num = 1; num <= N; num ++) {

            int limit = num;
            int x = 1;

            while (x < limit && limit % x == 0) {
                if (!dp[num - x]) {
                    dp[num] = true;
                    break;
                } 
                x ++;
            }
        }

        return dp[N];
    }
}