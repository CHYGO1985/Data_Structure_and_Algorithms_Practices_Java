import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 1512. Number of Good Pairs
 * 
 * @author jingjiejiang
 * @history Dec 12, 2020
 * 
 */
class Solution {
  public int numIdenticalPairs(int[] nums) {
      
      assert nums != null && nums.length >= 1;

      // num : cnt
      Map<Integer, Integer> numCntMap = new HashMap<>();
      int res = 0;

      for (int num : nums) {
        
        int preCnt = numCntMap.getOrDefault(num, 0);
        if (preCnt > 0) {
          res += preCnt;
        }

        numCntMap.put(num, preCnt + 1);
      }

      return res;
  }
}
