/**
 * 
 * 1423. Maximum Points You Can Obtain from Cards
 * 
 * @author jingjiejiang
 * @hiistory Dec 14, 2020
 * 
 * ref: comment 3 https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/598111/Java-dp-solution(explanation-with-picture)
 * 
 */
class Solution {
  public int maxScore(int[] cardPoints, int k) {
      
    assert cardPoints != null && cardPoints.length >= 1 && k >= 1;

    int left = 0, right = 0;
    int len = cardPoints.length;

    for (int idx = len - 1; idx >= len - k; idx --) {

      right += cardPoints[idx];
    }

    int leftIdx = -1, rightIdx = len - k;
    int max = right;

    while (leftIdx < k - 1) {
      leftIdx ++;
      rightIdx ++;
      left += cardPoints[leftIdx];
      right -= cardPoints[rightIdx];
      max = Math.max(max, left + right);
    }

    return max;
  }
}
