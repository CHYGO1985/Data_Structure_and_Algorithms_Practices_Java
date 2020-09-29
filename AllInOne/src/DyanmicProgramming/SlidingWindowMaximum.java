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
  }
}