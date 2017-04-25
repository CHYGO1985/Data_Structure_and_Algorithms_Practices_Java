
public class TheMaze {

    
	private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	    
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // round 1: spend 1.5 hours to understand the question (rolling not step by step), spend more than 10 hours to get
        // the solution (with refs)
        // *** 1. I did not know how to control the ball to roll one diretion when it is not a stop point, then
        // roll at different direction at a stop point
        // --> at each step, just go straight forward to the end, until meet a stop point, then go into dfs loop
        // ref: https://discuss.leetcode.com/topic/78133/simple-dfs-solution-beat-97
        
        // idea: dfs (keep the previous direction infor, use % to roll over)
        // *** 1. when think about how to write code, start from simple case, then to complicated ones
        // 1) one dimen array: 1 0 0 0 0 start --> when start reach 1 (1 is not end), how to get back to start
        // *** 2. stackOverFlow for termination condition
        // did not change the start value at each round
        
        if (null == maze || 0 == maze.length || 0 == maze[0].length || null == start 
                || 0 == start.length || null == destination || 0 == destination.length)
            return false;
       
        boolean[][] status = new boolean[maze.length][maze[0].length];
        
        return dfs(maze, status, start, destination);
    }
    
    private static boolean dfs(int[][] maze, boolean[][] status, int[] start, int[] des) {
        
        if (status[start[0]][start[1]] == true)
            return false;
        status[start[0]][start[1]] = true;
        if ( (start[0] == des[0]) && (start[1] == des[1]) )
            return true;
        
        // core step
        for (int i = 0; i < dirs.length; i ++) {
                
            int[] tempStart = new int[start.length];
            tempStart[0] = start[0];
            tempStart[1] = start[1];
            do {
                tempStart[0] += dirs[i][0];
                tempStart[1] += dirs[i][1];
            }
            while ( tempStart[0] >= 0 && tempStart[0] < maze.length 
                    && tempStart[1] >= 0 && tempStart[1] < maze[0].length 
                    && maze[tempStart[0]][tempStart[1]] == 0);
            
            // when quit the while loop, the val has already exceeded the normal val
            tempStart[0] -= dirs[i][0];
            tempStart[1] -= dirs[i][1];
            if(dfs(maze, status, tempStart, des) == true)
                return true;
        }
        
        return false;
        /*
        // core step
        boolean res = false;
        for (int i = 0; i < dirs.length; i ++) {
                
            int[] tempStart = new int[start.length];
            tempStart[0] = start[0];
            tempStart[1] = start[1];
            do {
                tempStart[0] += dirs[i][0];
                tempStart[1] += dirs[i][1];
            }
            while ( tempStart[0] >= 0 && tempStart[0] < maze.length 
                    && tempStart[1] >= 0 && tempStart[1] < maze[0].length 
                    && maze[tempStart[0]][tempStart[1]] == 0);
            
            // when quit the while loop, the val has already exceeded the normal val
            tempStart[0] -= dirs[i][0];
            tempStart[1] -= dirs[i][1];
            res = res | dfs(maze, status, tempStart, des);
         }
         return res;
         */
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[][] map = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] s = {0,4};
		int[] e = {1,2};
		*/
		int[][] map = {{0,0,0,0,0}};
		int[] s = {0,4};
		int[] e = {0,0};
	    boolean res = hasPath(map, s, e);
	}

}
