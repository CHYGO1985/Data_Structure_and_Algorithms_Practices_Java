package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 14, 2018
 *
 */
public class Temp {
	
	public boolean canJump(int[] nums) {
		
		if (nums == null) return true;
		
		int idx = 0;
		long max = 0;
		while (idx < nums.length && idx <= max) {
			max = Math.max(max, idx + nums[idx ++]);
		}
		
		return max >= nums.length - 1;
    }
	
	public static void main(String[] args) {
	}
}
