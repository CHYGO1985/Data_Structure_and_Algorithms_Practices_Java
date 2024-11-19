function removeDuplicates(nums: number[]): number {
  let cnt = 0;
  let shiftIdx = 1;

  for (let idx = 1; idx < nums.length; idx++) {
    if (nums[idx] !== nums[idx - 1]) {
      cnt = 0;
      nums[shiftIdx++] = nums[idx];
    } else {
      if (cnt === 0) {
        nums[shiftIdx++] = nums[idx];
      }
      cnt++;
    }
  }

  return shiftIdx;
}
