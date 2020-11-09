import sun.text.resources.ext.CollationData_el;

/**
 * 
 * 1504. Count Submatrices With All Ones
 * 
 * @CHYGO1985
 * @history Nov 9, 2020
 * 
 */
class Solution {
    public int numSubmat(int[][] mat) {

        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;

        int rowLen = mat.length, colLen = mat[0].length;
        int sum = 0;

        for (int upRow = 0; upRow < rowLen; upRow ++) {

            int[] curArr = new int[colLen];
            Arrays.fill(curArr, 1);
            for (int downRow = upRow; downRow < rowLen; downRow ++) {

                for (int col = 0; col < colLen; col ++) {
                    curArr[col] &= mat[downRow][col];
                }

                sum += getRowSum(curArr);
            }
        }

        return sum;
    }

    private int getRowSum(int[] arr) {

        int res = 0, length = 0;

        for (int idx = 0; idx < arr.length; idx ++) {

            length = (arr[idx] == 0 ? 0 : length + 1);
            res += length;
        }

        return res;
    }
}
