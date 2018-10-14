package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 14, 2018
 *
 */
public class Temp {
	
	public static int jump(int[] nums) {
		
		if (nums == null) return 0;
		
		int idx = 0, jump = 0;
		long preMax = 0, curMax = 0;
		
		while (idx < nums.length - 1) {
            // if (preMax >= nums.length - 1) return jump;
			curMax = Math.max(curMax, idx + nums[idx]);
			if (idx == preMax) {
				jump ++;
				preMax = curMax;
			}
			idx ++;
		}
		
		return jump;
    }
	
	public static void main(String[] args) {
	}
}
