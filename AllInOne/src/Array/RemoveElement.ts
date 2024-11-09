function removeElement(nums: number[], val: number): number {
  let resIdx = 0;

  for (const num of nums) {
    if (num !== val) {
      nums[resIdx++] = num;
    }
  }

  return resIdx;
}
