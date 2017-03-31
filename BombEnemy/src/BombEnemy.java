
public class BombEnemy {
	
	public int maxKilledEnemies(char[][] grid) {
        // round 1: used 2 hours, too much time
        // idea: optimise from brutal force O(n^2) need to check everytime to O(mn)
        // 1. it can be seen that for row / col without walls, all the bombs can get the same result
        // 1) use an array to record row num and arry for col num
        // 2) handle walls: update the count when met a wall
        
        /* test case used : 
        ["0E00","E0WE","0E00"]
        ["0","E","W"]
        ["E0E0EE","E0WE00","EW00EE"]
        */
        int result = 0;
        
        if(grid.length == 0)
            return result;
        
        int[][] status = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i ++) {
            int count = 0;
            int lastWall = 0;
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == 'E') {
                    count ++;
                }
                // *** I did add the case that when W is the last
                else if (j != grid[i].length - 1 && grid[i][j] == 'W') {
                    // E 1 W 2 E 2 E W 1 E --> make the row like this
                    for (int k = lastWall; k < j; k ++) {
                        if (grid[i][k] == '0') 
                            status[i][k] = count;
                    }
                    lastWall = j;
                    count = 0;
                }
            }
            // if there is no wall in the row, update all the '0' to the total count
            // or the E0E0W000E, for the rest of row after 'E'
            for (int j = lastWall; j < grid[i].length; j ++) {
                if (grid[i][j] == '0') 
                    status[i][j] = count; 
            }
        }
        
        for (int col = 0; col < grid[0].length; col ++) {
            int count = 0;
            int lastWall = 0;
            for (int row = 0; row < grid.length; row ++) {
                if (grid[row][col] == 'E') {
                    count ++;
                }
                else if (row != grid.length - 1 && grid[row][col] == 'W') {
                    for(int k = lastWall; k < row; k ++) {
                        if (grid[k][col] == '0')
                            status[k][col] += count;
                    }
                    count = 0;
                    // *** I did add the case that when W is the last
                    lastWall = row;
                }
            }
            
            for (int m = lastWall; m < grid.length; m ++) {
                if (grid[m][col] == '0')
                    status[m][col] += count; 
            }
        }
        
        for (int i = 0; i < status.length; i ++) {
            for (int j = 0; j < status[i].length; j ++) {
                if (status[i][j] > result)
                    result = status[i][j];
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
