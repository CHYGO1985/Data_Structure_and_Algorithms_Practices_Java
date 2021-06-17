import java.util.LinkedList;
import java.util.List;

/**
 * round 1: solved, recursive method (backtracking)，30m, one pass, 3ms, beat 11.60%
 * 1. parameter: startpoint and num of digits needed
 * 
 * *** Java: initialise a list with values : List<String> x = new ArrayList<>(Arrays.asList("xyz", "abc"));
 * ref: https://stackoverflow.com/questions/21696784/how-to-declare-an-arraylist-with-values
 * 
 * @author jingjiejiang
 * @history Jun 1, 2017
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<Integer>());
        if (null == nums || 0 == nums.length) return res;
        
        for (int len = 1; len <= nums.length; len ++)
            getSubset(res, new LinkedList<Integer>(), nums, 0, len);
            
        return res; 
    }
    
    private void getSubset(List<List<Integer>> res, List<Integer> curList, int[] nums, int startIndex, int length) {
        if (0 == length) {
            res.add(curList);
            return ;
        }
        
        for(int i = startIndex; i < nums.length; i ++) {
            // *** copy the original content to a new list to avoid status changed by next call
            List<Integer> tmpList = new LinkedList<>(curList);
            tmpList.add(nums[i]);
            getSubset(res, tmpList, nums, i + 1, length - 1);
        }
    }
    
    /*
    // method 2 without using length
    // ref: https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
    }
    */
}
