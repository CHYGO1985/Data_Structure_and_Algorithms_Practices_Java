/**
 * 
 * 1283. Find the Smallest Divisor Given a Threshold
 * 
 * @author jingjiejiang
 * @history Nov 6, 2020
 * 
 * ref: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/discuss/446376/JavaC%2B%2BPython-Binary-Search
 * 
 */
class Solution {
  public int smallestDivisor(int[] nums, int threshold) {
      
      int left = 1, right = (int)1e6;
      while (left < right) {
          int m = (left + right) / 2, sum = 0;
          for (int i : nums)
              sum += i / m  + (i % m == 0 ? 0 : 1);
          if (sum > threshold)
              left = m + 1;
          else
              right = m;
      }
      return left;
  }
}