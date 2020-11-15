/**
 * 
 * 813. Largest Sum of Averages
 * 
 * @author jingjiejiagn
 * @history Nov 15, 2020
 * 
 * ref: https://leetcode.com/problems/largest-sum-of-averages/discuss/126280/Naive-Detailed-Step-by-Step-Approach-from-Recursive-to-DP-O(N)-solution
 * 
 * I know the idea of recursive, but do not know how to write code
 */
class Solution {
  public double largestSumOfAverages(int[] A, int K) {
    int[] sum = new int[A.length];
    // cal preSums
    for (int i = 0;i < A.length; i++) sum[i] = A[i] + (i > 0 ? sum[i-1] : 0); 
    return h(A, K, sum, A.length, 0);
  }

  // k: is the current avail group num
  // s: is the start idx of the available numbers in A, start from 0 
  public double h(int[] A, int k, int[] sum, int len, int s) {
      // take 9 1 2 as example, presum = 9 10 12, if we need to get sum of 1 and 2, then is 12 - 10 + 1 = 3
      // when k = 1, we calc the rest of num
      if (k == 1) return ((double)(sum[len-1] - sum[s] + A[s]) / (len-s));
      double num = 0;
      // i is the shift idx from s to i + k <= A.length
      for (int i = s; i + k <= len ; i++) {
          num = Math.max(num, ((double) (sum[i] - sum[s] + A[s]) / (i - s + 1)) + h(A, k-1, sum, len, i+1));
      }
      return num;
  }
}