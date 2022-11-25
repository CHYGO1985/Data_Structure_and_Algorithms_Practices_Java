/**
 *
 * 50. Pow(x, n)
 * 
 * @history Nov 25, 2022
 */
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
 var myPow = function(x, n) {
    
  if (n === 0) return 1;

  let pow = Math.abs(n);

  const res = pow % 2 === 0 ? myPow(x * x, pow / 2) : pow(x * x, (pow - 1) / 2) * x;
  
  return n < 0 ? 1 / res : res;
};