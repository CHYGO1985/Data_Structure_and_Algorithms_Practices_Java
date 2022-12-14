/**
 * 66. Plus One
 */
/**
 * @param {number[]} digits
 * @return {number[]}
 */
 var plusOne = function(digits) {
    if (digits.length < 1 && digits.length > 100) return undefined;

    for (let idx = digits.length - 1; idx >= 0; idx --) {
      digits[idx] ++;
      if (digits[idx] > 9) {
        digits[idx] = 0;
      } else {
        return digits;
      }
    }

    digits.unshift(1);
    return digits;
};