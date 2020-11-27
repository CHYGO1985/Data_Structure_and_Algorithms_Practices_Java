/**
 * 
 * 740. Delete and Earn
 * 
 * @CHYGO1985
 * @history Nov 27, 2020
 * 
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        assert nums != null;

        // init buckets
        int[] buckets = new int[10001];

        for (int num : nums) {
            buckets[num] += num;
        }

        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = buckets[1];

        for (int num = 2; num < dp.length; num ++) {
            dp[num] = Math.max(buckets[num] + dp[num - 2], dp[num - 1]);
        }

        return dp[10000];
    }
}