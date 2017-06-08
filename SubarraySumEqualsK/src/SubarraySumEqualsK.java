import java.util.HashMap;
import java.util.Map;

/**
 * round 2: try method 2
 * 
 * round 1: idea: from brutal force -> to optimised method (always do things like this way)
 * method 1: O(n^2), 40m, 467ms, beat 10 %,  
 * use sum dp, for 2 ele, visit n - 1 element in sumDP, len = 3, n-2.. so total n^2
 * 1 4 2 5  -3
 * 1 5 7 12  9
 * when len = 2: 5, (7-1), (12-5),(9-7)
 * 
 * *** test case: [1] 1;
 * 
 * method 2: semi-solved 2 hours, sum dp + hashMap , I have the idea, I wanted to build sum dp fist, but it makes 
 * the things much complicated, should build mao when building sum dp(did not implement)
 * 
 * ref: https://discuss.leetcode.com/topic/87850/java-solution-presum-hashmap/2 
 * 
 * @author jingjiejiang
 * @history Jun 9, 2017
 */ 
public class SubarraySumEqualsK {

	// method 1: O(n^2)
	/*
	public int subarraySum(int[] nums, int k) {
        
        if (null == nums || 0 == nums.length) return 0;
        
        int[] dp = new int[nums.length];
        // *** test case: only 1 ele and == k
        dp[0] = nums[0];
        int count = dp[0] == k ? 1 : 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == k) count ++;
            dp[i] = nums[i] + dp[i - 1];
        }
        
        
        // i: length of the continuous array
        for (int i = 2; i <= nums.length; i ++) {
            // j: index in dp array
            for (int j = i - 1; j < dp.length; j ++) {
                if (j - i < 0) {
                   if (dp[j] == k) count ++;
                }
                else if (dp[j] - dp[j - i] == k) count ++;
            }
        }
        
        return count;
    }
	*/
	
	public static int subarraySum(int[] nums, int k) {
        
		if (null == nums || 0 == nums.length) return 0;
        
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        // for case: when sum - k = 0
        preSum.put(0, 1);
        
        // test case: [0,0,0,0,0] 0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
