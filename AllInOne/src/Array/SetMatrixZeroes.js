/**
 * 
 * 73. Set Matrix Zeroes
 * 
 */
/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    
  if (matrix.length < 1 || matrix[0].length > 200) return undefined;

  let isFstColZeor = false;
  
  for (let rowIdx = 0; rowIdx < matrix.length; rowIdx ++) {
    if (matrix[rowIdx][0] === 0) {
      isFstColZeor = true;
    }

    for (let colIdx = 1; colIdx < matrix[0].length; colIdx ++) {
      if (matrix[rowIdx][colIdx] === 0) {
        matrix[rowIdx][0] = 0;
        matrix[0][colIdx] = 0;
      }
    }
  }

  for (let rowIdx = 1; rowIdx < matrix.length; rowIdx ++) {
    for (let colIdx = 1; colIdx < matrix[0].length; colIdx ++) {
      if (matrix[rowIdx][0] === 0 || matrix[0][colIdx] === 0) {
        matrix[rowIdx][colIdx] = 0;
      }
    }
  }

  if (matrix[0][0] === 0) {
    for (let colIdx = 1; colIdx < matrix[0].length; colIdx ++) {
      matrix[0][colIdx] = 0;
    }
  }

  if (isFstColZeor === true) {
    for (let rowIdx = 0; rowIdx < matrix.length; rowIdx ++) {
      matrix[rowIdx][0] = 0;
    }
  }
};