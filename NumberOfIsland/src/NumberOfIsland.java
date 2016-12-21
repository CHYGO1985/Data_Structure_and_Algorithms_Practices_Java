
public class NumberOfIsland {
	
	// DFS search for islands
    public static int searchIsland(char[][] grid, boolean[][] isVisited, int row, int col) {
        
        if (true == isVisited[row][col] || '0' == grid[row][col]) {
            
            return 0;
        }
        else {
            
            isVisited[row][col] = true;
            
            // search up direction, i - 1, j
            if (row - 1 >= 0) {
                
                searchIsland(grid, isVisited, row - 1, col);
            }
            
            // search left direction i, j - 1
            if (col - 1 >= 0) {
                
                searchIsland(grid, isVisited, row, col - 1);
            }
            
            // search down direction, i + 1, j
            if (row + 1 < grid.length) {
                
                searchIsland(grid, isVisited, row + 1, col);
            }
            
            // search rigth direction, i, j + 1
            if (col + 1 < grid[0].length) {
                
                searchIsland(grid, isVisited, row, col + 1);
            }
            
            return 1;
        }
    }
    
    public static int numIslands(char[][] grid) {
        // idea: DFS
        // 1) every cell: up, down, left and right
        // 2) if cur point is "1" && "unvisited", go to next recursive loop, else "visited" or "0", return directly
        // 3) how to count? (the last avail "1")
        // a. whatever happen, the last avail one, must have the same row num or col num as the first one
        // so just check when there is a "1", record the points in the matrix ( do it outside of the recrusive method) 
        // 4) trick: the dfs method can only return an int num to store both row and col num, need to use bit manipulation
        
        // use a boolean[][] to represent the visiting status of a cell
        int length = grid.length;
        int wide = grid[0].length;
        
        int island = 0;
        
        boolean[][] isVisited = new boolean[length][wide];
        
        // init all as unvisted
        for (int i = 0; i < length; i++) { 
            for (int j = 0; j < wide; j ++) {
                isVisited[i][j] = false;
            }
        }
        
        // from cell to cell in grids search islands, skip visited and '0'
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < wide; j ++) {
                
                if ('1' == grid[i][j] && 1 == searchIsland(grid, isVisited, i, j)) {
                    island ++;
                }
            }
        }
        
        return island;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "11110"; 
		char[] a = aString.toCharArray();
		aString = "11010";
		char[] b = aString.toCharArray();
		aString = "11000";
		char[] c = aString.toCharArray();
		aString = "00000";
		char[] d = aString.toCharArray();
		
		char[][] grid = {a, b, c, d};
		
		int i = numIslands(grid);
		
		System.out.print(i);
	}

}
