package src.Greedy;
/**
 * 
 * 55. Jump Game
 * 
 * @author jingjiejiang
 * @history last edited Aug 27, 2018
 * 
 * ref: https://leetcode.com/problems/jump-game/solution/
 * 
 */
public class JumpGame {

    // Greedy: theroute to get greedy is that for brutal force we need to mark every other point that we can reach 
    // from cur point
    // but then we can further optimize that only mark the furthest one, that is Greedy 
	public static boolean canJump(int[] nums) {
        
        // method 2
//        if (null == nums || 0 == nums.length) {
//            return false;
//        }
//        
//        int lastCon = nums.length - 1;
//        
//        for (int i = nums.length - 2; i >= 0; i --) {
//            if (nums[i] >= lastCon - i) {
//                lastCon = i;
//            }
//        }
//        
//        return 0 == lastCon? true : false;
        
        // method 3 (mine)
        assert nums != null && nums.length >= 1;
        
        int far = 0;
        
        for (int idx = 0; idx < nums.length && idx <= far; idx ++) {
            far = Math.max(far, idx + nums[idx]);
        }
        
        return far >= nums.length - 1;
    }


    // DP
    enum Index {
        GOOD, BAD, NNKNOW
    }

    public boolean canJump2(int[] nums) {

        Index[] memo = new Index[nums.length];
        for (int idx = 0; idx < memo.length; idx ++) {
            mem[idx] = Index.NNKNOW;
        }

        memo[memo.length - 1] = Index.GOOD;

        for (int idx = nums.length - 2; idx >= 0; idx --) {

            int furthestJump = Math.min(idx + nums[idx], nums.length - 1);
            for (int shift = idx + 1; shift <= furthestJump; shift ++) {
                if (memo[shift] == Index.GOOD) {
                    memo[idx] = Index.GOOD;
                    break;
                }
            }
        }

        return nums[0] == Index.GOOD;
    }
	
	public static void main(String[] args) {
	}
}
