/**
 * 
 * 1039. Minimum Score Triangulation of Polygon
 * 
 * @author jingjiejiang
 * @history Nov 17, 2020
 * 
 */
class Solution {
  public int minScoreTriangulation(int[] A) {
      
    int len = A.length;
    int[][] dp = new int[len][len];

    for (int dist = 2; dist < len; dist ++) {// start from 3 sides (2 eles in A), 4 sides ...
      for (int startPoint = 0; startPoint + dist < len; startPoint ++) {

        int farPoint = startPoint + dist;
        dp[startPoint][farPoint] = Integer.MAX_VALUE;
        for (int shift = startPoint + 1; shift < farPoint; shift ++) {
          dp[startPoint][farPoint] = Math.min(dp[startPoint][farPoint],
            dp[startPoint][shift] + dp[shift][farPoint] + A[startPoint] * A[shift] * A[farPoint]);
        }
      }
      
    }

    return dp[0][len - 1];
  }
}