
public class OptimalDivision {

	public String optimalDivision(int[] nums) {
        // round 1: unsolved. 1.5 hours
        // oberservation: the solution is really simple, according the regulation of division
        // ref:  https://discuss.leetcode.com/topic/86475/simple-java-solution/2
        
        String res = "";
        if (null == nums || nums.length == 0) return res;
        if (nums.length == 1) return res + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        
        res += nums[0] + "/" + "(" + nums[1];
        for (int i = 2; i < nums.length; i ++) {
            res += "/" + nums[i];
        }
        
        return res + ")";
    }
}
