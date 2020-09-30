/**
 * 
 * 239. Sliding Window Maximum
 * 
 * @author jingjiejiang
 * @history Sep 29, 2020
 * 
 */
class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
      
    int len = nums.length;
    if (len * k == 0) return new int[0];
    if (k == 1) return nums;

    int[] left = new int[len];
    left[0] = nums[0];

    int[] right = new int[len];
    right[len - 1] = nums[len - 1];

    for (int idx = 1; idx < len; idx ++) {

      if (idx % k == 0) left[idx] = nums[idx];
      else left[idx] = Math.max(left[idx - 1], nums[idx]);

      if ((len - 1 - idx + 1) % k == 0) right[len - 1 - idx] = nums[len - 1 - idx];
      else right[len - 1 - idx] = Math.max(right[len - 1 - idx + 1], nums[len - 1 - idx]);
    }

    int[] output = new int[len - k + 1];
    
    for (int idx = 0; idx < output.length; idx ++) {
      output[idx] = Math.max(left[idx + k - 1], right[idx]);
    }

    return output;
  }
}