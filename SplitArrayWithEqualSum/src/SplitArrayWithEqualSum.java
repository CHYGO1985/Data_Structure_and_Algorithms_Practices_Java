import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * round 1: unsolved, 2 hosurs, O(n^2) solution, dp + two pointers tech
 * Method 1: *** hardest part: optimize from brutal force O(n^3) to O(n^2) (I did not know how to do it)
 * 1. use DP to build a sum array
 * 
 * ref: https://discuss.leetcode.com/category/704/split-array-with-equal-sum
 * 
 * @author jingjiejiang
 * @history Jun 8, 2017
 */ 
public class SplitArrayWithEqualSum {
	
	public boolean splitArray(int[] nums) {
        
        // the minimum length is 7
        if (null == nums || nums.length < 7) return false;
        
        int len = nums.length;
        // build dp sum array
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i ++) dp[i] += dp[i - 1] + nums[i];
        
        // find potential list of i, j, k
        for (int j = 3; j < len - 3; j ++) {
            HashSet < Integer > set = new HashSet < > ();
            // check whether i can split 0 - j into half, if so add the value into the array
            for (int i = 1; i < j - 1; i ++) {
                if (dp[i - 1] == dp[j - 1] - dp[i])
                    set.add(dp[i - 1]);
            }
            // check whether k can split j + 1 to len - 1 into half, and whether the value match the first cut
            for (int k = j + 2; k < len - 1; k ++) {
                if (dp[len - 1] - dp[k] == dp[k - 1] - dp[j] && set.contains(dp[k - 1] - dp[j]))
                    return true;
            }
        }
        
        return false;
    }
}
