/**
 * 
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
}
