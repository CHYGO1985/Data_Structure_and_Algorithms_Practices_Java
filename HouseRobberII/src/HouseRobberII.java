
public class HouseRobberII {
	
	public static int rob(int[] nums) {
        // idea: from house robber --> still using DP
        // 1) sovle the circle problem: use two maxArray, one for 0...n-1, and another one for 1...n
        // ***: I stuck on different entries, I though they'd be different. however, it will be the same. Different entries
        // does not matter.
        // result: 1ms, fastest is 0ms.
        
        if (0 == nums.length) {
            return 0;
        }
        
        if (1 == nums.length) {
            return nums[0];
        }
        
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public static int robHelper (int[] nums, int front, int rear) {
        
        int len = rear - front + 1; 
        int[] maxProfit = new int[len];
        maxProfit[0] = nums[front];
        
        if (1 == len) {
             return maxProfit[0];
        }
        else {
             maxProfit[1] = Math.max(nums[front], nums[front + 1]);
             for (int i = 2; i < len; i ++) {
                 maxProfit[i] = Math.max(nums[i + front] + maxProfit[i - 2], maxProfit[i - 1]);
             }
        }
        
        // for the case that nums.length = 2, compare it again before return
        return maxProfit[len - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {5,1,2,10};
        
        int max = robHelper(nums, 0, nums.length - 1);
	}

}
