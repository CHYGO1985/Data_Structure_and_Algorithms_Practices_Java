package Graph;

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
	
	private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                res = Math.max(dfs(grid, row, col, 0), res);
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] grid, int row, int col, int area) {
        if (row < 0 || row >= grid.length || col < 0 
            || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == -1) {
            return area;
        }
        
        grid[row][col] = -1;
        area ++;
        for (int[] dir : dirs) {
            area = dfs(grid, row + dir[0], col + dir[1], area);
        }
        
        return area;
    }
}
