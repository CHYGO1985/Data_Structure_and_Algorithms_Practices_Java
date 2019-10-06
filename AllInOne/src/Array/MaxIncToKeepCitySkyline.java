package Array;

/**
 * 
 * @author jingjiejiang Feb 27 2019
 *
 */
public class MaxIncToKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
        
		int res = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0) return res;
		
		int[] rowMax = new int[grid.length];
		int[] colMax = new int[grid[0].length];
		
		for (int row = 0; row < grid.length; row ++) {
			for (int col = 0; col < grid[0].length; col ++) {
				rowMax[row] = Math.max(rowMax[row], grid[row][col]);
				colMax[col] = Math.max(colMax[col], grid[row][col]);
			}
		}
		
		for (int row = 0; row < grid.length; row ++) {
			for (int col = 0; col < grid[0].length; col ++) {
				res += Math.min(rowMax[row], colMax[col]) - grid[row][col];
			}
		}
		
		return res;
    }
}
