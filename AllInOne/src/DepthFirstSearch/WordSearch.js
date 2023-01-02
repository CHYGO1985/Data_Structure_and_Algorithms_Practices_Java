/**
 * 79. Word Search
 */
/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    
  const dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]];
  const rowLen = board.length, colLen = board[0].length;

  if (rowLen === 0 || colLen === 0) return false; 
  const visited = [...Array(rowLen)].map(_ => Array(colLen).fill(false));   
  
  const hasWord = (row, col, charPos) => {
    if (charPos === word.length) return true;

    for (let dir = 0; dir < dirs.length; dir ++) {
      const nextRow = row + dirs[dir][0];
      const nextCol = col + dirs[dir][1];

      if (nextRow >= 0 && nextRow < board.length &&
        nextCol >= 0 && nextCol < board[0].length &&
        !visited[nextRow][nextCol] &&
        board[nextRow][nextCol] === word.charAt(charPos)) {

          visited[nextRow][nextCol] = true;
          if (hasWord(nextRow, nextCol, charPos + 1)) return true;
          visited[nextRow][nextCol] = false;
        }
    }

    return false;
  };

  for (let rowIdx = 0; rowIdx < rowLen; rowIdx ++) {
    for (let colIdx = 0; colIdx < colLen; colIdx ++) {
        
      if (board[rowIdx][colIdx] === word.charAt(0)) {        
        visited[rowIdx][colIdx] = true;
        if (hasWord(rowIdx, colIdx, 1)) return true;
        visited[rowIdx][colIdx] = false;
      }
    }
  }

  return false;
};