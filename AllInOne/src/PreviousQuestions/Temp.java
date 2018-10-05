package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 5, 2018
 *
 */
public class Temp {
	
	public boolean canJump(int[] nums) {
		// far = -1;
		// iterate through, while (i < len && i <= far)
		// update far == max(i + nums[i], far)
		// return far >= nums.len - 1
		int far = 0, idx = 0;
		while (idx < nums.length && idx <= far) {
			far = Math.max(far, idx + nums[idx]);
		}
		
		return far >= nums.length - 1;
    }
}
