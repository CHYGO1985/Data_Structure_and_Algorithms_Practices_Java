/**
 * 
 * 1130. Minimum Cost Tree From Leaf Values
 * 
 * @CHYGO1985
 * @history Nov 7, 2020
 * 
 * ref: https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/398420/Java-DP-Solution-very-easy-to-understand
 * 
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {

        if (arr == null || arr.length < 2) return 0;

        int[][] dp = new int[arr.length][arr.length];

        return dfs(arr, 0, arr.length - 1, dp);
    }

    private int dfs(int[] arr, int start, int end, int[][] dp) {

        // stop condition start == end
        if (start == end) return 0;
        if (dp[start][end] > 0) return dp[start][end];

        int res = Integer.MAX_VALUE;
        // either idx = start + 1, then idx <= end  or idx == start, idx < end to inlcude the whole array into left or right
        for (int idx = start; idx < end; idx ++) {

            int leftRes = dfs(arr, start, idx, dp);
            int rightRes = dfs(arr, idx + 1, end, dp);

            int maxLeft = 0, maxRight = 0;
            for (int shift = start; shift <= idx; shift ++) maxLeft = Math.max(maxLeft, arr[shift]);
            for (int shift = idx + 1; shift <= end; shift ++) maxRight = Math.max(maxRight, arr[shift]);
            
            res = Math.min(res, leftRes + rightRes + maxLeft * maxRight);
        }

        dp[start][end] = res;

        return res;
    }
}
