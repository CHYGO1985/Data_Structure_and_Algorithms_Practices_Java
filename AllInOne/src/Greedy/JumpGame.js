/**
 * @param {number[]} nums
 * @return {boolean}
 */
 var canJump = function(nums) {
    
  if (!nums) return undefined;

  let far = 0;

  for (let idx = 0; idx < nums.length && idx <= far; idx ++) {
    far = Math.max(far, idx + nums[idx]);
  }

  return far >= nums.length - 1;
};