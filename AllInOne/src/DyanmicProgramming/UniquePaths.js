/**
 * 
 * 62. Unique Paths
 */
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
 var uniquePaths = function(m, n) {
    
  const prevRow = new Array(n).fill(1);

  for (let row = 1; row < m; row ++) {
    for (let col = 1; col < n; col ++) {
      prevRow[col] += prevRow[col - 1];
    }
  }

  return prevRow[n - 1];
};