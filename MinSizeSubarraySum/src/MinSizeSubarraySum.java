/**
 * round 1: solved, two pointers technique (<= is not suitable for hashtable"exact match"), 1.5 hours, 4ms, beat 16%
 * improved to 3ms, beat 27%
 * 
 * 1.idea: from brutal force to solution O(n)
 * 1.idea: from brutal force to solution O(n)
 * 1) oberserve the process of brutal force (builder sum array, iterate from length 2 , 3 to n, find it sum >= s)
 * 2) the process in essence is to check the distance from s, so build a sum array
 * 3) when a sum is bigger than s, update sum[i] by minus nums[preindex], until sum[i] < s, update min
 * 4) continue to build sum array, until sum[i'] >= s again, start from preindex, reduce the sum[i'], update min again
 * 
 *  2 3 1 3         3        4
 *  2 5 1 9(pre=0)
 *        7(pre=1)  
 *        4(pre=2)  7
 *                  6(pre=3) 10
 *                            7(pre=4)
 *                            4(pre=5)
 *                            min = 5 - (pre - 1) + 1 = 5 - pre + 2
 * 
 * @author jingjiejiang
 * @history Jun 10, 2017
 */
public class MinSizeSubarraySum {
	
	// method 1: 3ms, beat 27%
	/*
	public int minSubArrayLen(int s, int[] nums) {
        
        // special case
        if (null == nums || 0 == nums.length) return 0;
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int min = Integer.MAX_VALUE;
        if (nums[0] >= s) return 1;
        int preIndex = 0;
        for (int i = 1; i < nums.length; i ++) {
            // if (nums[i] >= s) return 1;
            sum[i] = nums[i] + sum[i - 1];
            while (sum[i] >= s && preIndex < nums.length - 1) {
                min = Math.min(i - preIndex + 1, min);
                sum[i] -= nums[preIndex];
                preIndex ++;
            }
            // improve from 4ms to 3ms
            if (min == 1) break;
        }
        
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
    */
	
	// method 1.1: refactoring, only update min after while loop
	public int minSubArrayLen(int s, int[] nums) {
        
        // special case
        if (null == nums || 0 == nums.length) return 0;
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int min = Integer.MAX_VALUE;
        if (nums[0] >= s) return 1;
        int preIndex = 0;
        for (int i = 1; i < nums.length; i ++) {
            // if (nums[i] >= s) return 1;
            sum[i] = nums[i] + sum[i - 1];
            if (sum[i] >= s) {
                while (sum[i] >= s && preIndex < nums.length - 1) {
                    
                    sum[i] -= nums[preIndex];
                    preIndex ++;
                }
                // improve from 4ms to 3ms
                min = Math.min(i - preIndex + 2, min);
                if (min == 1) break;
            }
        }
        
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
