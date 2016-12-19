
public class DesignTicTacToe {

	// idea: bettern than O(n^2), use space to exchange for time
    // from insert point check, x, y and two diagonal directions 
    // result: 103ms, beat 84.97%, 86 is the fastest in the db.

    private char[][] board;
    private int n;
    
    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        
        this.n = n;
        board = new char[n][n];
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = 'm';
            }
        }
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        int leftHalf = 0;
        int rightHalf = 0;
        boolean isConnect = true;
        int tempCol = col; 
        int tempRow = row;
        
        // check the vailabilty of row and col if the question does not guarantee the validity of row and col
        
        char checker = ' ';
        if (1 == player) {
            checker = 'X';
        }
        else if (2 == player) {
            checker = '0';
        }
        else {
            // invalid player number
            return 0;
        }
        
        board[row][col] = checker;
        
        // check horizontal direction, check whether left (player value) + right (player value) == n
        // continuous value: pre val = player
        while (tempCol > 0 && true == isConnect) {
            
            tempCol--;
            
            if (board[row][tempCol] == checker) {
                leftHalf ++;
            }
            else {
                isConnect = false;
            }
        }
        
        isConnect = true;
        tempCol = col;
        
        while ( (tempCol < n - 1) && true == isConnect) {
            
            tempCol ++;
            
            if (board[row][tempCol] == checker) {
                rightHalf ++;
            }
            else {
                isConnect = false;
            }
        }
        
        if (leftHalf + rightHalf + 1 == n) {
            
            return player;
        }
            
        leftHalf = 0;
        rightHalf = 0;
        isConnect = true;
        tempCol = col;
        
        // check vertical direction
        while (tempRow > 0 && true == isConnect) {
            
            tempRow --;
            
            if (board[tempRow][col] == checker) {
                leftHalf ++;
            }
            else {
                isConnect = false;
            }
        }
        
        tempRow = row;
        isConnect = true;
        
        while (tempRow < n - 1 && true == isConnect) {
            
            tempRow ++;
            
            if (board[tempRow][col] == checker) {
                rightHalf ++;
            }
            else {
                isConnect = false;
            }
        }
        
        
        if (leftHalf + rightHalf + 1 == n) {
            return player;
        }
        
        leftHalf = 0;
        rightHalf = 0;
        isConnect = true;
        tempRow = row;
    
        // check diagonal direction
        // 1) diagonal:from northwest (row - 1)(col - 1) to southest (row + 1)(col + 1)
        
        while ( (tempRow > 0) && (tempCol > 0) && true == isConnect ) {
            
            tempRow --;
            tempCol --;
            if (board[tempRow][tempCol] == checker) {
                leftHalf ++;
            }
            else {
                isConnect = false;
            }
        }
        
        tempRow = row;
        tempCol = col;
        isConnect = true;
        
        while ( (tempRow < n - 1) && (tempCol < n - 1) && true == isConnect ) {
            
            tempRow ++;
            tempCol ++;
            if (board[tempRow][tempCol] == checker) {
                rightHalf ++;
            }
            else {
                isConnect = false;
            }
            
        }
        
        if (leftHalf + rightHalf + 1 == n) {
            return player;
        }
        
        leftHalf = 0;
        rightHalf = 0;
        isConnect = true;
        tempRow = row;
        tempCol = col;
        
        // 2) diagonal: from northeast(row + 1)(col - 1) to southwest (row - 1)(col + 1)
        
        while ( (tempRow < n - 1) && (tempCol > 0) && true == isConnect ) {
            
            tempRow ++;
            tempCol --;
            if (board[tempRow][tempCol] == checker) {
                leftHalf ++;
            }
            else {
                isConnect = false;
            }
        }
        
        tempRow = row;
        tempCol = col;
        isConnect = true;
        
        while ( (tempRow > 0) && (tempCol < n - 1) && true == isConnect ) {
            
            tempRow --;
            tempCol ++;
            if (board[tempRow][tempCol] == checker) {
                rightHalf ++;
            }
            else {
                isConnect = false;
            }
        }
        
        if (leftHalf + rightHalf + 1 == n) {
            return player;
        }
        
        return 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
