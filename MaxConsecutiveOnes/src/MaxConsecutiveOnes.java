
public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        // round 1: consider multiple cases [0], [1]
        // beat 96%
        if (null == nums || 0 == nums.length)
            return 0;
            
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i ++) {
            
            if (nums[i] == 1) {
                count ++;
            }
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        
        return Math.max(max, count);
    }
}
