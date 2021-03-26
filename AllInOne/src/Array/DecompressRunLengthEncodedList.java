import java.util.Arrays;

/**
 * 
 * 1313. Decompress Run-Length Encoded List
 * 
 * @author jingjiejiang
 * @history Feb 27, 2021
 * 
 */
class Solution {
  public int[] decompressRLElist(int[] nums {
      
    assert nums != null && nums.length >= 2 && nums.length % 2 == 0;

    int resArrSize = 0;
    for (int idx = 0; idx < nums.length; idx += 2) {
      resArrSize += nums[idx];
    }

    int[] res = new int[resArrSize];

    int startIdx = 0;
    for (int idx = 0; idx < nums.length; idx += 2) {

      Arrays.fill(res, startIdx, startIdx + nums[idx], nums[idx + 1]);
      startIdx += nums[idx];
    }

    return res;
  }
}
