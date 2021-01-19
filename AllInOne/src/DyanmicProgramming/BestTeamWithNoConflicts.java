import java.util.Arrays;

/**
 * 
 * 1626. Best Team With No Conflicts
 * 
 * @author jingjiejiang
 * @history Jan 19, 2021
 * 
 * Ref: https://leetcode.com/problems/best-team-with-no-conflicts/discuss/899631/Java-first-double-sort-then-DP
 *
 */
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {

        assert scores != null && scores.length >= 1 && ages != null && ages.length >= 1;
        
        int res = 0, len = scores.length;
        int[][] team = new int[len][2];

        // 0: age ; 1: score
        for (int idx = 0; idx < len; idx ++) {
            team[idx][0] = ages[idx];
            team[idx][1] = scores[idx];
        }

        Arrays.sort(team, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[len];
        dp[0] = team[0][1];
        for (int rIdx = 1; rIdx < len; rIdx ++) {

            int max = team[rIdx][1];
            for (int lIdx = 0; lIdx < rIdx; lIdx ++) {
                // age[r] > age[l] and score[r] > score[l]
                // score can be equal
                if (team[rIdx][1] >= team[lIdx][1]) {
                    max = Math.max(max, team[rIdx][1] + dp[lIdx]);
                }
            }

            dp[rIdx] = max;
        }

        for (int score : dp) {
            res = Math.max(res, score);
        }

        return res;
    }
}