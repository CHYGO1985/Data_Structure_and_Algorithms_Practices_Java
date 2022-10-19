/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
 var divide = function(dividend, divisor) {
    
  const HALF_INT_MIN = - 1073741824;

  if (dividend === -Math.pow(2, 31) && divisor === -1) {
    return Math.pow(2, 31) - 1;
  }

  let negTimes = 2;
  if (dividend > 0) {
    negTimes --;
    dividend = - dividend;
  }

  if (divisor > 0) {
    negTimes --;
    divisor = - divisor;
  }

  let quotient = 0, maxDivisor = divisor, maxPowOfTwo = 1;
  while (maxDivisor >= HALF_INT_MIN && maxDivisor + maxDivisor >= dividend) {
    maxDivisor += maxDivisor;
    maxPowOfTwo += maxPowOfTwo;
  }

  while (dividend <= divisor) {
    if (dividend <= maxDivisor) {
      dividend -= maxDivisor;
      quotient += maxPowOfTwo; 
    }

    maxDivisor >>= 1;
    maxPowOfTwo >>= 1;
  }

  return negTimes == 1 ? - quotient : quotient;
};