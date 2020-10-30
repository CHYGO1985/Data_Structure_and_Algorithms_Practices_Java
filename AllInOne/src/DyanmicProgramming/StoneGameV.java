/**
 * 
 * 1563. Stone Game V
 * 
 * @CHYGO1985
 * @history Oct 29, 2020
 * 
 * ref: https://leetcode.com/problems/stone-game-v/discuss/806717/Java-Detailed-Explanation-Easy-Understand-DFS-%2B-Memo-Top-Down-DP
 * 
 */
public class StoneGameV {
    public int stoneGameV(int[] stoneValue) {
        
        int len = stoneValue.length;

        // cal pre sums
        int[] preSums = new int[len + 1];

        for (int idx = 0; idx < stoneValue.length; idx ++) {
            preSums[idx + 1] = preSums[idx] + stoneValue[idx];
        }

        return getMax(stoneValue, 0, len - 1, preSums, new Integer[len][len]);
    }    

    private int getMax(int[] stoneValue, int left, int right, int[] preSums, Integer[][] dp) {

        // there is only one value in the array
        if (left == right) return 0;

        // there is only two values in the array
        if (left + 1 == right) return Math.min(stoneValue[left], stoneValue[right]);

        if (dp[left][right] != null) return dp[left][right];

        int res = 0;

        for (int idx = left; idx < right; idx ++) {

            int leftVal = preSums[idx + 1] - preSums[left];
            int rightVal = preSums[right + 1] - preSums[idx + 1];

            if (leftVal > rightVal) {
                res = Math.max(res, rightVal + getMax(stoneValue, idx + 1, right, preSums, dp));
            } else if (leftVal < rightVal) {
                res = Math.max(res, leftVal + getMax(stoneValue, left, idx, preSums, dp));
            } else {
                res = Math.max(res, leftVal + Math.max(
                    getMax(stoneValue, idx + 1, right, preSums, dp), getMax(stoneValue, left, idx, preSums, dp)));
            }
        }

        dp[left][right] = res;
        
        return res;
    }
}
