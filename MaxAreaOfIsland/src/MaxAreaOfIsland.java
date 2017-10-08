/**
 * 
 * 695. Max Area of Island
 * 
 * round 1: solved, 30m, dfs, 2 attemps
 * 
 * idea: directly related to dfs method
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 7, 2017
 */
public class MaxAreaOfIsland {
	
	public int maxAreaOfIsland(int[][] grid) {
        
        int res = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        if (null == grid || 0 == grid.length) return 0;
        
        for (int row = 0; row < grid.length; row ++)
            for (int col = 0; col < grid[0].length; col ++) {
                if (grid[row][col] == 0 || grid[row][col] == -1) continue;
                int tmp = dfs(grid, row, col, dirs, 0);
                res = Math.max(tmp, res);
            }
        
        return res;
    }
    
    private int dfs (int[][] grid, int row, int col, int[][] dirs, int count) {
        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
           || grid[row][col] == 0 || grid[row][col] == -1)
            return count;
        
        grid[row][col] = -1;
        count ++;
        
        for (int i = 0; i < dirs.length; i ++) {
            count = dfs (grid, row + dirs[i][0], col + dirs[i][1], dirs, count);
        }
        
        return count;
    }	

}
