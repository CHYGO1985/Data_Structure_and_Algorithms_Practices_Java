
public class IslandPerimeter {

	private static int count = 0;
    private static int[][] coord = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public static int islandPerimeter(int[][] grid) {
        
    	// round 1: mis-understood the question, should write more test case to check my understanding first
        // solved used 1.5 hours
        // idea: dfs (when 0 / exceed range, return length 1)
        
    	// *** 1.stuck on how to the right return value for global count in DFS
        // *** 2. was trying to avoid using global variable for acount
        // ref: https://discuss.leetcode.com/topic/68891/java-solution-with-dfs
        
        boolean[][] status = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    dfs(grid, status, i, j);
                    return count;
                }
            }
        }
        
        return count;
    }
    
    /* non global count version
    private int dfs(int[][] grid, boolean[][] status, int row, int col) {
        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
                || grid[row][col] == 0) {
            return 1;
        }
            
        if (grid[row][col] == 1) {
            if (status[row][col] == true)
                return  0;
            status[row][col] = true;
        }
        
        // core step
        int count = 0;
        for (int i = 0; i < coord.length; i ++) {
            count += dfs(grid, status, row + coord[i][0], col + coord[i][1]);
        }
        
        return count;
    }
     */
	private static void dfs(int[][] grid, boolean[][] status, int row, int col) {
        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
                || grid[row][col] == 0) { 
        	count ++;
            return ;
        }
            
        if (grid[row][col] == 1) {
            if (status[row][col] == true)
                return ;
            status[row][col] = true;
        }
        
        // core step
        for (int i = 0; i < coord.length; i ++) {
             dfs(grid, status, row + coord[i][0], col + coord[i][1]);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
	    int res = islandPerimeter(map);
	}

}
