/**
 * 
 * 74. Search a 2D Matrix
 * 
 * @CHYGO1985
 * @history Oct 16, 2020
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

       int rowLen = matrix.length;
       int colLen = matrix[0].length;

       int start = 0, end = rowLen - 1;

       // get the row that the target belongs to
       while (start <= end) {
           int mid = start + (end - start) / 2;

           if (matrix[mid][0] == target) return true;

           if (target < matrix[mid][0]) {
               end = mid - 1;
           } else {
               start = mid + 1;
           }
       }

       // [[1]] 0
       if (start < 0 || end < 0) return false;
       int rowNum = end;

       // get the position in the row for the target if exist
       start = 0;
       end = colLen - 1;

       while (start <= end) {

           int mid = start + (end - start) / 2;

           if (matrix[rowNum][mid] == target) return true;

           if (target < matrix[rowNum][mid]) {
               end = mid - 1;
           } else {
               start = mid + 1;
           }
       }

       return false;
   }
}