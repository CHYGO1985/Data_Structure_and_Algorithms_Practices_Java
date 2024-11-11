function removeDuplicates(nums: number[]): number {
  let insertIdx: number = 1;

  for (let idx = 1; idx < nums.length; idx++) {
    if (nums[idx - 1] !== nums[idx]) {
      nums[insertIdx++] = nums[idx];
    }
  }

  return insertIdx;
}
