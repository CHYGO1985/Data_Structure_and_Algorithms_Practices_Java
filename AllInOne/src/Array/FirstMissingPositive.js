/**
 * 41. First Missing Positive
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var firstMissingPositive = function(nums) {
    
  if (!nums || nums.length < 1) return undefined;

  let idx = 0;

  const swap = (nums, left, right) => {
    const tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  };

  while (idx < nums.length) {

    if (nums[idx] == idx + 1 || nums[idx] <= 0 || nums[idx] > nums.length) {
      idx ++;
    } else if (nums[nums[idx] - 1] != nums[idx]) {
      swap(nums, idx, nums[idx] - 1);
    } else {
      idx ++;
    }
  }

  idx = 0;

  while (idx < nums.length && nums[idx] == idx + 1) {
    idx ++;
  }

  return idx + 1;
};