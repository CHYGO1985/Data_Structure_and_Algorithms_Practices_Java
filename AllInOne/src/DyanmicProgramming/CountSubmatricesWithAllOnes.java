import java.util.Stack;

/**
 * 
 * 1504. Count Submatrices With All Ones
 * 
 * @CHYGO1985
 * @history Nov 9, 2020
 * 
 * ref: https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed-Explanation-From-O(MNM)-to-O(MN)-by-using-Stack
 * 
 */
class Solution {
    // Method 1: compress method
    // public int numSubmat(int[][] mat) {

    //     if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;

    //     int rowLen = mat.length, colLen = mat[0].length;
    //     int sum = 0;

    //     for (int upRow = 0; upRow < rowLen; upRow ++) {

    //         int[] curArr = new int[colLen];
    //         Arrays.fill(curArr, 1);
    //         for (int downRow = upRow; downRow < rowLen; downRow ++) {

    //             for (int col = 0; col < colLen; col ++) {
    //                 curArr[col] &= mat[downRow][col];
    //             }

    //             sum += getRowSum(curArr);
    //         }
    //     }

    //     return sum;
    // }

    // private int getRowSum(int[] arr) {

    //     int res = 0, length = 0;

    //     for (int idx = 0; idx < arr.length; idx ++) {

    //         length = (arr[idx] == 0 ? 0 : length + 1);
    //         res += length;
    //     }

    //     return res;
    // }

    // method 2: histogram
    public int numSubmat(int[][] mat) {
        
      int rowLen = mat.length, colLen = mat[0].length;
      int res = 0;
      // the h array for cal histogram
      int[] high = new int[colLen];

      for (int row = 0; row < rowLen; row ++) {
        for (int col = 0; col < colLen; col ++) {
          high[col] = (mat[row][col] == 0 ? 0 : high[col] + 1);
        }

        res += getSubMatrix(high);
      }

      return res;
    }

    private int getSubMatrix(int[] arr) {

      int[] sums = new int[arr.length];
      int res = 0;
      // Stack: use to check height of cur histogram with height of previous histogram
      Stack<Integer> heighStack = new Stack<>();

      // ** store idx
      // ** when there are height lower than current one
      // sums[idx] = sums[preIdx]
      // sums[idx] += arr[idx] * (idx - preIdx)  (+=)
      for (int idx = 0; idx < arr.length; idx ++) {

        while (!heighStack.isEmpty() && arr[heighStack.peek()] >= arr[idx]) {
          heighStack.pop();
        }

        if (!heighStack.isEmpty()) { // if there are height lower than the current one

          int preIdx = heighStack.peek();
          sums[idx] = sums[preIdx];
          sums[idx] += arr[idx] * (idx - preIdx);
        } else { // if all pre heights higher or equal than the current one
          sums[idx] = arr[idx] * (idx + 1);
        }

        heighStack.push(idx);
      }

      for (int sum : sums) res += sum;

      return res;
    }
}
