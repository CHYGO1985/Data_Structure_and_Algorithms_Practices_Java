import java.util.Arrays;

/**
 * 
 * 74. Search a 2D Matrix
 * 
 * round 1: solved, 10m, 2 attempts 2D to 1D + binary search
 * 
 * idea: simple, a search in 2D array without the limit of using extra space
 * --> change to 1D array + binary search
 * 
 * *** test case : did not consider can find an ele at index 0.
 * 
 * @author jingjiejiang
 * @history
 * 1. Seo 27, 2017
 */
public class SearchA2DMatrix {

	// method 1: solved, 10m. 2 attemps
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // search --> binary search
        
        // method 1:
        // if allow extra space than it is very easy
        // turn 2D matrix to 1D array
        if (matrix == null || 0 == matrix.length) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[] nums = new int[row * col];
            
        for (int i = 0; i < nums.length; i ++) {
            int tmpRow = i / col;
            int tmpCol = i % col;
            nums[i] = matrix[tmpRow][tmpCol];
        }
        
        // *** should use >= 0 here
        return Arrays.binarySearch(nums, target) >= 0;
    }
    
    // method 2 use the format that row * ColLen + col = length
}
