function majorityElement(nums: number[]): number {
  const countMap: Map<number, number> = new Map();

  for (let num of nums) {
    if (!countMap.has(num)) {
      countMap.set(num, 0);
    }

    const curCount: number = countMap.get(num)!;
    if (curCount + 1 > nums.length / 2) {
      return num;
    }
    countMap.set(num, curCount + 1);
  }

  return -1;
}
