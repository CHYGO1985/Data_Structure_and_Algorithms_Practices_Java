/**
 * 
 * 36. Valid Sudoku
 * 
 * @history Oct 22, 2022
 */
/**
 * @param {character[][]} board
 * @return {boolean}
 */
 var isValidSudoku = function(board) {
    const N = 9;
    let rows = new Array(N);
    let cols = new Array(N);
    let boxes = new Array(N);

    for (let row = 0; row < N; row ++) {
      for (let col = 0; col < N; col ++) {
        if (board[row][col] === '.') {
          continue;
        }

        const val = board[row][col] - '0';
        const pos = 1 << (val - 1);

        if ((rows[row] & pos) > 0) {
          return false;
        }

        rows[row] |= pos;

        if ((cols[col] & pos) > 0) {
          return false;
        }

        cols[col] |= pos;

        const idx = parseInt(row / 3) * 3 + parseInt(col / 3);
        if ((boxes[idx] & pos) > 0) {
          return false;
        }

        boxes[idx] |= pos;
      }
    }

    return true;
};