package src.Bit_Manipuation;

/**
 * 
 * 36. Valid Sudoku
 * 
 * @history Oct 22, 2022
 * 
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
        
    int N = 9;
    int[] rows = new int[N];
    int[] cols = new int[N];
    int[] boxes = new int[N];
    
    for (int row = 0; row < N; row ++) {
      for (int col = 0; col < N; col ++) {
        if (board[row][col] == '.') {
          continue;
        }

        int val = board[row][col] - '0';
        int pos = 1 << (val - 1);

        if ((rows[row] & pos) > 0) {
          return false;
        }

        rows[row] |= pos;
        
        if ((cols[col] & pos) > 0) {
          return false;
        }

        cols[col] |= pos;

        int boxIdx = (row / 3) * 3 + col / 3;
        if ((boxes[boxIdx] & pos) > 0) {
          return false;
        }

        boxes[boxIdx] |= pos;
      }
    }

    return true;
  }
}
