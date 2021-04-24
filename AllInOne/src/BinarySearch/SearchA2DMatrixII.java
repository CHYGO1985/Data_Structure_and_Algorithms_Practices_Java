/**
 * 
 * 240. Search a 2D Matrix II
 * 
 * @author jingjiejiang
 * @history Apr 15, 2021
 * 
 */
class SearchA2DMatrixII {
    // search in diagonal style
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0) return false;

        int shorter = Math.min(matrix.length, matrix[0].length);

        for (int idx = 0; idx < shorter; idx ++) {
            boolean verticalFound = binarySearch(matrix, target, idx, true);
            boolean hortizontalFound = binarySearch(matrix, target, idx, false);

            if (verticalFound || hortizontalFound) return true;
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean isVertical) {

        int lo = start;
        int hi = isVertical ? matrix[0].length - 1 : matrix.length - 1;

        while (lo <= hi) {
            
            int mid = lo + (hi - lo) / 2;
            // [[1,2,3],[4,5,6]] : search [1, 2, 3]
            if (isVertical) {

                if (matrix[start][mid] == target) {
                    return true;
                } else if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else { // [[1,2,3],[4,5,6]] : search [1, 4]

                if (matrix[mid][start] == target) {
                    return true;
                } else if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return false;
    }

    // search by "first" ele of row then col
    public boolean searchMatrix2(int[][] matrix, int target) {

        int row = matrix.length - 1;
        int col = matrix[0][0];

        while (row >= 0 && col < matrix[0].length) {

            if (matrix[row][col] < target) {
                col ++;
            } else if (matrix[row][col] > target) {
                row --;
            } else {
                return true;
            }
        }

        return false;
    }
}