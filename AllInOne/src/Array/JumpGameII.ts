/**
 * 45. Jump Game II
 */
function jump(nums: number[]): number {
  let curFarest = 0,
    stepCnt = 0,
    curEnd = 0;

  for (let idx = 0; idx < nums.length - 1; idx++) {
    curFarest = Math.max(curFarest, idx + nums[idx]);
    if (idx === curEnd) {
      curEnd = curFarest;
      stepCnt++;
    }
  }

  return stepCnt;
}
