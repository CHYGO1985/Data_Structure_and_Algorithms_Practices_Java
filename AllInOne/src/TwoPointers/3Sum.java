/**
 * 
 * 15. 3Sum
 * 
 * @author jingjiejiang
 * @history Mar 2, 2021
 * 
 */
public class 3Sum {
    public List<List<Integer>> threeSum1(int[] nums) {
        
      assert nums != null;

      Arrays.sort(nums);

      // three pointers: idx, left (idx + 1) and right (nums.len - 1)
      List<List<Integer>> resList = new ArrayList<>();
      if (nums.length == 0) return resList;

      for (int idx = 0; idx < nums.length - 2 && nums[idx] <= 0; idx ++) {

        if (idx > 0 && nums[idx - 1] == nums[idx]) continue;

        int left = idx + 1, right = nums.length - 1;
        int sum = 0;
        while (left < right) {
          sum = nums[idx] + nums[left] + nums[right];

          if (sum > 0) {
            right --;
          } else if (sum < 0) {
            left ++;
          } else {
            resList.add(Arrays.asList(nums[idx], nums[left ++ ], nums[right --]));
            while (left < right && nums[left] == nums[left - 1]) {
              left ++; // skip repeat result
            }
          }
        }
      }

      return resList;
    }
}
