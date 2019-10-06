package Graph;

/**
 * 
 * @author jingjiejiang Feb 11, 2019
 *
 */
public class NumberOfIsland {
	
	private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        
        int count = 0;
        if (grid == null || grid.length == 0) return count;
        
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                count += dfs(grid, row, col);
            }
        }
        
        return count;
    }
    
    private int dfs(char[][] grid, int row, int col) {
        
        if (row < 0 || row >= grid.length || col < 0 
            || col >= grid[0].length || grid[row][col] == '0'
            || grid[row][col] == '#') {
            return 0;
        }
        
        grid[row][col] = '#';
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
        
        return 1;
        
    }
}
