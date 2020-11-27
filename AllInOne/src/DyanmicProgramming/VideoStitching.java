import java.util.Arrays;

/**
 * 
 * 1024. Video Stitching
 * 
 * @CHYGO1985
 * @history Nov 26, 2020
 * 
 * ref: https://leetcode.com/problems/video-stitching/discuss/270350/Java-DP-Short-Solution-!!!
 * 
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        
        assert clips != null;
        assert clips.length >= 1;

        if (T == 0) return 0;

        // as need to check [0, T]
        int[] dp = new int[T + 1];
        Arrays.fill(dp, - 1);

        Arrays.sort(clips, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        for (int idx = 0; idx < clips.length; idx ++) {

            int[] curClip = clips[idx];
            if (curClip[0] > T) continue;
            
            // for [0, x], we always count the pos as 1
            if (curClip[0] == 0) {
                for (int pos = curClip[0]; pos <= T && pos <= curClip[1]; pos ++) {

                    dp[pos] = 1;
                }
            } else if (dp[curClip[0]] == -1) { // [x, y] (x > 0) and dp[x] == -1. and it is not counted before

                // e.g. [0, 1], [2, 3], there is a gap between 1 and 2, should return -1
                return -1; // as it is sorted, there is a gap
  
            } else { // [x, y], dp[x] > -1, means previously is occupied, we only add the ones that are -1 with dp[x] + 1 
                int min = dp[curClip[0]] + 1;
                for (int pos = curClip[0] + 1; pos <= T && pos <= curClip[1]; pos ++) {

                    if (dp[pos] == -1) {

                        dp[pos] = Math.min(min, dp[pos - 1] + 1);
                    }
                }
            }
        }

        return dp[T];
    }
}
