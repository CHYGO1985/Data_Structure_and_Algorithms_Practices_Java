package src.Array;

/**
 * 
 * 73. Set Matrix Zeroes
 * 
 * @author jingjiejiang
 * @history May 31, 2021
 * 
 */
public class SetMatrixZeroes {

	// Idea: method 1: use the O(mn) extra space to store the status
    // method 2: used O(m + n) extra space to store the status, after that, change the according to the
    // status to change the matrix
    // method 3: use constant space to store multiple information --> bit manipulation
    // *** bit manipulation only works for limited number of arrays
    // method 4: use only 
    // ref: https://discuss.leetcode.com/topic/62769/java-2-solutions-space-o-1-and-o-m-n-with-explaination
    
    public void setZeroes(int[][] matrix) {
        
      assert matrix.length >= 1 && matrix[0].length <= 200;

      boolean isFstColZero = false;

      for (int rowIdx = 0; rowIdx < matrix.length; rowIdx ++) {
          if (matrix[rowIdx][0] == 0) {
              isFstColZero = true;
          }

          for (int colIdx = 1; colIdx < matrix[0].length; colIdx ++) {
              if (matrix[rowIdx][colIdx] == 0) {
                  matrix[0][colIdx] = 0;
                  matrix[rowIdx][0] = 0;
              }
          }
      }

      for (int rowIdx = 1; rowIdx < matrix.length; rowIdx ++) {
          for (int colIdx = 1; colIdx < matrix[0].length; colIdx ++) {
              if (matrix[rowIdx][0] == 0 || matrix[0][colIdx] == 0) {
                  matrix[rowIdx][colIdx] = 0;
              }
          }
      }

      if (matrix[0][0] == 0) {
          for (int colIdx = 0; colIdx < matrix[0].length; colIdx ++) {
              matrix[0][colIdx] = 0;
          }
      }

      if (isFstColZero) {
          for (int rowIdx = 0; rowIdx < matrix.length; rowIdx ++) {
              matrix[rowIdx][0] = 0;
          }
      }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
