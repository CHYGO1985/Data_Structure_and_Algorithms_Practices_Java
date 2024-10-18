/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 */
function minDifference(nums: number[]): number {
  if (!nums || nums.length === 0) return undefined;
  if (nums.length <= 4) return 0;

  nums.sort((a: number, b: number) => a - b);
  let min = Number.MAX_SAFE_INTEGER;

  for (
    let left = 0, right = nums.length - 4;
    left < 4 && right < nums.length;
    left++, right++
  ) {
    min = Math.min(min, nums[right] - nums[left]);
  }

  return min;
}
