
public class DungeonGame {
	
	public static int calculateMinimumHP(int[][] dungeon) {
        // idea: DP, from bottom-right to left-corner, from right to left and from bottom row to top row
        
        // edge cases
        if (null == dungeon || 0 == dungeon.length || 0 == dungeon[0].length) {
            return 0;
        }
        
        // start from bottom-right: ([m - 1, n - 1])
        // from bottom row to top row: (m-1, 0)
        // from right to left: (n - 1, 0)
        // every step: get the Math.max(right, down) right: row, col + 1; down: row + 1, col
        int[][] status = dungeon;
        int rowMax = dungeon.length - 1;
        int colMax = dungeon[0].length - 1;
        
        for (int row = rowMax; row >= 0; row --) {
            for (int col = colMax; col >= 0; col --) {
                //  only for the bottom-right case
                if (row == rowMax && col == colMax) {
                    continue;
                                       }
                int right = col + 1 <= colMax ? status[row][col + 1] : Integer.MIN_VALUE;
                int down = row + 1 <= rowMax ? status[row + 1][col] : Integer.MIN_VALUE;
                status[row][col] += Math.max(right, down);
            }
        }
        
        return status[0][0] <= 0 ? 0 - status[0][0] + 1 : 1; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] nums = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int min = calculateMinimumHP(nums);
	}

}
