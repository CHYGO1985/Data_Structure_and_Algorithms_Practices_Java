import java.util.Arrays;

import javax.management.MXBean;

/**
 * 
 * 673. Number of Longest Increasing Subsequence
 * 
 * @author jingjiejiang
 * @history Oct 30, 2020 
 * 
 * [3, 2, 1]
 * 
 */
class Solution {
  public int findNumberOfLIS(int[] nums) {
    
    if (nums == null || nums.length == 0) return 0;

    // dp array to store increasing seq max lenths until i
    int[] lens = new int[nums.length];
    int[] cnts = new int[nums.length];
    // init all ele as 1, (in case for 2 3 4 1). 1's len is 1
    Arrays.fill(lens, 1);
    Arrays.fill(cnts, 1);
    int maxLen = 1, maxCount = 1;
    
    for (int right = 1; right < nums.length; right ++) {
      for (int shift = 0; shift < right; shift ++) {

        if (nums[shift] >= nums[right] && maxLen == 1) {
          
          cnts[right] = cnts[shift] + 1;
          maxCount = Math.max(maxCount, cnts[right]);
        } else { // nums[shift] < nums[right]

          lens[right] = Math.max(lens[right], lens[shift] + 1);
          
          if (lens[right] > maxLen) {
            maxLen = lens[right];
            maxCount = 1;
            cnts[right] = 1;
          } else if (lens[right] == maxLen) {
            cnts[right] += cnts[shift];
            maxCount ++;
          } else { // lens[right] < maxLen
            continue;
          }
        }
      }
    }

    return maxCount; 
  }
}

// 2 2 2 2
// 3 2 1
// 1 1 3
// 1 2 5 4 9