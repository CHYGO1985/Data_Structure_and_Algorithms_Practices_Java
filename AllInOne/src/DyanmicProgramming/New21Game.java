/**
 * 
 * 837. New 21 Game
 * 
 * @author jingjiejiang
 * @history Jan 23, 2021
 * 
 */
public class Solution {
  public double new21Game(int N, int K, int W) {
      
    assert N >= 0 && K >= 0 && W >= 1;

    double[] dp = new double[N + 1];
    dp[0] = 1.0d;
    double sum = 0.0d;

    for (int point = 1; point <= N; point ++) {

      int leftBound = point - W - 1;
      if (leftBound >= 0) sum -= dp[leftBound]; 
      if (point - 1 < K) sum += dp[point - 1];

      dp[point] = sum * (1.0d / W); 
    }

    double res = 0.0d;

    for (int total = K; total <= N; total ++) {
      res += dp[total];
    }

    return res;
  }
}
