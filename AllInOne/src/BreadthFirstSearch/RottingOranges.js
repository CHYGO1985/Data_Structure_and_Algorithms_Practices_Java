/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function (grid) {
  let queue = [],
    oranges = 0,
    time = 0;

  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      if (grid[row][col] === 1) {
        oranges++;
        continue;
      }

      if (grid[row][col] === 2) queue.push([row, col, 0]);
    }
  }

  const dirs = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  const endRow = grid.length - 1;
  const endCol = grid[0].length - 1;

  while (queue.length && oranges) {
    const [curRow, curCol, mins] = queue.shift();

    if (grid[curRow][curCol] === 1) {
      grid[curRow][curCol] = 2;
      oranges--;
      time = mins;
    }

    for (let [addRow, addCol] of dirs) {
      const [newRow, newCol] = [curRow + addRow, curCol + addCol];
      if (newRow < 0 || newRow > endRow || newCol < 0 || newCol > endCol)
        continue;
      if (grid[newRow][newCol] === 1) queue.push([newRow, newCol, mins + 1]);
    }
  }

  return oranges ? -1 : time;
};
