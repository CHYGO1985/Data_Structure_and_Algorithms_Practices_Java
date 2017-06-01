import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * round 1: sort + backtracking (similar to 78. Subsets), 25m, one pass, 4ms beat 20%
 * 
 * @author jingjiejiang
 * @history Jun 1, 2017
 */
public class SubsetsII {
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new LinkedList<>();
        // res.add(new LinkedList<>(Arrays.asList("")));
        // if (null == nums || 0 == nums.length) return res;
        Arrays.sort(nums);
        getSubset(res, new LinkedList<Integer>(), nums, 0);
        
        return res;
    }
    
    private void getSubset(List<List<Integer>> res, List<Integer> curList, int[] nums, int begin) {
        // *** need to copy curList, otherwise the content of it will be changed in the for loop
        res.add(new LinkedList<>(curList));
        
        for (int i = begin; i < nums.length; i ++) {
            // *** stuck here, used only one succesful condition i > begin && nums[i] != nums[i - 1]
            if ((i > begin && nums[i] == nums[i - 1]) == false) {
                curList.add(nums[i]);
                getSubset(res, curList, nums, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
        
    }
}
