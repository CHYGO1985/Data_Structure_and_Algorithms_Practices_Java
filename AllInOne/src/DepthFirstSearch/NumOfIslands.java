package src.DepthFirstSearch;

/**
 * 200. Number of Islands
 */
public class NumOfIslands {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        
        assert grid != null && grid.length > 0 && grid[0].length > 0;

        int islandsCnt = 0;

        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                islandsCnt += dfs(grid, row, col);
            }
        }

        return islandsCnt;
    }

    private int dfs(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0
            || col >= grid[0].length || grid[row][col] == '#'
            || grid[row][col] == '0') {
                return 0;
            }
        
        grid[row][col] = '#';
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }

        return 1;
    }
}
