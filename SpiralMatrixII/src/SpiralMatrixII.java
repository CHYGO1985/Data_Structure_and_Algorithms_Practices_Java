/**
 * 
 * 59. Spiral Matrix II
 * 
 * round 1: solved, 40m, 3 attemps
 * 
 * idea : spiral matrix, find the corner points, start points of each spiral,
 * drow a 3 and 4 matrix to find the regulation.
 * 
 * 1) start point (0, 0 --> n, n) every time +1
 * 2) corner: 
 * a. upper left : (base, base) --> upper right (base, base + n - 1 - reduce)
 * b. upper right to bottom right: (base + n - 1 - reduce, base + n - 1 - reduce) 
 * c. bottom right to bottom left (base, base + n - 1 - reduce)
 * 
 *  *** test case:
 *  1. every diection after for loop, row and col will exceed the limit, so 
 *  need to adjust it before next for loop
 *  2. start with cornor point + 1, not corner point
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 3, 2017
 */
public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int base = 0;
        int reduce = 0;
        int num = 1;
        
        // *** do not start at the corner, corner + 1
        while (base < n - 1 - reduce) {
            
            // upper-left to upper right
            int col = base;
            for (; col <= n - 1 - reduce; col ++)
                matrix[base][col] = num ++;
            
            // upper-right to bottom right
            int row = base + 1;
            // *** col need to -1 first
            for (col --; row <= n - 1 - reduce; row ++)
                matrix[row][col] = num ++;
            
            // bottom right to bottom left
            for (col --, row --; col >= base; col --)
                matrix[row][col] = num ++;
            
            // bottom left to upper left
            // *** note here row > base
            for (row --, col ++; row > base; row --)
                matrix[row][col] = num ++;
            //
            base ++;
            reduce ++;
        }
        
        if (base == n - 1 - reduce)
            matrix[base][base] = num;
        
        return matrix;
    }
}
