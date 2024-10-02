/**
 * 179. Largest Number
 */
/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function (nums) {
  // it sorts (num.sort) all the numbers with a given sorter (function (a, b))
  // it concatenates (.join) all sorted numbers
  // it removes leading extra '0' if any (replace)
  // if the concatenated string is empty, return '0' instead
  return (
    nums
      .sort((a, b) => b + '' + a - (a + '' + b))
      .join('')
      .replace(/^0*/, '') || '0'
  );
};
