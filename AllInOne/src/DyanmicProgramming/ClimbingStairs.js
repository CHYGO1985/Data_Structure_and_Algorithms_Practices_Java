/**
 * 
 * 70. Climbing Stairs
 * 
 */
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    
  if (n < 1 || n > 45) return undefined;

  if (n <= 2) return n;

  let preTwo = 1, preOne = 2;
  let sum = 0;

  for (let cnt = 3; cnt <= n; cnt ++) {
    sum = preOne + preTwo;
    preTwo = preOne;
    preOne = sum;
  }

  return sum;
};