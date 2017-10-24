import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 47. Permutations II
 * 
 * round 3: solved (condition) false == isValid[i - 1]
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 24, 2017
 */
public class PermutationsII {
	// Idea: I figure out the solution, but do not know how write the recursive method
	// ref: https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        
        // round 2:solved, find the crucial condition
        // (i > 0 && nums[i] == nums[i - 1] && false == isValid[i - 1])
        
        // idea: Method 1: sort + recursive(DFS)
        // result: 11ms, beat 33%
        
        // method 2:  (consider the permutation as swapping) recursive swap, O(1) extra space
        // ref: http://blog.csdn.net/xx77009833/article/details/17843415
        
        
       List<List<Integer>> list = new LinkedList<List<Integer>>();
       if (null == nums || 0 == nums.length) {
           return list;
       }
       
       boolean[] isValid = new boolean[nums.length];
       for (int i = 0; i < isValid.length; i ++) {
           isValid[i] = false;
       }
       
       Arrays.sort(nums);
       permuteHelper(list, new LinkedList<Integer>(), nums, isValid);
       
       return list;
    }
    
    public void permuteHelper(List<List<Integer>> list, List<Integer> curList, int nums[], boolean[] isValid) {
        
        if (curList.size() >= nums.length) {
            list.add(new LinkedList<Integer>(curList));
        }
        else {
            for (int i = 0; i < nums.length; i ++) {
                
                if (true == isValid[i]) {
                    continue ;
                }
                
                // *** the codition isValid[i - 1] here is vital, e.g. [1, 1, 2], when the loop goes to the second 1,
                // to avoid duplication of the permute of start 1, the second 1 will be skiped by this condition.
                // the first visit of duplication 1 1 , isValid[i - 1] == true
                if (i > 0 && nums[i] == nums[i - 1] && false == isValid[i - 1]) {
                    continue ;
                }
                
                curList.add(nums[i]);
                isValid[i] = true;
                permuteHelper(list, curList, nums, isValid);
                curList.remove(curList.size() - 1);
                isValid[i] = false;
            }
        }
    }

}
