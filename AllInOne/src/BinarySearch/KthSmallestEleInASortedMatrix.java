/**
 * 
 * 378. Kth Smallest Element in a Sorted Matrix
 * 
 * @author jingjiejiang
 * @history Apr 13, 2021
 * 
 */
public class KthSmallestEleInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
    
        assert matrix != null && matrix.length > 0;

        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int numCnt = 0;
            int col = matrix[0].length - 1;
            for (int row = 0; row < matrix.length; row ++) {
                
                // as decend by row and col, if cur [row][col] > mid, then in the following rows, the cols after cur col must > mid
                while (col >= 0 && matrix[row][col] > mid) col --;
                numCnt += (col + 1);
            }

            // count == k does not mean “mid” exist in matrix, what we want to find is left boundry (binary search for left boundry)
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
