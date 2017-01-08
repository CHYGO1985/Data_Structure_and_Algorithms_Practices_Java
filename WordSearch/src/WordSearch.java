
public class WordSearch {
	
	// idea: method 1: DFS (with a two demensional array to record visiting status)
    
    // method 2: save extra space, DFS + (bit mask)
    // ref: https://discuss.leetcode.com/topic/7907/accepted-very-short-java-solution-no-additional-space
    // result: 7ms, beat 98.96%
    
    public boolean exist(char[][] board, String word) {
        
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
