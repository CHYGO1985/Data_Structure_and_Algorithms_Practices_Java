package DFS;

/**
 * 
 * 79. Word Search
 * 
 * @author jingjiejiang
 * @history May 25, 2021
 * 
 */
public class WordSearch {
	
	// idea: method 1: DFS (with a two demensional array to record visiting status)
    
    // method 2: save extra space, DFS + (bit mask)
    // ref: https://discuss.leetcode.com/topic/7907/accepted-very-short-java-solution-no-additional-space
    // result: 7ms, beat 98.96%
    
    public boolean exist1(char[][] board, String word) {
        
        if (null == board || 0 == board.length || null == word || 0 == word.length()) {
        
            return false;
        }
        
        char[] wordArr = word.toCharArray();
        boolean res = false;
        
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
                
                if (board[i][j] == wordArr[0]) {
                    res = checkWordVal(board, wordArr, i, j, 0);
                    if (true == res) {
                        return res;
                    }
                }
            }
        }
        
        return res;
    }
    
    
    public boolean checkWordVal (char[][] board, char[] wordArr, int row, int col, int checkLen) {
            
        if (checkLen >= wordArr.length) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 
                || col >= board[0].length) {
            return false;
        }
        
        if (board[row][col] != wordArr[checkLen]) {
            return false;
        }
        
        // mark current point as visited
        board[row][col] ^= 256;
        
        boolean res = checkWordVal(board, wordArr, row, col - 1, checkLen + 1)
                        || checkWordVal(board, wordArr, row, col + 1, checkLen + 1)
                        || checkWordVal(board, wordArr, row - 1, col, checkLen + 1)
                        || checkWordVal(board, wordArr, row + 1, col, checkLen + 1);
        
        // if current route does not contian a match, than change the status of current point as unvisited
        board[row][col] ^= 256;
        
        return res;
    }

    private static int[][] dirs = new int[][]{{0, 1}, {0, - 1}, {1, 0}, {- 1, 0}};

    public boolean exist(char[][] board, String word) {
        
        assert board != null & word != null && word.length() >= 1;
        
        int rowLen = board.length, colLen = board[0].length;

        if (rowLen == 0 || colLen == 0) return false;
        
        for (int rowIdx = 0; rowIdx < rowLen; rowIdx ++) {
            for (int colIdx = 0; colIdx < colLen; colIdx ++) {

                if ( board[rowIdx][colIdx] == word.charAt(0) ) {
                    // the visited array must be reset before every DFS, so must put outside
                    // the current visited status must be recorded as well
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[rowIdx][colIdx] = true;
                    if (hasWord(board, visited, word, rowIdx, colIdx, 1)) return true;
                }
            }
        }

        return false;
    }

    // dfs design 3 key elements:
    // 1) quitting condition:  if (charPos == word.length()) return true;
    // 2) back tracking variable: visited[nextRow][nextCol]
    // 3) the loop condition: for (int dir = 0; dir < dirs.length; dir ++)
    private boolean hasWord(char[][] board, boolean[][] visited, String word, int row, int col, int charPos) {

        // quitting condition
        if (charPos == word.length()) return true;

        // the loop condition
        for (int dir = 0; dir < dirs.length; dir ++) {

            int nextRow = row + dirs[dir][0];
            int nextCol = col + dirs[dir][1];
            if (nextRow >= 0 && nextRow < board.length &&
                nextCol >= 0 && nextCol < board[0].length &&
                !visited[nextRow][nextCol] &&
                board[nextRow][nextCol] == word.charAt(charPos)) {

                // back tracking variable
                visited[nextRow][nextCol] = true;
                if (hasWord(board, visited, word, nextRow, nextCol, charPos + 1)) return true;
                visited[nextRow][nextCol] = false;
            }
        }

        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
