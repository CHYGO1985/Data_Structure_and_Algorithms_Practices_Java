/**
 * 
 * 53. Maximum Subarray
 *
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var maxSubArray = function(nums) {
    if (!nums || nums.length === 0) return 0;

    let max = Number.MAX_SAFE_INTEGER;
    let curSum = 0;

    for (let idx = 0; idx < nums.length; idx ++) {
      curSum += nums[idx];
      max = Math.max(curSum, max);
      curSum = curSum < 0 ? 0 : curSum;
    }

    return max;
};