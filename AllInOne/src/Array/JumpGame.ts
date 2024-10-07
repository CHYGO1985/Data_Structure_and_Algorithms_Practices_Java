/**
 * 55. Jump Game 1
 */
function canJump(nums: number[]): boolean {
  if (!nums) return false;

  let far = 0;

  for (let idx = 0; idx < nums.length && idx <= far; idx++) {
    far = Math.max(far, idx + nums[idx]);
  }

  return far >= nums.length - 1 ? true : false;
}
