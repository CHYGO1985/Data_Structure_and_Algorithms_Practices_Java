/**
 * 
 * 1049. Last Stone Weight II
 * 
 * @author jingjiejiang
 * @history Dec 18, 2020
 * 
 * Ref: https://leetcode.com/problems/last-stone-weight-ii/discuss/295167/Java-beat-100-with-nice-explanation
 * comment 1 for optimize (2D to 1D)
 */
class Solution {
  public int lastStoneWeightII(int[] stones) {
      
    int totalSum = 0, partSum = 0;
    for (int stone : stones) totalSum += stone;
    int len = stones.length;
    boolean[][] dp = new boolean[totalSum + 1][len + 1];

    for (int idx = 0; idx <= len; idx ++) {
      dp[0][idx] = true;
    }


    for (int stoneIdx = 1; stoneIdx <= len; stoneIdx ++) {
      // for each sum (until totolSum / 2), check if adding the current stone can reach to sum
      // by check dp[sum][stoneIdx - 1] == true (not use the current one)
      // use the current one (dp[sum - [stongIdx]][stoneIdx - 1] == true)
      // find the neeast sum to totalsum / 2
      for (int sum = 1; sum <= totalSum /2; sum ++) {
        if (dp[sum][stoneIdx - 1] || 
          (sum >= stones[stoneIdx - 1] && dp[sum - stones[stoneIdx - 1]][stoneIdx - 1])) {
            dp[sum][stoneIdx] = true;
            partSum = Math.max(partSum, sum);
          }
      }
    }

    return totalSum - 2 * partSum;
  }
}