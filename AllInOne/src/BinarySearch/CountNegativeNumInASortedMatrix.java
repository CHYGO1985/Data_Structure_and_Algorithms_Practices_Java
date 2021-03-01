/**
 * 
 * 1351. Count Negative Numbers in a Sorted Matrix
 * 
 * @author jingjiejiang
 * @history Mar 1, 2021
 * 
 */
class Solution {
    public int countNegatives(int[][] grid) {
        
        assert grid != null && grid.length >= 1;

        int rows = grid.length, cols = grid[0].length;
        int res = 0, lastNeg = cols - 1;

        for (int rowIdx = 0; rowIdx < rows; rowIdx ++) {
            
            // if the fst num is neg, then the whole rows are neg 
            if (grid[rowIdx][0] < 0) {
                res += cols;
                continue;
            }

            if (grid[rowIdx][cols - 1] > 0) continue;

            int left = 0, right = lastNeg;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (grid[rowIdx][mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // left is the first neg
            res += cols - left;
            lastNeg = left;
        }

        return res;
    }
}