package src.Array;

import java.util.Arrays;
/**
 * 
 * 453. Minimum Moves to Equal Array Elements
 * 
 * @author jingjiejiang
 * @history Apr 27, 2022
 * 
 */
public class MinMovesToEqualArrayEle {
  public int minMoves(int[] nums) {

    assert nums != null && nums.length >= 1;

    Arrays.sort(nums);
    int count = 0;

    for (int idx = nums.length - 1; idx > 0; idx --) {
      count += nums[idx] - nums[0];
    }

    return count;
  }
}
