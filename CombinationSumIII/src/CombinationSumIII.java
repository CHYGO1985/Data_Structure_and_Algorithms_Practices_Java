import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * round 1: 15m, dfs (backtracking), 2ms
 * 
 * @author jingjiejiang
 * @history Jun 10,2017
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> list = new LinkedList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        dfs(list, new LinkedList<Integer>(), nums, n, 0, k);
        
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> curList, int[] nums, int target, int begin, int times) {
        
        if (target == 0 && times == 0) {
            list.add(new ArrayList<Integer>(curList));
            return;
        }
        if (times <= 0 || begin >= nums.length || target < nums[begin]) return;
        
        for (int i = begin; i < nums.length; i ++) {
            curList.add(nums[i]);
            times --;
            dfs(list, curList, nums, target - nums[i], i + 1, times);
            times ++;
            curList.remove(curList.size() - 1);
        }
    }
}
