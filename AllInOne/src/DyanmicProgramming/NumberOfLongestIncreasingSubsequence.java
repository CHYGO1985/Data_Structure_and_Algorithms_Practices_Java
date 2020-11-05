import java.util.Arrays;

/**
 * 
 * 673. Number of Longest Increasing Subsequence
 * 
 * @author jingjiejiang
 * @history Oct 30, 2020 
 * 
 * ref: https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC%2B%2B-Simple-dp-solution-with-explanation
 * I do not know how to update cnt and maxCnt
 * 
 * The meaning of cnt array:
 * nums: [1,3,5,4]
 * len:  [1,2,3,3]
 * cnt:  [1,1,1,1]
 * 
 * 
 * nums: [1,3,5,4,7]
 * len:  [1,2,3,3,4]
 * cnt:  [1,1,1,1,2]
 * 
 */
class Solution {
  public int findNumberOfLIS(int[] nums) {
    
    if (nums == null || nums.length == 0) return 0;

    int n = nums.length, res = 0, max_len = 0;
    int[] len = new int[n], cnt = new int[n];
    
    for(int i = 0; i < n; i ++){
        len[i] = cnt[i] = 1;
        for(int j = 0; j < i; j ++){
          if(nums[i] > nums[j]) {
            // for example, 1 3 1 2, when j = 2nd 1, and i = 2,
            if(len[i] == len[j] + 1) {
              cnt[i] += cnt[j];
            } else if(len[i] < len[j] + 1) { // 1 2 3 4, then len will be updated
                len[i] = len[j] + 1;
                cnt[i] = cnt[j];
            }
          }
        }
        // for example, 1 3 2 4, when j = 2. i = 4, res += cnt[i] 
        // also works for 2 2 2 
        if(max_len == len[i]) {
          res += cnt[i];
        } else if(max_len < len[i]) {
          max_len = len[i];
          res = cnt[i];
        }
    }
    
    return res;
  }
}

// 2 2 2 2
// 3 2 1
// 1 1 3
// 1 2 5 4 9