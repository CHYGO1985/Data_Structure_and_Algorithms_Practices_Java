/**
 * 69. Sqrt(x)
 */
/**
 * @param {number} x
 * @return {number}
 */
 var mySqrt = function(x) {
    
  let left = 0, right = x;

  while (left <= right) {
    const mid = left + Math.floor((right - left) / 2);
    const product = mid * mid;

    if (product > x) {
      right = mid - 1;
    } else if (product < x) {
      left = mid + 1;
    } else {
      return mid; 
    }
  }

  return right;
};