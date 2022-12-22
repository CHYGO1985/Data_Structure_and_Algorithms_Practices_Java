package src.Backtracking;

import java.util.List;
import java.util.LinkedList;

/**
 * 78. Subsets
 */
public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
        
    assert nums.length >= 1 && nums.length <= 10;

    List<List<Integer>> res = new LinkedList<>();
    getSubset(res, new LinkedList<>(), nums, 0);

    return res;
}

private void getSubset(List<List<Integer>> res, List<Integer> curList, int[] nums, int begin) {
    res.add(new LinkedList<>(curList));

    for (int idx = begin; idx < nums.length; idx ++) {
        curList.add(nums[idx]);
        getSubset(res, curList, nums, idx + 1);
        curList.remove(curList.size() - 1);
    }
}
}
