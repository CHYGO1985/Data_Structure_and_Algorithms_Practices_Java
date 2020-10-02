class Solution {
    public boolean canCross(int[] stones) {

        if (stones == null || stones.length == 0) return true;

        int len = stones.length;
        boolean[][] dp = new boolean[len][len + 1];
        dp[0][1] = true;

        for (int postStone = 0; postStone < len; postStone ++) {
            for (int preStone = 0; preStone < postStone; preStone ++) {

                int dist = stones[postStone] - stones[preStone];
                if (dist < 0 || dist > len || !dp[preStone][dist]) continue;
                if (postStone == len - 1) return true;

                dp[postStone][dist] = true;

                if (dist - 1 >= 0) dp[postStone][dist - 1] = true;
                if (dist + 1 < len + 1) dp[postStone][dist + 1] = true;
            }
        }

        return false;
    }
}