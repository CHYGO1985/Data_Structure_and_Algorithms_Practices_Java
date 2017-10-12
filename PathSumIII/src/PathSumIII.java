import java.util.HashMap;


/**
 * 
 * 437. Path Sum III
 * 
 * round 1: unsolved (for O(n) solution), 2 hours
 * idea: brutal force is easy, i did not go for it
 * ref: // brutal force recursive; https://discuss.leetcode.com/topic/64461/simple-java-dfs/2
 * 
 * i was thinking to use hash to try the match sum, but stuck on getting rid of previous data
 * 1 2 4 target: 6
 * 1 3 7 
 * i wanted to use sum to match target, however, i don't know how to check 2 4 in a efficient way.
 * 
 * *** the solution is easy, use deduction, 7 - 6(target) = 1, and 1 is in the array, so there is
 * a match.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 12, 2017
 */
public class PathSumIII {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        // when the all the children of the current node have been visited, delete it from the hashmap
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
