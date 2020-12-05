/**`
 * 978. Longest Turbulent Subarray
 * 
 * @author jingjiejiang
 * @history Dev 3, 2020
 * 
 * Ref: 2 var DP https://leetcode.com/problems/longest-turbulent-subarray/discuss/221935/Java-O(N)-time-O(1)-space
 * Ref: 2D arr DP https://leetcode.com/problems/longest-turbulent-subarray/discuss/222511/DP-Thinking-Process-(Java)
 */
class Solution {
  // two element DP
  public int maxTurbulenceSize(int[] arr) {

    int inc = 1, dec = 1, res = 1;

    for (int idx = 1; idx < arr.length; idx ++) {
      if (arr[idx - 1] < arr[idx]) {
        dec = inc + 1;
        inc = 1;
      } else if (arr[idx - 1] < arr[idx]) {
        inc = dec + 1;
        dec = 1;
      } else {
        inc = 1;
        dec = 1;
      }

      res = Math.max(res, Math.max(inc, dec));
    }

    return res;
  }

  // 2D DP: 
  // state[i][0]: longest turbulent subarray ending at A[i] and A[i-1] < A[i]
  // state[i][1]: longest turbulent subarray ending at A[i] and A[i-1] > A[i]
  // state[i][0] = state[i - 1][1] + 1 or 1
  // state[i][1] = state[i - 1][0] + 1 or 1
  public int maxTurbulenceSize(int[] arr) {

    assert arr != null && arr.length > 0;

    int maxLen = 0;
    int[][] states = new int[arr.length][2];

    for (int idx = 1; idx < arr.length; idx ++) {

      if (arr[idx - 1] > arr[idx]) {
        states[idx][1] = states[idx - 1][0] + 1;
        maxLen = Math.max(maxLen, states[idx][1]); 
      } else if (arr[idx - 1] < arr[idx]) {
        states[idx][0] = states[idx - 1][1] + 1;
        maxLen = Math.max(maxLen, states[idx][0]);
      }
    }

    return maxLen + 1;
  }
}
