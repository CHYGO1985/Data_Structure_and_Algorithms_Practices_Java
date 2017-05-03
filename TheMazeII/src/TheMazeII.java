

public class TheMazeII {

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // idea: use two dimentional array to keep the data
        // 1) add the weight data into each round
        // 607ms, beat 5%
    	// *** 1. when need to pick min , during BSF or DSF, check whether the temp data is larger then currrent
        // min, if so, then quit the current loop to save time
    	
        // round 2: use BSF, it will signigicantly decrease the time
        // ref: https://discuss.leetcode.com/topic/77472/similar-to-the-maze-easy-understanding-java-bfs-solution
        
        if (null == maze || 0 == maze.length || 0 == maze[0].length || null == start 
                || 0 == start.length || null == destination || 0 == destination.length)
            return -1;
       
        int[][] status = new int[maze.length][maze[0].length];
        status[destination[0]][destination[1]] = Integer.MAX_VALUE;
        
        return dfs(maze, status, start, destination, 1) == true ? status[destination[0]][destination[1]] - 1 : -1;
    }
    
    private boolean dfs(int[][] maze, int[][] status, int[] start, int[] des, int length) {
        
        /*
    	// verison 1
    	if (status[start[0]][start[1]] > 0) {
    		if (length >= status[start[0]][start[1]])
    			return false;
    		else {
    			status[start[0]][start[1]] = Math.min(status[start[0]][start[1]], length);
			}
        }
    	*/
    	
    	// *** must be careful about length >= status[start[0]][start[1]], means if the current route is shorter, must go through the whole old route again
    	// verison 2 --> refactoring of version 
        if (status[start[0]][start[1]] > 0 && length >= status[start[0]][start[1]])
    			return false;
        status[start[0]][start[1]] = length;
        
    	if ( (start[0] == des[0]) && (start[1] == des[1]) ) {
    		status[des[0]][des[1]] = Math.min(status[des[0]][des[1]], length);
            return true;
        }
    	
        // core step
        boolean res = false;
        for (int i = 0; i < dirs.length; i ++) {
                
            int[] tempStart = new int[start.length];
            int weight = 0;
            tempStart[0] = start[0];
            tempStart[1] = start[1];
            do {
                tempStart[0] += dirs[i][0];
                tempStart[1] += dirs[i][1];
                weight ++;
            }
            while ( tempStart[0] >= 0 && tempStart[0] < maze.length 
                    && tempStart[1] >= 0 && tempStart[1] < maze[0].length 
                    && maze[tempStart[0]][tempStart[1]] == 0);
            
            // when quit the while loop, the val has already exceeded the normal val
            tempStart[0] -= dirs[i][0];
            tempStart[1] -= dirs[i][1];
            weight --;
            weight += length;
            res = res | dfs(maze, status, tempStart, des, weight);
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[][] map = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] s = {0,4};
		int[] e = {4,4};
		
		/*
		int[][] map = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0}};
		int[] s = {0,4};
		int[] e = {1,0};
		*/
	}

}
