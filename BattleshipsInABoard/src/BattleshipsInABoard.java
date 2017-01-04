public class BattleshipsInABoard {

	public static int countBattleships(char[][] board) {
        // Method 1: traditional: DFS / BFS
        // ref: http://www.cnblogs.com/grandyang/p/5979207.html
        // notice the use of vertical and horizontal to check availability
        
        
        // Method 2: use status check
        // ref: https://discuss.leetcode.com/topic/62970/simple-java-solution
        // result: 4ms, 55.46%, beat 35.64%
        int rowLen = board.length;
        if (0 == rowLen) {
            return 0;
        }
        int colLen = board[0].length;
        int count = 0;
        
        for (int i = 0; i < rowLen; i ++) {
            for (int j = 0; j < colLen; j ++) {
                
                if ('.' == board[i][j]) {
                    continue ;
                }
                
                if ( (i > 0 && 'X' == board[i - 1][j])
                    || (j > 0 && 'X' == board[i][j - 1]) ) {
                    continue;
                }
                
                count ++;
                   
            }
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
