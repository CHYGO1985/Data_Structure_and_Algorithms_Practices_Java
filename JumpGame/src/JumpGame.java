
public class JumpGame {
	
	public static boolean canJump(int[] nums) {
        // idea: method 1: DFS search method
        // for every element, search from 1 to max jump
        // 1) if reach the last ele, return true, finish the loop
        // 2) else if all the jump have been searched, then go to previous element
        
        // method 2: from i - 1 to start, to see whether the previous ele contains jump that can connect to last ele
        // use condition A: : junmp >= cur index - last connect index
        // 1) i - 1, if junmp >= cur index - last connect index, then last connect = i - 1, else = i
        // 2) i - 2, if A is true, then last connext = i - 2, else keep the original value
        // 3) i - 3 ...
        // until fist, if last conenct index != fist index, then return false
        // result: 7ms, beat 89%
        // things learned: array problem, can think from end to start
        
        // method 2
        if (null == nums || 0 == nums.length) {
            return false;
        }
        
        int lastCon = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i --) {
            if (nums[i] >= lastCon - i) {
                lastCon = i;
            }
        }
        
        return 0 == lastCon? true : false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
