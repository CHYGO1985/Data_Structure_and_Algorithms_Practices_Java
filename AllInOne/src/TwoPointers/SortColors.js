/**
 * 
 * 75. Sort Colors
 * 
 */
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    
  if (nums.length < 1 || nums.length > 300) return undefined;

  let p0 = 0, p2 = nums.length - 1, shift = 0;

  const swap = (left, right) => {
    let tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }

  while (shift <= p2) {
    if (nums[shift] === 0) {
      swap(shift ++, p0 ++);
    } else if (nums[shift] === 2) {
      swap(shift, p2 --);
    } else {
      shift ++;
    }
  }
};