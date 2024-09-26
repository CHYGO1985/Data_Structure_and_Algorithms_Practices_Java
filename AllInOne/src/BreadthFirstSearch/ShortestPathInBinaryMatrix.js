/**
 * 1091. Shortest Path in Binary Matrix
 */
/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function (grid) {
  const directions = [
    [1, 0],
    [-1, 0],
    [0, 1],
    [0, -1],
    [1, 1],
    [1, -1],
    [-1, 1],
    [-1, -1],
  ];

  if (grid[0][0] === 1) return -1;

  const N = grid.length;
  const queue = [[0, 0, 1]];

  while (queue.length) {
    const [row, col, path] = queue.shift();

    if (row === N - 1 && col === N - 1) return path;

    for (const [dx, dy] of directions) {
      let newRow = row + dx;
      let newCol = col + dy;

      if (newRow < 0 || newRow >= N) continue;
      if (newCol < 0 || newCol >= N) continue;
      if (grid[newRow][newCol] !== 0) continue;

      // add new path to the queue
      queue.push([newRow, newCol, path + 1]);
      // mark as visited
      grid[newRow][newCol] = 1;
    }
  }

  return -1;
};
